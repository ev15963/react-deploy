package com.lsw;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EMPServlet
 */
@WebServlet("/EMPServletUpdate")
public class EMPServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EMPServletUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	Connection con = null;
	PreparedStatement pstmt = null;
	
	String sql_select_no = null;
	
	try {
		Class.forName(driver);
		con = DriverManager.getConnection(url, "lsw", "1234");
		sql_select_no = "select * from emp where no=?";
		
		pstmt=con.prepareStatement(sql_select_no);
		pstmt.setInt(1, Integer.parseInt(request.getParameter("n")));
		
		ResultSet rs=pstmt.executeQuery();
		
		if(rs!=null) {
			request.setAttribute("result", rs);
			
			RequestDispatcher rd = request.getRequestDispatcher("empUpdate.jsp");
			rd.forward(request, response);
		}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 ERR! : "+ e.getMessage());
		} catch(SQLException e) {
			System.out.println("SQL ERR! : "+ e.getMessage());
		} finally {
			try { //rs, pstmt, con 객체 close() 메서드를 호출해 해제
				if (pstmt != null) {
					pstmt.close();
				} 
			}catch (SQLException e) {
				System.out.println(e.getMessage()+"close 실패");
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//empUpdate.jsp의 <form>에 의해 자동호출
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql_insert = null;
		
		
		
		
	try {
		Class.forName(driver);
		con = DriverManager.getConnection(url, "lsw", "1234");
		sql_insert = "update emp set age=?, name=?, phone=?, ";
		sql_insert += "gender=?, job=?, pay=?, code=? ";
		sql_insert += " where no=?";
		
		pstmt=(PreparedStatement) con.prepareStatement(sql_insert);
		pstmt.setInt(1, Integer.parseInt(request.getParameter("age")));
		pstmt.setString(2, request.getParameter("name"));
		pstmt.setString(3, request.getParameter("phone"));
		pstmt.setString(4, request.getParameter("gender"));
		pstmt.setString(5, request.getParameter("job"));
		pstmt.setInt(6, Integer.parseInt(request.getParameter("pay")));
		pstmt.setString(7, request.getParameter("code"));
		pstmt.setInt(8, Integer.parseInt(request.getParameter("no")));
		
		int b = pstmt.executeUpdate();
		System.out.println(b+ "<==Update Record");
		
		if (b>0) { //true false
			response.sendRedirect("EMPServlet"); //특정조건일때 지정된 페이지로 이동
		}
	} catch (ClassNotFoundException e) {
		System.out.println("드라이버 ERR! : "+e.getMessage());
	} catch (SQLException e) {
		System.out.println("SQL ERR! : "+e.getMessage());
	} finally {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage()+"close 실패");
		}
	}
	}

}

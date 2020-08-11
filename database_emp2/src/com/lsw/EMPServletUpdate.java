package com.lsw;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	Connection con = null;
	PreparedStatement pstmt = null;
	
	String sql;
	
	try {
		Class.forName(driver);
		con = DriverManager.getConnection(url, "lsw", "1234");
		sql = "select * from emp where no=?";
		
		pstmt.setInt(1, Integer.parseInt(request.getParameter("n")));
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs!=null) {
			request.setAttribute("result", rs);
			
			RequestDispatcher rd = request.getRequestDispatcher("empUpdate.jsp");
			rd.forward(request, response);
		}
		} catch (ClassNotFoundException e) {
			System.out.println("driver err:"+e.getMessage());
		} catch (SQLException e) {
			System.out.println("con err:"+e.getMessage());
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			}catch (SQLException e) {
				System.out.println(e.getMessage()+"close 실패");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}

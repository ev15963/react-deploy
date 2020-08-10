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
@WebServlet("/EMPServletInsert")
public class EMPServletInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EMPServletInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		Connection con = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "lsw", "1234");
			
			String sql_max_no = "select max(no) from emp";
			stmt = con.createStatement();
			rs=stmt.executeQuery(sql_max_no);
			rs.next();
			int max_no=rs.getInt(1);
			

			sql="insert into emp (no, age, name, phone, gender, job, pay, code)"
					+ " values(?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, max_no+1);
			pstmt.setInt(2, Integer.parseInt(request.getParameter("age")));
			pstmt.setString(3, request.getParameter("name"));
			pstmt.setString(4, request.getParameter("phone"));
			pstmt.setString(5, request.getParameter("gender"));
			pstmt.setString(6, request.getParameter("job"));
			pstmt.setInt(7, Integer.parseInt(request.getParameter("pay")));
			pstmt.setString(8, request.getParameter("code"));
			
			request.setAttribute("result", rs);
			RequestDispatcher rd=request.getRequestDispatcher("EMPServlet"); //empList에서 바꿈
			rd.forward(request, response);
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 err! : "+e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL ERR! : "+ e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("자원해제 err! :"+ e.getMessage());
			}
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	

//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}

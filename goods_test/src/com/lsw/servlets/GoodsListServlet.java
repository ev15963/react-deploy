package com.lsw.servlets;

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

import com.lsw.dao.OracleDAO;

/**
 * Servlet implementation class GoodsListServlet
 */
@WebServlet("/GoodsListServlet")
public class GoodsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql_select_no = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "lsw", "1234");
			sql_select_no = "select * from store where no=?";
			
			pstmt=con.prepareStatement(sql_select_no);
			pstmt.setInt(1, Integer.parseInt(request.getParameter("n")));
			
			ResultSet rs=pstmt.executeQuery();
			
			if(rs!=null) {
				request.setAttribute("result", rs);
				
				RequestDispatcher rd = request.getRequestDispatcher("GoodList.jsp");
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

		
		
		
		
		
		
		OracleDAO dao = new OracleDAO();
		dao.connect();
		
		dao.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

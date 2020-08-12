package com.lsw.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsw.dao.BoardDAO;
import com.lsw.dto.BoardModel;

/**
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet("/BoardDelete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public BoardDeleteServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// boardView.jsp => "Get" => parameter no 값을 저장할 객체
		// 전달되는 parameter 명 : no
		BoardModel boardModel=new BoardModel();
		//////////////
		int n=Integer.parseInt(request.getParameter("no"));
		boardModel.setNo(n);
		
		BoardDAO dao = new BoardDAO();
		dao.connection();
		dao.delete(boardModel);
		dao.close();
		
		response.sendRedirect("boardList");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	

}

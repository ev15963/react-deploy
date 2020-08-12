package com.lsw.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsw.dao.BoardDAO;
import com.lsw.dto.BoardModel;

/**
 * Servlet implementation class BoardModifyServlet
 */
@WebServlet("/BoardModify")
public class BoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public BoardModifyServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//boardModify.jsp => "post" => parameter 값들을 저장할 객체
		//전달되는 parameter명 : subject, writer, contents
		BoardModel boardModel=new BoardModel();
		int n = Integer.parseInt(request.getParameter("no"));
		boardModel.setNo(n);
		
		BoardDAO dao=new BoardDAO();
		dao.connection();
		BoardModel boardOne=dao.selectOne(boardModel);
		dao.close();
		
		request.setAttribute("MODEL", boardOne);
		RequestDispatcher rd=request.getRequestDispatcher("boardModify_test.jsp");
		rd.forward(request, response);
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// boardModify.jsp => "post" => parameter 값들을 저장할 객체
		// 전달되는 parameter명 : subject, writer
		BoardModel boardModel = new BoardModel();
		
		int n=Integer.parseInt(request.getParameter("no"));
		boardModel.setNo(n);
		boardModel.setSubject(request.getParameter("subject"));
		boardModel.setWriter(request.getParameter("writer"));
		boardModel.setContents(request.getParameter("contents"));
		/////////////////////////////////
		
		BoardDAO dao = new BoardDAO();
		dao.connection();
		dao.delete(boardModel);
		dao.close();
		
		response.sendRedirect("boardList");
	}

}

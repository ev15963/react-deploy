package com.lsw.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsw.dao.BoardDAO;
import com.lsw.dto.BoardModel;

import oracle.net.aso.p;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/BoardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터
    	String pageNum = request.getParameter("pageNum");
    	String searchType = request.getParameter("searchType");
    	String searchText = request.getParameter("searchText");
    	
    	if(pageNum == null) {
    		pageNum = "1";
    	}
    	if(searchText == null) {
    		searchType= "";
    		searchText= "";
    	}
    	
    	//DTO
    	BoardModel bm = new BoardModel();
    	bm.setPageNum(pageNum);
    	
    	BoardDAO dao = new BoardDAO();
		BoardModel dto = new BoardModel();
		dao.connection();
		List<BoardModel> list = dao.selectList(dto);
		dao.close();
		
		//////////////
		
		
		request.setAttribute("LIST", list);
		RequestDispatcher rd = request.getRequestDispatcher("boardList.jsp");
		rd.forward(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath()); //Served at: /board_test
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

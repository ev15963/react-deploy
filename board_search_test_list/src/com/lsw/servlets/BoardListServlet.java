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
import com.lsw.util.PageNavigator;

import oracle.net.aso.p;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/boardList")
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
    	String pageNum = request.getParameter("pageNum");	//페이지 번호를 눌렀을 때 저장
    	String searchType = request.getParameter("searchType");	// 검색버튼을 눌렀을 때 저장
    	String searchText = request.getParameter("searchText");	// 검색버튼을 눌렀을 때 저장
    	
    	if(pageNum == null) {
    		pageNum = "1";
    	}
    	if(searchText == null) {
    		searchType= ""; //초기화 먼저 
    		searchText= "";
    	}
    	
    	//DTO
    	BoardModel bm = new BoardModel();
    	bm.setPageNum(pageNum);	//문자열 1
    	bm.setSearchType(searchType);
    	bm.setSearchText(searchText); //사용자가 입력한 검색어
    	
    	//DAO    	
    	BoardDAO dao = new BoardDAO(); //선언하고
		dao.connection(); //접속시키고
		
		//게시물 총 수
		int totalCount = dao.selectCount(bm);
		System.out.println(">>>>>>>>>>>>>>>>>>> totalCount <<<<<<<<<<<" + totalCount);
		
		//게실물 목록ㅇㄹ 얻는 쿼시 실행
		List<BoardModel> boardlist = dao.selectList(bm);
		dao.close();
		
		//////////////
		
		//view 사용될 객체  설정
		request.setAttribute("totalCount", boardlist);
		request.setAttribute("MODEL", bm);
		
		//페이지 번호 얻어내는 부분
		PageNavigator pageNavigator= new PageNavigator();
		String pageNums = pageNavigator.getPageNavigator
				(totalCount, bm.getListCount(), bm.getPagePerBlock(), 
						Integer.parseInt(pageNum), searchType, searchText);
		//totalCount, listCount, pagePerBlock, pageNum, searchType, searchText)
		
		System.out.println(">>>>>>>>>>>> pageNums <<<<<<<<<<<<<"+pageNums);
		request.setAttribute("PAGE_NAVIGATOR", pageNums);
		request.setAttribute("LIST", boardlist);
		request.setAttribute("MODEL", bm);
		
		//view 보내기
		RequestDispatcher rd = request.getRequestDispatcher("boardList.jsp");
		rd.forward(request, response); //은닉성, send뭐시기는 확인 가능 
//		response.getWriter().append("Served at: ").append(request.getContextPath()); //Served at: /board_test
	}


}

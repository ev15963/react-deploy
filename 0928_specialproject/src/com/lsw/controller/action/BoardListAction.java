package com.lsw.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsw.dao.BoardDAO;
import com.lsw.vo.BoardVO;

public class BoardListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/boardList.jsp"; //연결시킬jsp경로
		
		BoardDAO bDao = BoardDAO.getInstance();
		//DAO를 사용할 수 있게 해주는 getInstance() 싱글톤 메소드를 bDao에 담는다.
		List<BoardVO> boardList = bDao.selectAllBoards();
		//list<boardvo>의 bDao.selectAllboards()의 컬럼 값을 boardList 담는다.
		request.setAttribute("boardList", boardList);
		//request에 boardList라는 키로 DAO의 boardList(VO)값을 request영역에 저장
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
		//dispatcher (운행관리원 ).forward(앞세우다)는 웹브라우저에서 요청한 주소를 유지한 상태서 다른 창의 내용을 뜯록하는 것
		//forward인자중 request는 do(가상주소 현재는 BoardServlet ) 입력시 창 주소그대로 response로 view.boardList.jsp 경로의
		//파일로 연결해서 띄운다.
	}

}


//String url = "/board/boardList.jsp";
//System.out.println(url+"---------------"); //점검심 웹브라우져 확인 
//
//BoardDAO bDao = BoardDAO.getInstance(); //db건드는 액션은 다 필요
//List<BoardVO> boardList = bDao.selectAllBoards();
////System.out.println(boardList.size());//값의 크기 확인 
////System.out.println(boardList.get(0).toString()); //재정의한 값확인
//
////jsp확인
//
//request.setAttribute("boardList", boardList);
//RequestDispatcher disp = request.getRequestDispatcher(url);
//System.out.println("request"+request);
//System.out.println("url"+url);
//System.out.println("disp"+disp);
//disp.forward(request, response);
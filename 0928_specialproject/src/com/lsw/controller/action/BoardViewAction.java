package com.lsw.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsw.dao.BoardDAO;
import com.lsw.vo.BoardVO;

public class BoardViewAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="view/boardView.jsp";
		String num = request.getParameter("num");
		//List.jsp(view)에서 request영역으로 보낸 num키의 값을 담는다.
		
		BoardDAO bDao = BoardDAO.getInstance();
		//BoardDAO를 사용할 싱글톤 bDao객체로 담는다.
		
		bDao.updateReadCount(num);
		//DAO의 조회수 올리는 num키의 값을 보낸다.
		//update boardtest1 set readcount = readcount+1 where num=? 쿼리가 담겨있는 메서드 호출
		
		BoardVO bVo = bDao.selectOnBoardByNum(num); //글번호로 찾아오기
		//VO의 DAO에 selectOnBoardByNum() 메서드 (num의 조건에 해당하는 컬럼의 값을 저장하는 쿼리가 담겨있다.)
		
		request.setAttribute("board", bVo); //request영역에 board키로 bVo값들을 저장
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}

package com.lsw.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsw.dao.BoardDAO;
import com.lsw.dto.BoardVO;

public class BoardListAction implements Action{


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "/board/boardList.jsp";
		System.out.println(url+"---------------"); //점검심 웹브라우져 확인 
		
		BoardDAO bDao = BoardDAO.getInstance(); //db건드는 액션은 다 필요
		List<BoardVO> boardList = bDao.selectAllBoards();
//		System.out.println(boardList.size());//값의 크기 확인 
//		System.out.println(boardList.get(0).toString()); //재정의한 값확인
		
		//jsp확인
		
		request.setAttribute("boardList", boardList);
		RequestDispatcher disp = request.getRequestDispatcher(url);
		System.out.println("request"+request);
		System.out.println("url"+url);
		System.out.println("disp"+disp);
		disp.forward(request, response);
	}

}

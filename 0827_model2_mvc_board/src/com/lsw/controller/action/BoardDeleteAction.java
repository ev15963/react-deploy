package com.lsw.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsw.dao.BoardDAO;

public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "/board/boardList.jsp";
		System.out.println(url + "---------------"); // 점검심 웹브라우져 확인

		// 넘버를 선언해줘야하는가 받고 받은걸?????????		// BoardVO bVO = new BoardVO();		// 파라미터 요청한걸 가져온다....
		String num = request.getParameter("num");

		// 메서드에 넣고
		BoardDAO dao = BoardDAO.getInstance();

		// 호출
		dao.deleteBoard(num);

		new BoardListAction().execute(request, response);

		// System.out.println(boardList.size());//값의 크기 확인
		// System.out.println(boardList.get(0).toString()); //재정의한 값확인

		// jsp확인
		// request.setAttribute("boardList", boardList);
		// RequestDispatcher disp = request.getRequestDispatcher(url);
		// System.out.println("request"+request);
		// System.out.println("url"+url);
		// System.out.println("disp"+disp);
		// disp.forward(request, response);
		
		// 쿼리 가져오기
		// 삭제
	}

}

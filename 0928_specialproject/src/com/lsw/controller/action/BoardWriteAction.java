package com.lsw.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsw.dao.BoardDAO;
import com.lsw.vo.BoardVO;

public class BoardWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO bVo = new BoardVO();
		
		bVo.setName(request.getParameter("pass"));
		bVo.setEmail(request.getParameter("email"));
		bVo.setTitle(request.getParameter("title"));
		bVo.setContent(request.getParameter("content"));
		
		BoardDAO bDao=BoardDAO.getInstance();
		//BoardDAO를 사용할 싱글톤을 bDao에 담는다.
		bDao.insertBoard(bVo);
		//bDao에 있는 insertBoard(게시글 입력하기) 메서드에 bVo객체의 값을 담는다.
		
		new BoardListAction().execute(request, response);
		//BoardListAction.java의 BoardListAction로 List창으로 가게한다.
		//이때 위에서 코드으 bVo에 저장되어있는 값을읽어
		//BoardListActiond에서 List에 뿌려주어
		//execute로 실행하게 된다. execute - SQL문이 무엇인지 모를 때 사용
	}
	
}

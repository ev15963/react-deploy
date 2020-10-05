package com.lsw.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsw.dao.BoardDAO;
import com.lsw.vo.BoardVO;

public class BoardUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO bVo = new BoardVO();
		
		bVo.setNum(Integer.parseInt(request.getParameter("num")));
		//VO에 Num에 저장한다.
		//Integer(int)형식으로 되어 있어 바꾼후 parseInt 값을 정수로 잘라내는 메소드이다.
		//request영역에 저장되있는 파라미터 num키 jsp input의 num)의 값을 불러온다.
		
		bVo.setName(request.getParameter("name"));
		bVo.setPass(request.getParameter("pass"));
		bVo.setEmail(request.getParameter("email"));
		bVo.setTitle(request.getParameter("title"));
		bVo.setContent(request.getParameter("content"));
		
		BoardDAO bDao = BoardDAO.getInstance(); //BoardDAO를 사용할 싱글톤을 bDao에 담는다.
		bDao.updateBoard(bVo); //bDao에 있는 updateBoard(게시글 수정하기)메서드에 bVo객체의 값을 담는다.
		
		new BoardListAction().execute(request, response);
		//BoardListAction.java의 BoardListAction로 List창으로 가게 한다.
		//이 때 위에서 코드의 bVo에 저정되어있는 값을 읽어
		//BoardListAction에서 list에 뿌려주어
		//execute로 실행하게 한다. execute SqL문이 무엇인지 모를 때 사용
	}

}

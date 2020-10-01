package com.lsw.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsw.dao.BoardDAO;

public class BoardDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num"); //request로 받은 파라미터 num값
		
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.deleteBoard(num); //num에 해당되는 글을 삭제
		//delete boardtest1 where num=? 게시글 삭제 DAO
		
		new BoardListAction().execute(request, response);
		
	}

}

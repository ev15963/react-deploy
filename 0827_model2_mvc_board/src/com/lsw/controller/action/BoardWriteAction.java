package com.lsw.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsw.dao.BoardDAO;
import com.lsw.dto.BoardVO;

public class BoardWriteAction implements Action{


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardVO bVo = new BoardVO();
		bVo.setName(request.getParameter("name"));
		bVo.setPass(request.getParameter("pass"));
		bVo.setEmail(request.getParameter("email"));
		bVo.setTitle(request.getParameter("title"));
		bVo.setContent(request.getParameter("content"));
		
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.insertBoard(bVo);
		
		new BoardListAction().execute(request, response);
		
//		BoardListAction cc=new BoardListAction();
//		cc.execute(request, response);
		
//		String url = "/board/boardWrite.jsp";
//		RequestDispatcher rd = request.getRequestDispatcher(url);
//		rd.forward(request, response);
	}

}

package com.lsw.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsw.dao.BoardDAO;
import com.lsw.dto.BoardVO;

public class BoardUpdateFormAction implements Action{


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/board/boardUpdate.jsp";
		String num = request.getParameter("num");
		
		BoardDAO bDao = BoardDAO.getInstance();
		
		BoardVO bVo = bDao.selectOneBoardByNum(num);
		
		request.setAttribute("border", bVo);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}

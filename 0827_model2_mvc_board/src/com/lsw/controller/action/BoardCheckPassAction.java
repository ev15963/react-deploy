package com.lsw.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsw.dao.BoardDAO;
import com.lsw.dto.BoardVO;

public class BoardCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		String num = request.getParameter("num");
		String pass = request.getParameter("pass");

		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO bVo = bDao.selectOneBoardByNum(num);

		if (bVo.getPass().equals(pass)) { // 가져온 비밀번호와 입력한 비밀번호가 같은지 비교
			url = "/board/checkSuccess.jsp";
		} else {
			url = "/board/boardCheckPass.jsp";
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
v
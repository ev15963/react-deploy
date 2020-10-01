package com.lsw.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsw.vo.BoardVO;

public class BoardUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Board bVo = new BoardVO();
		
		bVo.setNum(Integer.parseInt(request.getParameter("num")));
		//VO에 ㅜㅕㅡ
	}

}

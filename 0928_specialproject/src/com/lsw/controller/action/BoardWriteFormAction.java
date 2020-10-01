package com.lsw.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardWriteFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/boardWrite.jsp";
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		
		disp.forward(request, response);
		//request로 받은 dispatcher의 주소의 가상주소(BoardServlet)을 request받고 
		//url값의 주소를 response로 내보내서 연결
	}

}

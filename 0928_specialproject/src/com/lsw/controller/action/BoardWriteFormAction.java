package com.lsw.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
	//게시글 등록을 위한 폼으로 이동하게하는 액션클래스
public class BoardWriteFormAction implements Action{
	// 인터페이스인 Action을 implements(구현) 받을 때 꼭 안에 있는 메서드를 Override하여 다 적어야한다.

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/boardWrite.jsp"; //boardWrite 경로(게시글 등록하는 from이 있는 jsp)
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		//request안의 getRequestDispatcher에 url값을 인자로 담아
		//RequestDispatcher dispatcher에 담는다
		
		disp.forward(request, response);
		//request로 받은 dispatcher의 주소의 가상주소(BoardServlet)을 request받고 
		//url값의 주소를 response로 내보내서 연결
	}

}

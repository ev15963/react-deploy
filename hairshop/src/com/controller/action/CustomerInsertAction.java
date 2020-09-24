package com.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.hairVO;

public class CustomerInsertAction implements Action {

	public CustomerInsertAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		hairVO hVO = new hairVO();
		
		hVO.setId(request.getParameter("id"));
		hVO.setPw(request.getParameter("pw"));
		hVO.setName(request.getParameter("name"));
		hVO.setPhoneNumber(request.getParameter("phoneNumber"));
		hVO.setAddress(request.getParameter("address"));
		hVO.setEnroll(request.getParameter("enroll"));
	
		new CustomerListAction().execute(request, response);
	}

}

package com.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.hairVO;

public class CusResUpdateAction implements Action {

	public CusResUpdateAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		hairVO hvo = new hairVO();
		
		hvo.setRsv_date(request.getParameter("rsv_date"));
		hvo.setRsv_time(request.getParameter("rsv_time"));
		hvo.setRsv_status(request.getParameter("p_type"));
		hvo.setName(request.getParameter("id"));
		hvo.setPhoneNumber(request.getParameter("phoneNumber"));
		hvo.setRsv_date(request.getParameter("rsv_date"));
		hvo.setP_type(request.getParameter("p_type"));

		new CustomerListAction().execute(request, response);
		
	}

}

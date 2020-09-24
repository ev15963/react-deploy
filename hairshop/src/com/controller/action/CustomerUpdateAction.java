package com.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.hairVO;

public class CustomerUpdateAction implements Action {

	public CustomerUpdateAction() {
		// TODO Auto-generated constructor stub
	}
	//9.24
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		hairVO hVO = new hairVO();
		
		hVO.setRsv_date(request.getParameter("rsv_date"));
		hVO.setRsv_time(request.getParameter("rsv_time"));
		hVO.setRsv_status(request.getParameter("p_type"));
		hVO.setName(request.getParameter("id"));
		hVO.setPhoneNumber(request.getParameter("phoneNumber"));
		hVO.setRsv_date(request.getParameter("rsv_date"));
		hVO.setP_type(request.getParameter("p_type"));

		new CustomerListAction().execute(request, response);

	}

}

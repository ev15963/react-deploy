package com.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.hairDAO;

public class CustomerDeleteAction implements Action {
	//9.24
	public CustomerDeleteAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("ii");
		
		hairDAO hDAO = hairDAO.getInstance();
		
		hDAO.costomer_delete(num);
		
		new CustomerDeleteAction().execute(request, response);
	}

}

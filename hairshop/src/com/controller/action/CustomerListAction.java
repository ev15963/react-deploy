package com.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.*;
import com.dto.*;

public class CustomerListAction implements Action {

	public CustomerListAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "admin/CustomerList.jsp";

		hairDAO hDAO = hairDAO.getInstance();
		
		ArrayList<hairVO> hVO = hDAO.costmoer_selectList();
		
		request.setAttribute("hVO", hVO);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
package com.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HairDAO;
import com.dto.HairVO;

public class CustomerUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "HairshopServlet?customer_detail.jsp";
			
			HairDAO hDao = HairDAO.getInstance();
			HairVO hVo = new HairVO();

//			hVo.setId(request.getParameter("id")); 
//			hVo.setName(request.getParameter("name"));
//			hVo.setPhoneNumber(request.getParameter("phone"));
//			hVo.setAddress(request.getParameter("address"));
//			hDao.customer_detailUpdate(hVo); // 고객 정보 업데이트

			String[] dateArr = request.getParameterValues("p_enroll");
			String[] typeArr = request.getParameterValues("p_type");
			
			for(String date : dateArr && type : typeArr) {
				System.out.println(date);
				System.out.println(typeArr);
			}
//			hDao.customer_ProcedureUpdate();
			
			
//			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//			dispatcher.forward(request, response);
	}

}

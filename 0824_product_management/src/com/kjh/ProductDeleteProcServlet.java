package com.kjh;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteProc")
public class ProductDeleteProcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductDeleteProcServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnectionMgr pMgr = new DBConnectionMgr();
		System.out.println(request.getParameter("code"));
		int code = Integer.parseInt(request.getParameter("code"));
		pMgr.deleteProduct(code);
		pMgr.close();
		response.sendRedirect("productList.jsp");
	}

}

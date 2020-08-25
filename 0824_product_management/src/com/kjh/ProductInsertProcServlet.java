package com.kjh;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class productInsertProc
 */
@WebServlet("/InsertProc")
public class ProductInsertProcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProductInsertProcServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnectionMgr pMgr = new DBConnectionMgr();
		ProductBean pBean = new ProductBean();
		request.setCharacterEncoding("UTF-8");
		
		pBean.setName(request.getParameter("name"));
		int price = Integer.parseInt(request.getParameter("price"));
		pBean.setPrice(price);
		pBean.setDescription(request.getParameter("description"));
		
		pMgr.insertProduct(pBean);
		pMgr.close();
		
		response.sendRedirect("productList.jsp");
		
		
	}

}

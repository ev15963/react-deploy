package com.lsw.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsw.dao.OracleDAO;
import com.lsw.dto.GoodsDTO;

/**
 * Servlet implementation class GoodsEntryServlet
 */
@WebServlet("/goodsEntry")
public class GoodsEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsEntryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsDTO dto=new GoodsDTO();
		
		//request.getParameter 추가
		int code=Integer.parseInt(request.getParameter("code"));
		dto.setCode(code);
		
		String product=request.getParameter("product");
		dto.setProduct(product);
		
		String content=request.getParameter("content");
		dto.setContent(content);
		
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		dto.setQuantity(quantity);
		
		int discount=Integer.parseInt(request.getParameter("discount"));
		dto.setDiscount(discount);

		int delivery_charge=Integer.parseInt(request.getParameter("delivery_charge"));
		dto.setDelivery_charge(delivery_charge);
		
		int price=Integer.parseInt(request.getParameter("price"));
		dto.setPrice(price);
		
		String name=request.getParameter("name");
		dto.setName(name);
		
		
		OracleDAO dao = new OracleDAO(); //개체 먼저 생성
		dao.connect(); //개체가 갖고 있는  connect() 메소드 호출
		dao.insert(dto);
		dao.close();
		
		response.sendRedirect("goodList"); //get 방식 전송
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

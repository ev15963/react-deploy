package com.lsw;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdderServlet
 * HttpServlet implements Servlet
 */
@WebServlet("/adder") // webServlet addtion : 서블릿클래스에 대한 웹 명칭을 선언해주는 어노테이션
public class AdderServlet extends HttpServlet { //톰켓서버가 서블릿클래스를 구별해줄수 있느 상수여서 절대 수정 불가능
	private static final long serialVersionUID = 1L; //상속받은 http 서블릿 클래스가 서블릿을 구현받았기 때문
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdderServlet() {
        super(); //부모생성자에 의해서 초기화된다.
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub			https://localhost:9000//test2/adder
		// 출력물 확인
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// PrinterWriter	
	
	
			int total=0;
			for(int cnt=1; cnt<=100; cnt++) {
				total+=cnt;
			}
			request.setAttribute("result", total);
			RequestDispatcher rd=request.getRequestDispatcher("Hundred.jsp");
			rd.forward(request, response);
			
		
	}

}

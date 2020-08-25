package com.lsw;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/productWrite.do")
public class ProductWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispa = request.getRequestDispatcher("productWrite.jsp");
		dispa.forward(request, response);
		
		//<form method="post" encType="mutipart/form=data" name="frm">의
		//action="" 값이 없을 경우 호출된 자기 자신에게 전송하기 때문에
		//response.sendRedirct("productWrite.jsp"); 를 사용하지 않음
		
		//RequestDispatcher.forward() : 웹 경로 변경하지 않음
		//							  : http://~~~~/프로젝트명/productWrite.do 유지
		//response.sendRd
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ServletContext context = getServletContext(); 
		//현재 실행하고 있는 웹 어플리케이션이 설정되므로
		//먼저 웹어플리케이션 경로추출하고
		
		String path= context.getRealPath("upload");
		String encType="UTF-8";
		int sizeLimit = 20 * 1024* 1024;
		
		// <form method="post" enctype="multipart/form-data" name="frm">에
		// enctype="mutipart/form-data" 같이 설정 되어 있기 때문에
		// request.getParameter()를 사용 못하고
		// MultipartRequest 객체를 통해서 파라미터 값을 추출
		
		
		MultipartRequest mt = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		//MultipartRequest 객체가 생성될 때 파일은 자동 업로드
		
		String name = mt.getParameter("name");
		int price = Integer.parseInt(mt.getParameter("price"));
		String description =mt.getParameter("description");
		String pictureUrl =mt.getFilesystemName("pictureUrl");
		
		ProductVO pVo = new ProductVO();
		pVo.setName(name);
		pVo.setPrice(price);
		pVo.setDescription(description);
		pVo.setPictureUrl(pictureUrl);
		
		ProductDAO pDao = ProductDAO.getInstance();
		pDao.insertProduct(pVo); //실제로는 파일명이 저장
		response.sendRedirect("productList.do"); //list로 돌아감
		//오류테스트시 연동되는 구간 막고 실행
	}

}

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
@WebServlet("/productUpdate.do")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		ProductDAO pDao = ProductDAO.getInstance();
		ProductVO pVo = pDao.selectProductByCode(code);
		
		request.setAttribute("product", pVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("productUpdate.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		String encType = "UTF-8";
		int sizeLimit =20 * 1024 *1024;
		
		MultipartRequest mt = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());

		String code = mt.getParameter("code");
		String name = mt.getParameter("name");
		int price = Integer.parseInt(mt.getParameter("price"));
		String description = mt.getParameter("description");
		String pictureUrl = mt.getFilesystemName("pictureUrl");
		
		if (pictureUrl == null) { //추가된 부분 write.jsp
			pictureUrl = mt.getParameter("nonmakeImg");
		}
		
		ProductVO pVo = new ProductVO();
		pVo.setCode(Integer.parseInt(code));
	}

}

package com.lsw;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		//여기를 바꿔주면 다운 받는 경로가 바뀜(단, 실제 존재하는 폴더를 지정)
		String savePath = "upload";
		
		//최대 업로드 파일 크기 5MB로 전환
		int uploadFileSizeLimit = 5 * 1024 * 1024;
		
		String encType="UTF-8";
		
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("서버상의 실제 디렉토리");
		System.out.println(uploadFilePath);
		
		try {
		MultipartRequest mt = new MultipartRequest(request,							//request 객체 
												   uploadFilePath, 					//서버상의 실제 디렉토리
												   uploadFileSizeLimit, 			//최대 업로드 파일 크기
												   encType, 						//인코딩 방법
												   new DefaultFileRenamePolicy());	//동일한 이름이 존재하면 새로운 이름이 부여됨
		
		//업로드된 파일의 이름 얻기 : <input type="file" />의 파리미터명 파일 혼자 올릴때
		String fileName = mt.getFilesystemName("uploadFile");
		
		if (fileName == null) {
			System.out.println("파일 업로드 되지 않았음");
		} else {
			out.println("<br /> 글쓴이 : "+mt.getParameter("name"));
			out.println("<br /> 제 &nbsp; : "+mt.getParameter("title"));
			out.println("<br /> 파일명 : "+fileName);
		} //else
		
		} catch (Exception e) {
			System.out.println("예외 발생 : "+e);
		}
		doGet(request, response);
	}

}

package com.lsw;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

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
@WebServlet("/upload2.do")
public class MultiUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		
		//업로드된 파일의 이름 얻기 : <input type="file" />의 파리미터명 파일 여러개 올릴때

		Enumeration files = mt.getFileNames();
		
		while(files.hasMoreElements()) {
				String file = (String) files.nextElement();
				String file_name = mt.getFilesystemName(file);
				
				//중복된 파일을 업로드할 경우 파일명이 바뀐다. (~~1,~~ / ~~2.~~)
				//getOriginalFileName()은 변경되기전 이름을 추출...
				String ori_file_name=mt.getOriginalFileName(file);
				
				out.print("<br> 업로드된 파일명 :"+file_name);
				out.print("<br> 원본 파일명 : "+ori_file_name);
				out.print("<hr>");
			}
		}catch(Exception e) {
			System.out.println("예외 발생 : "+e);
		} //catch
				
	} //doPost() end

}

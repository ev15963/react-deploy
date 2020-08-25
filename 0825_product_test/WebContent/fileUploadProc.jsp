<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>

<%
	request.setCharacterEncoding("UTF-8");
	String uploadPath=request.getRealPath("upload");
	
	int size = 10*1024*1024;
	String name="";
	String subject="";
	String filename1="";
	String filename2="";
	
	try {
		MultipartRequest multi=new MultipartRequest(request,		//request 객체
															uploadPath,	//서버상의 살제 디렉토리
															size,		//최대 업로드 파일 크기
															"UTF-8",	//인코딩 방법
															new DefaultFileRenamePolicy());
															// 동일한 이름이 존재하면 새로운 이름이 부여됨
		
		name=multi.getParameter("name");
		subject=multi.getParameter("subject");
		
		Enumeration files=multi.getFileNames();	//input type="file" 로 선택한 파일들

		String file1=(String)files.nextElement();
		filename1=multi.getFilesystemName(file1);
		
		String file2=(String)files.nextElement();
		filename2=multi.getFilesystemName(file2);
		
	}catch(IOException e) {
		System.out.println("File io err =>" +e.getMessage());
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일 업로드 : fileUploadProc</title>


</head>
<body>
<form name="filecheck" action="fileCheck.jsp" method="post">
	<input type="hidden" name="name" value="<%=name %>">
	<input type="hidden" name="subject" value="<%=subject %>">
	<input type="hidden" name="filename1" value="<%=filename1 %>">
	<input type="hidden" name="filename2" value="<%=filename2 %>">
</form>

<%--
		<form> 태그의 name 속성을 이용하여 javaScript함수를 이용하여
		서버로 전송(submit()함수)하는 방법
 --%>
	 <a href="#" onclick="javascript:filecheck.submit()"> 
	 업도르 확인 및 다운로드 페이지 이동
	 </a>
</body>
</html>
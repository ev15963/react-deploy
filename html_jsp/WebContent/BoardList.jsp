<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardPost.jsp</title>
</head>
<body>
<h2>글 파일 저장</h2>

<%
	File f=new File("c:/bbs");
	String[] filenames=f.list();
	for(String f_name:filenames)
		out.println(f_name+"<br/>");
	
	%>
	
	
<button onclick = "location.href='index.html'">글쓰기</button>
</body>
</html>
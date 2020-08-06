<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String appPath = application.getContextPath();
		String filePath = application.getRealPath("application_test.jsp");
	%>
	웹 어플리케이션 URL 경로명 : <%= appPath %> <br/>
	.jsp 파일의 경로명 : <%= filePath %>
</body>
</html>
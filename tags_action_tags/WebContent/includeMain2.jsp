<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta  charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>includeMain2.jsp 페이지입니다.</h2>
<%
request.setCharacterEncoding("UTF-8");
String siteName = request.getParameter("siteName");
%>

<hr>
<jsp:include page = "includeSub2.jsp">
<jsp:param value="네이버" name="siteName2" />
</jsp:include> <hr>
includeMain2.jsp의 내용입니다.
</body> 
</html>
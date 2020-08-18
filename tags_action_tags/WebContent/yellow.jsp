<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>포워딩되는 페이지 (yellow.jsp)</h1><hr>
	<%
		String color = request.getParameter("color");
		String name = request.getParameter("name");
	%>

	<b><%=name%>님의 좋아하는 색은 <%=color%>이고 자기탐구와 내적 성장을 상징하는 색입니다. </b>
	<p>
		<img src="<%=color%>.jpg">
</body>
</html>
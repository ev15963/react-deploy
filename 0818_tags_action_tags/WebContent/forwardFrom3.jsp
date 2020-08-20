<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forwardFrom</title>
</head>
<body>
<h2>포워딩하는 페이지 : forwardTagFrom2.jsp</h2>
	<%
		request.setCharacterEncoding("UTF-8");
		String name =request.getParameter("name");
		String selectedColor = request.getParameter("color"); //name값으로 가져와 value로
	%>
	<!-- 별도의 파라미터와 값을 전달하고 싶은 경우 -->
	<jsp:forward page="<%=selectedColor+\".jsp\"%>" >
	<jsp:param value="<%=selectedColor %>" name="selectedColor" />
	<jsp:param value="<%=name %>" name="name" />
	</jsp:forward>
</body>
</html>
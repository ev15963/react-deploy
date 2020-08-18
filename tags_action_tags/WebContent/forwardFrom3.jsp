<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forwardFrom</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String color = request.getParameter("color") + ".jsp"; //name값으로 가져와 value로
	%>
	<jsp:forward page="<%=color%>" />

</body>
</html>
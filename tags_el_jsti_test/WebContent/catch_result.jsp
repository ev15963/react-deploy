<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>catch_result.jsp</title>
</head>
<body>
	<c:catch var="myError">
		<%
			int x = 10 / 0;
		%>
	</c:catch>

	<c:if test="${myError != null }">
		${myError.message }
	</c:if>
</body>
</html>
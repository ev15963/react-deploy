<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>반복</h3>

	<h4>&lt;c:forEach></h4>
	<%-- <c:forEach> 범위 설정 --%>

	<c:forEach var="one" begin="1" end="10" step="2">
		<c:out value="${one}" />
	</c:forEach>

</body>
</html>
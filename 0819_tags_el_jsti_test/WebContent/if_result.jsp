<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>if_result.jsp</title>
</head>

<body>
	<c:set var="age" value="<%= 10%>"> </c:set>
	<!--  int age=10 -->
	
	${age}는 20과
	<c:if test = "${age}==20">
	같은 숫자입니다.(조건의 결과가 true 일 경우만)
	</c:if>
	
	다른 숫자입니다.
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>url_result.jsp</title>
</head>
<body>
<c:url var="nameSend" value="test_result.jsp">
<c:param name="name" value="free"></c:param>
</c:url>

<a href='<c:out value="${nameSend }"></c:out>'>URL</a>

<c:url value="/images/gb.jpg" />
<img src="<c:url value="/images/gb.jpg"/>">

<c:url var="img" value="/images/gb.jpg"/>
<img src='<c:out value="${img }"></c:out>' />

<hr>
<c:set var="url" value="https://google.com/" />
<c:import url= "${url }" var="u" />
<c:out value="${u }" />
<hr>

</body>
</html>
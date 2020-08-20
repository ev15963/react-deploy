<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String[] stringArray={"aa", "bb", "cc", "dd" };
	request.setAttribute("strArr", stringArray);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>for_each_result.jsp</title>
</head>

<body>
	<table border="1">
	
	<!-- for( : ) { } -->
		<c:forEach var="str" items= "${strArr}">
		<tr>
			<td>${str}</td>
		</tr>
		</c:forEach>
			
	</table>
</body>
</html>
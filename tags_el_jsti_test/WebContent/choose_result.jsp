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
	<c:set var="gender" value="<%=1%>"></c:set>
	<!-- if() {} else if() {}else if(){}else{} -->
	<c:choose>
		<c:when test="${gender==1}">
			남자입니다.
		</c:when>

		<c:when test="${gender==2}">
		여자입니다.
		</c:when>
		
		<c:otherwise>
		그외? 혹
		</c:otherwise>

	</c:choose>

</body>
</html>
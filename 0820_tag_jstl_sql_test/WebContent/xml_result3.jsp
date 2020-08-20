<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:import charEncoding="UTF-8" url="namecard.xml" var="xmldata"/>
	
	<%-- text를 xml 형태로 파싱!!! --%>
	<x:parse xml="${xmldata }" var="xdata" />
	
	<%-- Xpath를 이용해서 xdata에서 추출 --%>
	<x:out select="$xdata//person[1]/name"/>
	<x:out select="$xdata//person[last()]/name"/>
	<hr>
	<%-- person 으로 반복해서 email과 phone 출력 --%>
	<table border="1">
		<x:forEach select="$xdata//person"> <%-- 삼항연산 --%>
		<tr>
		<td><x:out select="email"/></td>
		<td><x:out select="phone"/></td>
		</tr>
		</x:forEach>
	</table>
</body>
</html>
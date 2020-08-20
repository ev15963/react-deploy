<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%
	response.setContentType("text/html;");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- xml 데이터를 xdata 변수에 할당 --%>
	<x:parse var="xdata"> <%-- parse 작업으로 탭 띄어쓰기 가능 --%>
	<namecard>
	<person>
		<name>허광남</name>
		<id>남자</id>
		<email>kenu@email.com</email>
		<phone>111-2222-3333</phone>
	</person>
	
	<person>
		<name>노재충</name>
		<id>남자</id>
		<email>suribada@email.com</email>
		<phone>222-3333-4444</phone>
	</person>
	
	<person>
		<name>이선재</name>
		<id>남자</id>
		<email>hsboy@email.com</email>
		<phone>333-4444-5555</phone>
	</person>
</namecard>
	
	</x:parse>

	<%-- Xpath를 이용해서 xdata에서 추출 --%>
	<x:out select="$xdata//person[1]/name"/>
	<x:out select="$xdata//person[last()]/name"/>
	<hr>
	<%-- person 으로 반복해서 email과 phone 출력 --%>
	<table border="1">
		<x:forEach select="$xdata//person">
		<tr>
		<td><x:out select="email"/></td>
		<td><x:out select="phone"/></td>
		</tr>
		</x:forEach>
	</table>

</body>
</html>
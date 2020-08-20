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
	<%-- 파라이터 받아서 출력 
		만역 전달되는 name 파라미터 값이 있으면
		name 파라미터 값을  출력
		따라서 처음 실행하면 출력값이 없고,
		아래의 <input>에 의해 값이 전달 될 경우에만 출력.. --%>
	<c:if test="${!empty param.name }"> <%-- 비어있으면 true --%>
		param: <x:out select="$param:name" />
	</c:if>
	
	<%-- <form>의 action 속성값을 설정 하지 않으면 자기 자신에게 전달 --%>
	<form>
		name: <input type="text" name="name" required="required" />
		 <input type="submit" value="자신에게 전송" />
	</form>

</body>
</html>
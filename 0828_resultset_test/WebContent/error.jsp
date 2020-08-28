<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%-- 현재 페이지가 에러 페이지임을 설정 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 페이지 : error.jsp</title>
</head>
<body>
다음고 같은 에러가 발생했습니다. <br>
<%= exception.getMessage() %> <br>
동일한 메일주소가 있습니다.
</body>
</html>
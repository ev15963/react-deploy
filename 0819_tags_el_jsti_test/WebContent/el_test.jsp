<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el_test.jsp</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<!-- el.test.jsp?NAME=ㅁㅁ -->
당신의 이름은 ${param.NAME}입니다.
</body>
</html>
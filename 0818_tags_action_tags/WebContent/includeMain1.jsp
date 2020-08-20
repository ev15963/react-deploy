<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>includeMain1.jsp</title>
</head>
<body>
<h1>포함하는 페이지 includeMain.jsp입니다.</h1>

<% request.setCharacterEncoding("UTF-8"); %>
<hr> <!-- 구분선 -->

<jsp:include page="includeSub1.jsp" />
<!--  처리된 결과 내용을 출력 -->

includeMain.jsp의 나머지 내용입니다.
</body>
</html>
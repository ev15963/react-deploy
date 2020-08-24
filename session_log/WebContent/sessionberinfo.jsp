<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//setMemberInfo.jsp
// JSP는 session이 내장객체로 존재 
	session.setAttribute("MEMBERID", "lsw"); //웹서버 임시저장소
	session.setAttribute("NAME", "1234"); // getAttribute
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>세션에 정보 저장</title>
</head>
<body>
	세션에 정보를 저장하였습니다.
</body>
</html>
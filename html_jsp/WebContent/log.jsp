<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>log.jsp : html JSP </title>
</head>
<body>
<%= request.getParameter("num1") %>
<br />
<%= request.getParameter("num2") %>

<%
int n1=Integer.parseInt(request.getParameter("num1"));
int n2=Integer.parseInt(request.getParameter("num2"));
%>

<%= n1+n2 %>
</body>
</html>
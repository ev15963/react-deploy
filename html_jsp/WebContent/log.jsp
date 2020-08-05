<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ page import = "java.util.Calendar" %>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>log.jsp : html JSP</title>
</head>
<body>
	<%=request.getParameter("num1")%>
	<br />
	<%=request.getParameter("num2")%>

	<%
		int n1 = Integer.parseInt(request.getParameter("num1"));
		int n2 = Integer.parseInt(request.getParameter("num2"));
	%>

	<%=n1 + n2%>

	지금 :
	<%=new java.util.Date()%>
	<%
		String bookTitle = "JSP프로그래밍";
		String author = "최범균";
	%>
	<b><%=bookTitle%></b> (<%=author%>)입니다.
	
	<%-- <%@ page contentType="text/h" %>--%>

	<%--
	<%
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
	%>
	a*b=<%= a * b %>
	a*b=${ param.a*param.b }
	 --%>
	 <%--
	 <%
	 Calendar cal = Calendar.getInstance();
	 %>
	 오늘은
	 <%= cal.get(Calendar.YEAR) %>년
	 <%= cal.get(Calendar.MONTH) %>월
	 <%= cal.get(Calendar.DATE) %>일
	 입니다.
	 --%>
	 
	 <%-- import 없이 출력 --%>
	 <% 
	 java.util.Calendar cal1 = java.util.Calendar.getInstance();
	 %>
	 <%= cal1.get(java.util.Calendar.YEAR) %>년
	 <%= cal1.get(java.util.Calendar.MONTH)+1 %>월
	 <%= cal1.get(java.util.Calendar.DATE) %>일
	 입니다.

</body>
</html>
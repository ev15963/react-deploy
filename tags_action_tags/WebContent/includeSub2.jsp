<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String siteName = request.getParameter("siteName");
	String siteName2 = request.getParameter("siteName2");
%>
includeSub2.jsp 페이지입니다. <p>
<b> <%=siteName %> : <%=siteName2 %></b>
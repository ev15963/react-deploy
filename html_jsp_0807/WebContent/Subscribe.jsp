<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%
	String agree = request.getParameter("agree");
	String result = null;
	if (agree.equals("YES")) {
		String id = (String) session.getAttribute("ID");
		String pw = (String) session.getAttribute("PW");
		String na = (String) session.getAttribute("NA");
		PrintWriter wr = null;
		try {
			String filePath = application.getRealPath("/WEB-INF/" + id + ".txt");
			wr = new PrintWriter(filePath);
			wr.println("아이디: "+id);
			wr.println("비번 :"+pw);
			wr.println("이름 : "+na);
			result="success";
		} catch (IOException ioe) {
			result= "f";
		} finally {
			try {
				wr.close();
			} catch (Exception e) {
				
			}
		}
	}
	else {
		result = "f";
	}
	session.invalidate();
	response.sendRedirect("Result.jsp?Result=" + result);
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>db접속</title>
</head>
<body>
<%
	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/bbsdb";
	String id="root";
	String pw="1234";
	Connection conn=DriverManager.getConnection(url, id, pw);
	
	if(conn != null) {
		out.println("bbsdb 연결 성공!!");
		conn.close();
		out.println("bbsdb 접속 끊기 성공!!");
	} else {
		out.println("bbsdb 연결 할 수 없습니다!!");
	}
	
%>
</body>
</html>
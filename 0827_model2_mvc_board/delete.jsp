<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

	//DB접속 정보
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";	
	String user = "lsw";
	String passwd = "1234";
	Statement stat;
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	Connection conn;
	PreparedStatement psmt;
	
	conn = DriverManager.getConnection(url, user, passwd);
	
	String[] del_data = request.getParameterValues("check");
	String sql= "delete from member_jdbc where email =?";
	
	for(int i=0;i<del_data.length;i++) {
		psmt = conn.prepareStatement(sql);
		psmt.setString(1,del_data[i]);
		psmt.executeUpdate();
	}
	response.sendRedirect("base_form.jsp");
	
	
%>

</body>
</html>
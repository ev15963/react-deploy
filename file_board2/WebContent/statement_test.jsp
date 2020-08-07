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
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/bbsdb";
		String id="root";
		String pw="1234";
		conn=DriverManager.getConnection(url, id, pw);
		if(conn == null) {
			throw new Exception("bbsdb 연결할 수 없습니다.");
		}
		
		stmt=conn.createStatement();
		String query="select * from bbs";
		rs=stmt.executeQuery(query);
		while(rs.next()) {
			out.print (rs.getInt(1)+"_");
			out.print (rs.getString(2)+"_");
			out.print (rs.getString(3)+"_");
			out.print (rs.getString(4)+"<br />");
		}
	
	}finally {
		try{
			if(rs !=null)
			rs.close();
		} catch(Exception e) {
			out.print(e.getMessage());
		}
		try{
			if(stmt != null)
			stmt.close();
		} catch(Exception e) {
			out.print(e.getMessage());
		}
		try{
			if(conn != null)
			conn.close();
		} catch(Exception e) {
			out.print(e.getMessage());
		}
	}
%>
</body>
</html>
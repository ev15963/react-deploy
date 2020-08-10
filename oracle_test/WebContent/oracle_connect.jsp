<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>


<%
	//1. 드라이버로딩
	Class.forName("oracle.jdbc.driver.OracleDriver");
	out.println("드라이버 로딩 성공!<br />");
	
	//2. 드라이버매니저를 이용하여 DB에 접속하고 Connection 객체 가져오기
	
	Connection conn=null;
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	conn = DriverManager.getConnection(url, "lsw", "1234");
	out.println("DB접속성공! <br />");
	
	Statement stmt =null;
	ResultSet rs = null;
	try{
		stmt=conn.createStatement();
		String query="select * from student";
		rs=stmt.executeQuery(query);
		while(rs.next()) {
			out.print(rs.getString(1)+"_");
			out.print(rs.getString(2)+"_");
			out.print(rs.getString(3)+"_");
			out.print(rs.getInt(4)+"_");
			out.print(rs.getString(5)+"<br />");
			
		}
	} catch (SQLException e) {
		out.println(e.getMessage());
	}

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
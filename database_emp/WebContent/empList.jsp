<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>
<style>
a:link, a:visited, a:active {
	text-decoration:none; 
	color:black;
	}
	
	tr:hover, tr:focus {
		background-color: orange;
	}
	th {
		text-align: center;
	}
	td {
		border-bottom: 1px solid #e4e4e4;
		text-align: center;
	}
</style>
</head>
<body>
	<h3>Employee List</h3>
	<hr> <!-- 가로 구분선 만드는 Tag -->
	
	<table border="0">
	<tr>
		<th>NO </th><th> AGE </th>
		<th>NAME </th><th>PHONE</th>
		<th>GENDER </th><th>JOB</th>
		<th>PAY </th><th>CODE</th>
	</tr>
	
	<%
		ResultSet rs = (ResultSet)request.getAttribute("result");
	
		while(rs.next()) {
			
	%>
		<tr>
			<td>
				<a href="EMPServletUpdate?n=<%=rs.getInt("no") %>">
					<%=rs.getInt("no") %>
				</a>
			</td>
			
			<td>
				<a href="EMPServletUpdate?n=<%=rs.getInt("age") %>">
					<%=rs.getInt("age") %>
				</a>
			</td>
			
			
			<td>
				<a href="EMPServletUpdate?n=<%=rs.getString("name") %>">
					<%=rs.getString("name") %>
				</a>
			</td>
			
			
			<td>
				<a href="EMPServletUpdate?n=<%=rs.getString("phone") %>">
					<%=rs.getString("phone") %>
				</a>
			</td>
			
			<td>
				<a href="EMPServletUpdate?n=<%=rs.getInt("job") %>">
					<%=rs.getInt("job") %>
				</a>
			</td>
			
			<td>
				<a href="EMPServletUpdate?n=<%=rs.getInt("pay") %>">
					<%=rs.getInt("pay") %>
				</a>
			</td>
			
			
			<td>
				<a href="EMPServletUpdate?n=<%=rs.getString("code") %>">
					<%=rs.getString("code") %>
				</a>
			</td>
		</tr>
		<%
			}
			rs.close();
		%>
	</table>
</body>
</html>
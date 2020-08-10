<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>
<style>
a:link, a:visited, a:active {
	text-decoration: none;
	color: black;
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
	<hr>

	<table border="0">
		<tr>
			<th>no</th>
			<th>age</th>
			<th>name</th>
			<th>phone</th>
			<th>gender</th>
			<th>job</th>
			<th>pay</th>
			<th>code</th>
		</tr>

<% 
	ResultSet rs = (ResultSet)request.getAttribute("result");
	
	while(rs.next()) {
%>
		<tr>
			<td><a href="EMPServletUpdate?n=<%=rs.getInt("no") %>"> <%=rs.getInt("no") %>
			</a></td>

			<td><a href="EMPServletUpdate?n=<%=rs.getInt("age") %>"> <%=rs.getInt("no") %>
			</a></td>

			<td><a href="EMPServletUpdate?n=<%=rs.getString("name") %>"> <%=rs.getInt("no") %>
			</a></td>

			<td><a href="EMPServletUpdate?n=<%=rs.getString("phone") %>"> <%=rs.getInt("no") %>
			</a></td>

			<td><a href="EMPServletUpdate?n=<%=rs.getString("gender") %>"> <%=rs.getInt("no") %>
			</a></td>

			<td><a href="EMPServletUpdate?n=<%=rs.getString("job") %>"> <%=rs.getInt("no") %>
			</a></td>

			<td><a href="EMPServletUpdate?n=<%=rs.getInt("pay") %>"> <%=rs.getInt("no") %>
			</a></td>

			<td><a href="EMPServletUpdate?n=<%=rs.getString("code") %>"> <%=rs.getInt("no") %>
			</a></td>
		</tr>
		<%
			}
			rs.close();
		%>
	</table>
</body>
</html>
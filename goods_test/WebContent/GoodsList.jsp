<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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

th {
	text-align: center;
}

td {
	text-align: center;
}

input {
	color: darkgrey;
}
</style>
</head>
<body>
	<h3>상품 목록 화면</h3>
	<hr>
	<table border="0">
		<tr>
			<th>상품번호</th>
			<tr>상품정보</th>
			<tr>상세정보</th>
			<tr>상품수량</th>
			<tr>할인금액</th>
			<tr>배송비</th>
			<tr>상품가격</th>
			<tr>판매자</th>
		</tr>
		
		<% %>
		
		<%
		ResultSet rs = (ResultSet)request.getAttribute("result");
	
		while(rs.next()) {
			
	%>
		<tr>
			<td>
				<a href="GoodsListServlet?n=<%=rs.getInt("no") %>">
					<%=rs.getInt("code") %>
				</a>
			</td>
			
			<td>
				<a href="GoodsListServlet?n=<%=rs.getInt("no") %>">
					<%=rs.getInt("product") %>
				</a>
			</td>
			
			
			<td>
				<a href="GoodsListServlet?n=<%=rs.getInt("no") %>">
					<%=rs.getString("content") %>
				</a>
			</td>
			
			
			<td>
				<a href="GoodsListServlet?n=<%=rs.getInt("no") %>">
					<%=rs.getString("quantity") %>
				</a>
			</td>
			
			<td>
				<a href="GoodsListServlet?n=<%=rs.getInt("no") %>">
					<%=rs.getString("discount") %>
				</a>
			</td>
			
			<td>
				<a href="GoodsListServlet?n=<%=rs.getInt("no") %>">
					<%=rs.getString("delivery_charge") %>
				</a>
			</td>
			
			<td>
				<a href="GoodsListServlet?n=<%=rs.getInt("no") %>">
					<%=rs.getInt("price") %>
				</a>
			</td>
			
			
			<td>
				<a href="GoodsListServlet?n=<%=rs.getInt("no") %>">
					<%=rs.getString("name") %>
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
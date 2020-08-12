<%@page import="com.lsw.servlets.BoardListServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--  -->
<%@ page import="java.util.*, com.lsw.dto.*"%>
<%
	List<BoardModel> list = (ArrayList<BoardModel>) request.getAttribute("LIST");
%>
<!--  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"></meta>
<title>게시판 목록</title>

<style type="text/css">
* {
	font-size: 9pt;
}

p {
	width: 600px;
	text-align: right;
}

table thead tr th {
	background-color: gray;
}
</style>
</head>
<h3>게시판 목록 화면</h3>
<body>
	
	<table border="1" summary="게시판 목록">
		<caption>게시판 목록</caption>
		<colgroup>
			<col width="50" />
			<col width="300" />
			<col width="80" />
			<col width="100" />
			<col width="70" />
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록 일시</th>
				<th>조회수</th>
			</tr>

		</thead>

		<tbody>
			<!--  -->
			<% if(list.size()==0) { %>
			
			<!--  -->
			<tr>
				<td align="center" colspan="5">등록된 게시물이 없습니다.</td>
			</tr>
			
			<!--  -->
			<%
				}else{
					for(BoardModel model : list) {

			%>		
				

			<tr>
				<td align="center"><%=model.getNo() %></td>
				<td><a href="boardView?no=<%=model.getNo() %>" /></a><%= model.getContents() %></td>
				<td align="center"><%=model.getWriter() %></td> <!-- 작성자 출력 부분 -->
				<!-- <td align="center">등록 날짜 출력 부분</td> -->
				<td align="center"><%= model.getHit() %></td> <!-- 조회수 출력 부분 -->
			</tr>
			
			<%
					}
				}
			%>
			
			<!--  -->
		</tbody>

		<tfoot>
			<tr>
				<td align="center" colspan="4">Copyright ⓒ freeflux Corp. All
					Rights Reserved</td>
			</tr>
		</tfoot>
	</table>

	<p>
		<input type="button" value="글쓰기" onclick="location.href='boardWrite'" /><!-- 글쓰기서블릿 -->
	</p>
</body>
</html>
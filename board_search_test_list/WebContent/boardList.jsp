<%@page import="com.lsw.servlets.BoardListServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--  -->
<%@ page import="java.util.*, com.lsw.dto.*"%>
<%
BoardModel searchModel = (BoardModel)request.getAttribute("MODEL");
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
<body>
<h3>게시판 목록 화면</h3>
<hr>
	<%--
	BoardModel md = new BoardModel();
	--%>
	<form style="text-align:right;" action ="boardList">
	<select name ="search">
	<option value="ALL" selected>전체검색</option> <!-- boardList.jsp 검색부분 -->
	<option value="SUBJECT">제목</option> <!-- <md.getSubject() > -->
	<option value="WRITER">작성자</option> <!-- <md.getWriter() %> -->
	<option value="CONTENTS">내용</option> <!-- <md.getContents() %> -->
	</select>
	<input type="text" name="search" required="required" />
	<input type="submit"  value="검색" /> <!-- button아닌 submit -->
	</form>
	
	
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
				<!-- <th>등록 일시</th> -->
				<th>작성일</th>
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
				<td><a href="boardView?no=<%=model.getNo() %>" ><%= model.getSubject() %></a></td>
				<td align="center"><%=model.getWriter() %></td> <!-- 작성자 출력 부분 -->
				
				<td align="center"><%=model.getRegdate().substring(0,10) %></td>
				
				<td align="center"><%=model.getHit() %></td> <!--  조회수 -->
				 <!-- 조회수 출력 부분 -->
			</tr>
			
			<%
					}
				}
			%>
			
			<!--  -->
		</tbody>

		<tfoot>
			<tr>
			
			<!-- 	<td align="center" colspan="5">Copyright ⓒ freeflux Corp. All
					Rights Reserved</td> -->
					<td align="center" colspan="5">${pageNavigator}</td>
			</tr>
		</tfoot>
	</table>

	<p>
		<input type="button" value="글쓰기" onclick="location.href='boardWrite'" /><!-- 글쓰기서블릿 -->
	</p>
</body>
</html>
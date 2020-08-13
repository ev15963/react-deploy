<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.freeflux.dto.*" %>
<%
	BoardModel model=(BoardModel)request.getAttribute("MODEL");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"></meta>
	<title>게시판 수정 폼</title>

	<style type="text/css">
		* {font-size: 9pt;}
		p {width: 600px; text-align: right;}
		table tbody tr th {background-color: gray;} 
		input  {background-color:lime; }
		input  {color:red; }  
	</style>
	
</head>
<body>
<h3>게시글 수정 화면</h3>
<hr>

	<form action=" boardModify" method="post" >
		<input type="hidden" name="no" value="<%= model.getNo() %>" />
		
		<table border="1" summary="게시글 수정 폼">
			<caption>게시글 수정 폼</caption>
			<colgroup>
				<col width="100" />
				<col width="500" />
			</colgroup>
			<tbody>
				<tr>
					<th align="center">제목</th>
					<td>
					<input type="text" name="subject" size="80" maxlength="100" value="<%= model.getSubject() %>"  /></td>
				</tr>
				<tr>
					<th align="center">작성자</th>
					<td><input type="text" name="writer" maxlength="20" value="<%= model.getWriter() %>" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea name="contents" cols="80" rows="10"><%= model.getContents() %></textarea>
					</td>
				</tr>
			</tbody>
		</table>
		
		<p>
			<input type="button" value="글목록으로 가기" onclick="location.href='boardList'" />
			<input type="submit" value="글수정하기" />
		</p>
	
	</form>
</body>
</html>
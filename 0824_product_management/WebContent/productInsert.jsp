<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
</head>

<body>
		<h3 align = "center">상품 등록 페이지</h3>
		<form action="InsertProc" method="post">
		<table align="center" width = "800" border="1">
			<tr>
				<th>상품명</th>
				<td><input type = "text"  size="80" name="name" required="required" /></td>
			</tr>
			
			<tr>
				<th>가격</th>
				<td><input type = "text" size="80"  name="price" required="required" placeholder ="숫자로만 입력하시오. (ex. 30000)"/></td>
			</tr>
			
			<tr>
				<th>설명</th>
				<td><textarea rows="10" cols="90" name="description"></textarea>
			</tr>
		</table>
		<p align="right">
			<input type="submit" value="등록">
			<input type="reset" value="다시작성">
			<input type="button" value="목록" onclick="location.href='productList.jsp'">
		</p>
		</form>
</body>
</html>
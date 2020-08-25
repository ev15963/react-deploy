<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 삭제</title>
</head>
<body>
	<div align = "center">상품을 삭제하시겠습니까?
		<%String code = request.getParameter("code"); %>
	<input type="hidden"  name="code" value=<%=code %> />
	<input type="button" value="삭제" onclick = "location.href='DeleteProc?code=<%=code %>'" />
	<input type="button" value="닫기" onclick = "location.href='productList.jsp'" />
	</div>
</body>
</html>
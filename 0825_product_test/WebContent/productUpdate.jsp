<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 수정 : productUpdate.jsp </title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/product.js"></script>
</head>
<body>
<div id="wrap" align="center">
<h1> 상품 수정 - 관리자 페이지</h1>

<form method="post" enctype="multipart/form-data" name="frm">
	<input type="hidden" name="code" value="${product.code }">
	<input type="hidden" name="normakeImg" value="${product.pictureUrl }">
	
	<table>
	<tr>
	<td>
	<c:choose>
	<c:when>
	
	</c:when>
	</c:choose>
	</td>
	</tr>
	</table>
	
	</form>
</div>
</body>
</html>
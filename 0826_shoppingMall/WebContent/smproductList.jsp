<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.lsw.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품목록화면</title>
</head>
<body>
	<div id="rptlvks" align="center">
	<h1> 상품 목록</h1>
	<table class ="list" border ="1">
	<tr>
	<td> 상품명 </td>
	<td colspan="3"><input type="text" /><a href="/smproductSelectServlet"><input type="submit" name="searchButt" value="검색"/></a></td>
	<td><input type="button" name="allButt" value="전체보기"/></td>
	<td><a href="/smproductInsertServlet"><input type="button" name="emdfhr" value="상품등록"/></a></td>
	</tr>
	<tr>
	<td>번호</td>
	<td>상품명</td>
	<td>원가</td>
	<td>판매가</td>
	<td>등록일</td>
	<td>사용유무</td>
	</tr>
	
		<c:forEach var="smproductList" items="${smproductList}">
		<tr>

		<td>${smproductList.code}</td>
		<td>${smproductList.proName}</td>
		<td>${smproductList.price}</td>
		<td>${smproductList.code}</td>
		<td>${smproductList.sale}</td>
		<td>${smproductList.use}</td>
		</tr>

	</c:forEach>
	

	</table>
	</div>
</body>
</html>
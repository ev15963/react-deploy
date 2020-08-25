<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.kjh.*, java.util.*"%>
<jsp:useBean id="pMgr" class = "com.kjh.DBConnectionMgr" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정</title>

</head>
<style type="text/css">
table tr th {
	background-color: palegreen;
}
</style>
<%
	int code = Integer.parseInt(request.getParameter("code"));
	ProductBean pBean = pMgr.getListByCodes(code);
%>
<body>
		<h3 align = "center">상품 수정 페이지</h3>
		<form action="UpdateProc" method="post">
		<table align="center" width = "800" border="1">
			<tr>
				<th>상품명</th>
				<td><input type = "text"  size="80" name="name"  value = <%=pBean.getName() %> required="required" /></td>
			</tr>
			
			<tr>
				<th>가격</th>
				<td><input type = "text" size="80"  name="price" value=<%=pBean.getPrice() %> required="required" placeholder ="숫자로만 입력하시오. (ex. 30000)"/></td>
			</tr>
			
			<tr>
				<th>설명</th>
				<td><textarea rows="10" cols="90" name="description" ><%=pBean.getDescription() %></textarea>
			</tr>
		</table>
		<input type = "hidden" name = "code" value = <%= code %>>
		<p align="right">
			<input type="submit" value="수정">
			<input type="reset" value="다시작성">
			<input type="button" value="목록" onclick="location.href='productList.jsp'">
		</p>
		</form>
</body>
</html>
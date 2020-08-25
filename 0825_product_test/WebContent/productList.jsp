<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action= "/product" method="post">
<table border="1" width="" height="">
<tr>
<td colspan="center">상품명</td>
<td><input type="text" name="product" size="80" maxlength="80" required="required"> </td>
</tr>
<tr>
<td colspan="center">가격</td>
<td><input type="number" name="price" size="80" maxlength="80" required="required">

</td>
</tr>
<tr>
<td>사진</td>
<td>파일선택</td>
</tr>
<tr>
<td>설명</td>
<td><textarea row="5" cols="80" name="product" required="required" ></textarea></td>
</tr>

</table>
<p>
<input type ="submit" value="제출" >
<input type = "reset" value="다시작성">
<input type = "button" value="목록" onclick = "location.href='productList2.jsp'">
</p>
</form>
</body>
</html>
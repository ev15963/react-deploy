<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href=css/shopping.css">
<script type="text/javascript" src=script/board.js"></script>
</head>
<body>
<div align="center">
<h1>비밀번호 확인</h1>
<form action = "BoardServlet" method="get">
<input type="hidden" name="conmmand" value="board_check_pass">
<input type="hidden" name="num" value="${param.num }">

<table style="width:80%">
<tr>
<th>비밀번호</th>
<td><input type="password" name="pass" size= "20" required /> </td>
</tr>
</table>

<br> <input type="submit" value="확인" /> <br>
<br> ${message }
</form>
</div>
</body>
</html>
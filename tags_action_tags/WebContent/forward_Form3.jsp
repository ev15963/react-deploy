<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>포워딩될 페이지에 파라미터값 전달하기 예제</h2>
<form method="post" action="forwardFrom3.jsp">
	이름 입력 : <input type ="text" name="name"/> <br>
	
	<br> 색 선택:<br>
	<input type="radio" name="color" value="yellow" /> 노랑색<br>
	<input type="radio" name="color" value="green" /> 초록색<br>
	<input type="radio" name="color" value="blue" /> 파랑색<br>
	<input type="radio" name="color" value="red" /> 빨강색<br>
	<p>
	<input type="submit" value="확인" />
</form>
</body>
</html>
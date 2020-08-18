<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forwardFrom</title>
</head>
<body>
<h1>포워딩될 페이지에 파라미터값 전달하기 예제</h1>

<form method="post" action="forwardFrom2.jsp">
	이름 : <input type=text id ="name" name="name" ><br><br>
	당신의 혈액형은? <br>
	
	<input type="radio" id= "a" name= "bloodType" value="a" />
	<label for = "a">A형</label> <br>
	
	<input type="radio" id= "b" name= "bloodType" value="b" />
	<label for = "b">B형</label> <br>
	
	<input type="radio" id= "o" name= "bloodType" value="o" />
	<label for = "o">O형</label> <br>
	
	<input type="radio" id= "ab" name= "bloodType" value="ab" />
	<label for = "ab">AB형</label> <br>
	<br>
	<input type = "submit" value ="보내기" >
</form>
</body>
</html>
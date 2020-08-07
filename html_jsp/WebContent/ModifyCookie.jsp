<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% Cookie cookie = new Cookie("gender", "17");
    cookie.setMaxAge(0);
	response.addCookie(cookie);    
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head> 
<meta charset="UTF-8">
<title>쿠키 데이터 삭제하기</title>
</head>
<body>
	gender 쿠키가 삭제되었습니다. <br /> <br />
</body>
</html>

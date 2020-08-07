<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta charset="UTF-8">
<title>쿠키 데이터 저장하기</title>
</head>
<body>
	쿠키 데이터가 저장되었습니다. <br><br>
</body>
</html>

<%! 
private String getCookieValue(Cookie[] cookies, String name) {
	String value = null;
	if(cookies == null)
		return null;
	for (Cookie cookie : cookies) {
		if (cookie.getName().equals(name))
			return cookie.getValue();
	}
	return null;
}
%>
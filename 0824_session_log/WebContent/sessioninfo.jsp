<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session = "true" %> <!-- true session 내장객체 사용허용 -->
<%@ page import = "java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%
	Date time = new Date(); //setTime(정수날짜시간)
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//객체 생성
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>세션정보</title>
</head>
<body>
세션 ID: <%= session.getId() %> <!-- tomcat 서버가 지정해준 아이디값 -->
<br>

<% time.setTime(session.getCreationTime()); %> <!-- 생성시간을 뽑아냄 정수로 나타내준다-->
세션생성시간 : <%= formatter.format(time) %> <!-- 데이터베이스에서 날짜와시간을 직접 넣지않고 숫자로 넣음 -->
<br>

<% time.setTime(session.getLastAccessedTime()); %> <!-- 정수로 나타내준다 -->
최근접근시간 : <%= formatter.format(time) %>
</body>
</html>
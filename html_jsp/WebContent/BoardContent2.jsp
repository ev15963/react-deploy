<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.Date, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardPost.jsp</title>
</head>
<body>
<%
String select_file=request.getParameter("f");

/** 파일이름을 이용한 날짜 시간 출력하기 **/
String[] split = fname.split(".txt");
Long times = Long.parseLong(split[0]); //1596692115374
Date currentTime = new Date(times);

SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");


%>



</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String passward = request.getParameter("password");
//SQL : select id from table where id=? and pw=?
//	if(rs.next()){
	if (id.equals(passward)) {
		session.setAttribute("MEMBERID", id);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 성공 : sessionLogin.jsp</title>
</head>
<body>
	로그인에 성공했습니다.
</body>
</html>

<%
} else { //로그인 실패시
%>

<script>
	alert("로그인에 실패하였습니다.");
	history.go(-1); 	//이전 페이지로 이동하는 javascript
</script>
<%
}
%>

<!-- 은행앱처럼 5분뒤 자동 로그아웃시 -->
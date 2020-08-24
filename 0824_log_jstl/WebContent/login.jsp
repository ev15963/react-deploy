<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인</h2> <!-- 전달 파리미터 mode, login, pw -->

	<c:if test="${msg!=null }"> <!--  변수를 보내줌 -->
		<font color="red"> <b>${msg }</b> <!-- 굵게 빨간 글씨로 출력 -->
		</font>
	</c:if>
	
	<c:if test = "${id==null }">
	<form action="loginProc.jsp?mode=login" method="post" >
	<table>
	<tr>
	<td>아이디 : </td>
	<td>
	<input type="text" name="id" required="required" />
	</td>
	</tr>
	
	<tr>
	<td>비밀번호 : </td>
	<td>
	<input type="password" name="pass" required="required" />
	</td>
	</tr>
	
	<tr>
	<td colspan="2"><input type="submit" value="로그인" /></td> <!-- 해당 아이디가 존재하지 않을경우  -->
	</tr>
	</table>
	
	
	</form>
	
	</c:if>
	
	<c:if test="${id!=null }">
	<b>${id }</b>님 반갑습니닫.<br>
	<input type="button"
			onclick="javascript:location.href='loginProc.jsp?mode=logout'"
			value="로그아웃" /> <!-- 로그아웃시 아이디를 세션에서 제거 -->
	</c:if>
	<p />
	<a href="register.jsp"> 회원가입하라 가기</a>
</body>
</html>
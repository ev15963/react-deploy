<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>반복</h3>
<h4>&lt;c:forTokens></h4>
<%-- &lt; =>  < --%>
<%-- &lt;c:forTokens> =>  <c:forTokens> --%>
<%-- <c:forTokens> 문자열 쪼개어 출력 --%>

<c:forTokens var="one" items="서울|인천,대전,대구,부산,광주,평양" delims="," varStatus="sts">
<c:out value= "${sts.count}.${one}"/>&middot;
</c:forTokens>
<hr>

<c:forTokens var="one" items="서울|인천,대전,대구,부산,광주,평양" delims="|" varStatus="sts">
<c:out value="${sts.count}.${one}"/>&#149;
</c:forTokens>
</body>
</html>
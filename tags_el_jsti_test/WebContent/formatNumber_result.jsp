<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>formatNumber_result.jsp</title>
</head>
<body>
<pre>
ko_KR /en_US
<fmt:setLocale value="ko_KR"/>
number : <fmt:formatNumber value="9876543.61" type="number"/>
currency : <fmt:formatNumber value="9876543.61" type="currnency"/>
percent :  <fmt:formatNumber type="percent"> 9876543.61 </fmt:formatNumber>
pattern=".000" :  <fmt:formatNumber value="9876543.61" pattern=".000" />
pattern="#.#00.0#" :  <fmt:formatNumber value="9876543.612345" pattern="#,#00.0#"/>
</pre>
</body>
</html>
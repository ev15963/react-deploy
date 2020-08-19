<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>timezone_result.jsp</title>
</head>
<body>
	<pre>
ko_KR / en_US
<fmt:setLocale value="ko_KR" />
<jsp:useBean id="now" class="java.util.Date" /> 

<h4>
<fmt:formatDate value="${now}" dateStyle="full" /> &#149;
<fmt:formatDate value="${now}" type="time" />
</h4>
both:<fmt:formatDate value="${now}" type="both" />
default:<fmt:formatDate value="${now}" type="both" dateStyle="default"
			timeStyle="default" />
short:<fmt:formatDate value="${now}" type="both" dateStyle="short"
			timeStyle="short" />
medium:<fmt:formatDate value="${now}" type="both" dateStyle="medium"
			timeStyle="medium" />
long:<fmt:formatDate value="${now}" type="both" dateStyle="long"
			timeStyle="long" />
full:<fmt:formatDate value="${now}" type="both" dateStyle="full"
			timeStyle="full" />

pattern="yyyy년MM월dd일 HH시 mm분 ss초"
<fmt:formatDate value="${now}" type="both"
			pattern="yyyy년mm월dd일 hh시 mm분 ss초" />
<fmt:timeZone value="GMT">
Swiss GMT : 
<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" />
</fmt:timeZone>

<fmt:timeZone value="GMT-8">
NewYork GMT-8:
<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" />
</fmt:timeZone>
</pre>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="greeting" value="C'est va bien" />
	Original String : ${greeting }
	
	<br /> All Capital Letter : ${fn:toUpperCase(greeting) }
	
	<br /> All lower case : ${fn:toLowerCase(greeting) }
	
	<br /> location of 'va' : ${fn:indexOf(greeting, "va") }
	<br /> length of String : ${fn:length(greeting) }
	<br />
	
	
</body>
</html>
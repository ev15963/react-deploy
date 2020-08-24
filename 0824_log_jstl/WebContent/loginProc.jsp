<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix ="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%-- loginProc.jsp --%>

<sql:setDataSource
	url="jdbc:oracle:thin:@127.0.0.1:1521:XE"
	driver="oracle.jdbc.driver.OracleDriver"
	user="lsw"
	password="1234"
	var="db"
	scope="application" />
	
<%-- 
<sql:setDataSource /> 의 역할
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection db=DriverManeger.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "lsw", "1234");
--%>


 <%-- request.getParameter("mode") //login --%>  <!-- resultset을 확장한.. -->
<c:if test = "${param.mode=='login' }">
	<sql:query var="login" dataSource= "${db }">
		select id from tblJoin where id=? and pass=?
		<sql:param value="${param.id }" />
		<sql:param value="${param.pass }" />
	</sql:query>
<%--
<sql:query var="login" dataSource="${db}"> </sql:query>의 역할

	String sql="select id from tblJoin where id=? and pass=?";
	PreparedStatement pstmt = db.prepareStatement(sql);
	
	첫번째 ? : 전달받은 파라미터를 이용하여 값 설정 pstmt
 --%>
	<c:choose>
		<c:when test="${login.rowCount==0 }">
			<c:set var="msg" value="로그인에 실패 하였습니다." scope="session" />
		</c:when>
		
<%--
	login.rowCount의 역할
	ResultSetMetaData rsmd=login.getMetaData();
	rsmd.getRowCount();
 --%>
		
		<c:when test="${login.rowCount==1 }"> <!--  아이디를 찾은경우 -->
			<c:set var="id" value="${param.id }" scope="session" />
			<c:remove var="msg" scope="session" /> <!--  불필요한 msg 변수를 제거 -->
		</c:when>
	</c:choose>
</c:if>

<c:if test="${param.mode=='logout' }">
	<c:remove var="id" scope="session" /> <!-- 기존아이디를 세션으로부터 제거 -->
</c:if>

<%--
	param.id의 역할
	String id=request.getParameter("id");
 --%>

<c:redirect url="login.jsp" />
<%--
	<c:redirect url="login.jsp"/>의 역할
	response.sendRedirect("login.jsp");
 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
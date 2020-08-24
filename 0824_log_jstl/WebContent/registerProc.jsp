<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<fmt:requestEncoding value = "UTF-8" />

<%-- registerProc.jsp  --%>
<sql:setDataSource 
	url="jdbc:oracle:thin:@127.0.0.1:1521:XE"
	driver="oracle.jdbc.driver.OracleDriver" 
	user="lsw" 
	password="1234"
	var="db" 
	scope="application" />
	
<%-- 에러 발생시, 여기부터 확인용코드 --%>
	<c:out value= '${param.id}'></c:out>
	<c:out value= '${param.pass}'></c:out>
	<c:out value= '${param.name}'></c:out>
	<c:out value= '${param.email}'></c:out>
	<c:out value= '${param.hp}'></c:out>
	

<%-- --%>

<c:catch var="result">
	<sql:update var="join" dataSource="${db }">
		insert into tblJoin (id, pass, name, email, hp) values (?, ?, ?, ?, ?)
		<sql:param value= '${param.id}'/>
		<sql:param value= '${param.pass}'/>
		<sql:param value= '${param.name}'/>
		<sql:param value= '${param.email}'/>
		<sql:param value= '${param.hp}'/>
	</sql:update>
</c:catch>
	<c:out value= "${join }"></c:out>
	<c:out value= "${result }"></c:out>
<c:choose>
	<c:when test="${join==1 }">
		<script>
			alert("회원가입에 성공 하였습니다.");
			location.href = "login.jsp"; //확인할때
		</script>
	</c:when>

	<c:when test="${join!=1||result != null }">
		<script>
			alert("회원가입에 실패 하였습니다.");
			history.back(); //직전 화면으로 이동(회원 가입화면) //확인할때
			history.back(): 직전화면
			//histroy.go(-값) : 지정한이전화면, history.go(+값) : 지정한 다음 화면
		</script>
	</c:when>
</c:choose>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<sql:setDataSource url="jdbc:oracle:thin:@127.0.0.1:1521:XE"
		driver="oracle.jdbc.driver.OracleDriver" user="lsw" password="1234"
		var="dataSource" scope="application" />

	<fmt:setLocale value="ko_kr" />
	<sql:query var="emp" dataSource="${dataSource }">
	SELECT EMPNO AS 사원번호, ENAME AS 이름, SAL AS 월급여, HIREDATE AS 입사일
	FROM employee_tbl
	</sql:query>

	<table border="1">
		<tr>
			<%-- 필드의 정보를 출력 --%>
			<c:forEach var="columnName" items="${emp.columnNames }">
				<th><c:out value="${columnName }" /></th>
			</c:forEach>


			<%-- 데이터를 한 줄씩 출력 --%>
			<c:forEach var="row" items="${emp.rowsByIndex }">
				<tr>

					<%-- 필드의 길이만큼 반복 --%>
					<c:forEach var="column" items="${row }" varStatus="i">
						<c:choose>
							<c:when test="${i.index==3 }">
								<td><fmt:formatDate value="${column}" pattern="yyyy/MM/dd" /></td>
							</c:when>
							<c:otherwise>
								<td><c:out value="${column }" /></td>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</tr>
			</c:forEach>
			
	</table>
</body>
</html>
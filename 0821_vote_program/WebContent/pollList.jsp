<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.freeflux.*,java.util.*"%>
<jsp:useBean id="pMgr" class="com.lsw.DBConnectionMgr" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Poll</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor="#FFFFCC">
	<div align="center">
		<br/>
		<h2>투표프로그램</h2>
		<hr width="600"/>
		<b>설문폼</b>
		
		<!-- Poll List Form (폴 리스트 폼) 자리-->
		<jsp:include page="pollForm.jsp" />
		<hr width="600"/>
		<b>설문리스트</b>
		
		<!-- Poll List Table (폴 리스트 테이블) 자리-->
		<table>
			<tr>
				<td>
					<table width="500" border="1">
						<tr>
							<td align="center"><b>번호</b></td>
							<td><b>제목</b></td>
							<td><b>시작일~종료일</b></td>
						</tr>
						<%
							  //설문 리스트를 출력하기 위한 for()
						%>
					</table>
				</td>
			</tr>
			<tr>
				<td align="right"><a href="pollInsert.jsp">설문 작성하기</a></td>
			</tr>
		</table>
	</div>
</body>
</html>
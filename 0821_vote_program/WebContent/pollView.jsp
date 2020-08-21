<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.lsw.*,java.util.*"%>

<jsp:useBean id="pMgr" class="com.lsw.DBConnectionMgr" />

<%
	// 투표 현황에 관련된 코드 추가할 위치
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Poll</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor="#FFFFCC">
	<div align="center">
		<table border="1" width="400">
			<tr>
				<td colspan="4">
<!-- 				<b>Q : 설문 주제 출력</b> -->
				</td>
			</tr>
			
			<tr>
				<td colspan="3">
					<b>총 투표자 : 인원 수 합 출력</b>
				</td>
				<td width="40">count</td>
			</tr>
			
			<%
			// 막대 그래프 출력하기 위한 for() 문 시작 위치

			%>
			
			<tr>
				<td width="20" align="center">각 항목 번호 출력</td>
				<td width="120">각 아이템을 출력</td>
				<td>
						<table width="가로크기 지정 " height="15">
							<tr>
								<td bgcolor="색상 지정"></td>
							</tr>
						</table>
				</td>
				<td width="40">각 항목에 대한 투표수 출력</td>
			</tr>
			
			<%// for() END %>
		</table>
		
		<p />
		<a href="javascript:window.close()">닫기</a>
	</div>
</body>
</html>
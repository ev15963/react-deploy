<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.lsw.*,java.util.*"%>

<jsp:useBean id="pMgr" class="com.lsw.DBConnectionMgr"/>

<%
	// 투표할 각 항목에 관련되 코드 입력 위치
%>
<%--  결과버튼을 눌렀을때 나오는 화면 --%>
<link href="style.css" rel="stylesheet" type="text/css">
<form method="post" action="pollFormProc.jsp">
<table border="1" width="300">
	<tr>
		<td colspan="2">Q : 설문 주제 출력 </td>
	</tr>
	
	<tr>
		<td colspan="2">
			<%
				// 설문에 대한 각 항목들을 출력할 위치
			%>
		</td>
	</tr>
	
	<tr>
		<td>
			<%
				//서버로 전송하기 위한 submit 버튼  
			%>
		</td>
		<td>
			<input type="button" value="결과" 
					   onclick="javascript:window.open('pollView.jsp?num=설문지 번호', 'PollView','width=500, height=350')">
		</td>
	</tr>
</table>

<input type="hidden" name="num" value="설문지 번호">
</form>
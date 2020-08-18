<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contentPage = request.getParameter("CONTENTPAGE");
	String leftMenu = request.getParameter("LEFTMENU");
	//templateTest.jsp?CONTENTPAGE=content.jsp
	// String contentPage="content.jsp"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="600" border="1" cellpadding="0" cellspacing="0"
		align="center">
		<!-- 셀과 셀사이 떨어진 간격 0, padding 표와 글사이 간격 -->

		<tr height="80">
			<!-- 한줄에 대한 높이 -->
			<td colspan="2">
				<!--  상단영역 --> <jsp:include page="top.jsp" flush="false" />
			</td>
		</tr>
		<tr height="300">
			<td width="150" valign="top">
				<!--  좌측영역 --> <jsp:include page="<%=leftMenu%>" flush="false" />
				<!--  좌측영역 <jsp:include page="left2_ser.jsp" flush="false" /> -->
				<!--  좌측영역 <jsp:include page="left3_p.jsp" flush="false" /> -->
				<!--  좌측영역 <jsp:include page="left4_sol.jsp" flush="false" /> -->
			</td>
			<td width="350" valign="top">
				<!--  본문 내용 --> <jsp:include page="<%=contentPage%>" flush="false" />
			</td>
		</tr>


		</tr>
		<tr height="80">
			<td colspan="2">
				<!--  하단영역 --> <jsp:include page="bottom.jsp" flush="false" />
			</td>
		</tr>
	</table>
</body>
</html>
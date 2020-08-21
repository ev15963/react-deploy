<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.lsw.*,java.util.*"%>
<jsp:useBean id="pMgr" class="com.lsw.DBConnectionMgr" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Poll</title>
<link href="style.css" rel="stylesheet" type="text/css"> <%-- style.css --%>
</head>

<body bgcolor="#FFFFCC"> <!-- #FFFFCC 오줌색깔 -->
	<div align="center">
		<br/>
		<h2>투표프로그램</h2>
		<hr width="600"/> <!-- px 같은 단위 안씀 // 반응형 길이 나타낼시 width="100%"S -->
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
						<% //설문 리스트를 출력하기 위한 for()
						
						List<PollListBean> vlist = pMgr.getAllList();
									  
						int count=vlist.size();
						for(int i = 0; i < vlist.size(); i++) {
							PollListBean plBean = vlist.get(i);
							int num = plBean.getNum();
							String question = plBean.getQuestion();
							String sdate=plBean.getSdate();
							String edate=plBean.getEdate();

							//설문리스트 뿌려준다
							out.println("<tr><td align='center'>" + count + "</td>");
							out.println("<td><a href='pollList.jsp?num="+num+"'>"+question+"</a></td>");
							out.println("<td>"+sdate+"~"+edate+"</td></tr>");
							count=count-1;
						}
								
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
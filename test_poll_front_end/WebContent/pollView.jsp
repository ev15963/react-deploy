<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.freeflux.*,java.util.*"%>
<jsp:useBean id="pMgr" class="com.freeflux.DBConnectionMgr" />
<%
	request.setCharacterEncoding("UTF-8");
	int num = 0;
	if (request.getParameter("num") != null) {
		num = Integer.parseInt(request.getParameter("num"));
	}
	int sum = pMgr.sumCount(num);					//해당 설문 count 필드 합
	List<PollItemBean> vlist = pMgr.getView(num);	//item, count 값들을 조회
	PollListBean plBean = pMgr.getList(num);		//해당 설문 제목을 추출하기 위한
	
	String question = plBean.getQuestion();
	Random r = new Random();
%>
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
				<td colspan="4"><b>Q : <%=question%></b></td>
			</tr>
			
			<tr>
				<td colspan="3"><b>총 투표자 : <%=sum%>명</b></td>
				<td width="40">count</td>
			</tr>
			<%-- 색깔 만들어주는 부분 --%>
			<%
				for (int i = 0; i < vlist.size(); i++) {
					PollItemBean piBean = vlist.get(i);
					String[] item = piBean.getItem();//아이템 ex)김태희
					int rgb = r.nextInt(255 * 255 * 255);
					String rgbt = Integer.toHexString(rgb);
					String hRGB = "#" + rgbt;
					int count = piBean.getCount();//투표수
					int ratio = (new Double(Math.ceil((double) count / sum * 100))).intValue();
					// 테이블로 그래프 색깔
			%>
			
			<tr>
				<td width="20" align="center"><%=i+1%></td>
				<td width="120"><%=item[0]%></td>
				<td>
						<table width="<%=ratio%>" height="15">
							<tr>
								<td bgcolor="<%=hRGB%>"></td>
							</tr>
						</table>
				</td>
				<td width="40"><%=count%></td>
			</tr>
			
			<%} // for END %>
		</table>
		
		<p />
		<a href="javascript:window.close()">닫기</a>
	</div>
</body>
</html>
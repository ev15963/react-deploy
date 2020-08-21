<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%-- 자동맵핑 --%>
<jsp:useBean id="pMgr" class="com.freeflux.DBConnectionMgr" /> <%-- dbconnectionmgr을 이용하여 pMgr객체 만듬 --%>

<jsp:useBean id="plBean" class="com.freeflux.PollListBean" />
<jsp:setProperty property="*" name="plBean" /> <%--  property value 안만들어도 됌 --%>

<jsp:useBean id="piBean" class="com.freeflux.PollItemBean" />
<jsp:setProperty property="*" name="piBean" />
<%-- --%>
<%
	// String[] tt = request.getParameterValues("item"); //값을 여러개 꺼낼때
	
	String sdate="";
	sdate += request.getParameter("sdateY") + "-";
	sdate += request.getParameter("sdateM") + "-";
	sdate += request.getParameter("sdateD");
	
	String edate="";
	edate += request.getParameter("edateY") + "-";
	edate += request.getParameter("edateM") + "-";
	edate += request.getParameter("edateD");
	
	plBean.setSdate(sdate);
	plBean.setEdate(edate);
	
// 	String[] 
	
// 	boolean flagList=true;
	boolean flagList = pMgr.insertPoll(plBean, piBean);
	out.println("pMgr.insertPollList(plBean, piBean); END");

	
	String msg = "설문 추가에 실패 하였습니다.";
	String url = "pollInsert.jsp";
	
	if (flagList) {
		msg = "설문이 추가 되었습니다.";
		url = "pollList.jsp";
	}
%>

<%-- script를 이용해서 js 기능 사용 --%>
<script> 
   alert("<%=msg%>");
   location.href="<%=url%>";
</script>
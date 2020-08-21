<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="pMgr" class="com.freeflux.DBConnectionMgr" />
<%
	request.setCharacterEncoding("UTF-8");
	int num = Integer.parseInt(request.getParameter("num"));
	String[] itemnum = request.getParameterValues("itemnum");
	boolean flag = pMgr.updatePoll(num, itemnum); //두가지 값을 넘겨줌 성공 true 실패 false
	//num 선택한 설문의값, itenum 체크박스면 다중값, 라디오버튼은 단일값 
	String msg = "투표가 등록되지 않습니다.";
	if (flag) {
		msg = "투표가 정상적으로 등록되었습니다.";
	}
%>
<script>
   alert("<%=msg%>");
   location.href="pollList.jsp?num=<%=num%>";
</script>
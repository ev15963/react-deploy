<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.freeflux.*,java.util.*"%>
<jsp:useBean id="pMgr" class="com.freeflux.DBConnectionMgr"/>
<%
	  int num = 0;

	  if(!(request.getParameter("num")==null || request.getParameter("num").equals(""))){
		 num = Integer.parseInt(request.getParameter("num"));
	  }
	
	  PollListBean plBean = pMgr.getList(num); //tblPollList 테이블 쿼리를 실행해줌 //쿼리가 두번 실행됨 //질문 타입 활성화명
	  List<String> vlist = pMgr.getItem(num); //tblPollItem 테이블 해당 값을 꺼내주는 메서드
	  //항목명을 가져와야게 때문에 list로

	  String question = plBean.getQuestion();
	  int type = plBean.getType();
	  int active = plBean.getActive();
%>
<link href="style.css" rel="stylesheet" type="text/css">
<form method="post" action="pollFormProc.jsp">
<table border="1" width="300">
	<tr>
		<td colspan="2">Q : <%=question%></td>
	</tr>
	
	<tr>
		<td colspan="2">
			<%
				for(int i=0; i<vlist.size(); i++){ //i는 value 값
					String itemList = vlist.get(i);
					if(type==1){ //type 1이면 다중선택
						out.println("<input type=checkbox name='itemnum' value='"+i+"'>");
					}else{
						out.println("<input type=radio name='itemnum' value='"+i+"'>");
					}
					out.println(itemList+"<br>"); //String itemList = vlist.get(i);에서 가져온글자 찍어줌
				}	//for END
			%>
		</td>
	</tr>
	
	<tr>
		<td>
			<%
				if(active==1){
					out.println("<input type='hidden' name='num' value='"+num+"'>");
						out.println("<input type='submit' value='투표'>");
					}else{
						out.println("투표");
					}
			%>
		</td>
		<td>
			<input type="button" value="결과" 
					   onclick="javascript:window.open('pollView.jsp?num=<%=num%>', 'PollView','width=500, height=350')"> <!-- view로 이동 -->
						<!-- window.open : 자바스크립트를 이용해서 새 창을 띄워주는 것, 첫 번째 값은 필수입력 -->
						<!-- 두번째 값은 새창에 대한 이름, 세번째 네번째 가로 세로 크기 -->
		</td>
	</tr>
</table>

<input type="hidden" name="num" value="<%=num%>">
</form>
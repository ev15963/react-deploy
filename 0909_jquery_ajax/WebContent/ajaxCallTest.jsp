<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.*" %>

<% // ajaxCallTest.jsp

	//응답요청 파일
	response.setContentType("application/json");
	//반응 타입 (브라우저 or 팝업 : attachment)
	response.setHeader("Content-Disposiont", "attachment");
	//memberId를 ajaxTest.html에서 받는다.
	String memberId = request.getParameter("memberId"); //"id002"

	
	//MAP타입으로 응답 데이터 저장
	Map<String, Object> map = new HashMap<String, Object>();
	//Gson을 활용하여 json 포맷방식으로 반환
	Gson gson = new Gson();	
	
	//db에서 조회했다는 가정하에 조건 처리
	if("id002".equals(memberId)||"id005".equals(memberId)) {
		//위의 조건의 결과, 아이디가 있다는 가정
		map.put("result", "1");
	} else {
		//아이디가 없다는 가정
		map.put("result", "0");
	}
	out.println(gson.toJson(map));
	//반환
	
%>
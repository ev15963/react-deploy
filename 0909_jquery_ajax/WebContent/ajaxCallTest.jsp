<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.*" %>

<% // ajaxCallTest.jsp

	//응답요청 파일
	response.setContentType("application/json");
	//반응 타입
	
	//memberId를 ajaxTest.html에서 받는다.
	
	//MAP타입으로 응답 데이터 저장
	Map<String, Object> map = new HashMap<String, Object>();
	//Gson을 활용하여 json 포맷방식으로 반환
	$('#ajaxCall').click(function() {
		var request = $.ajax({
			url: "ajaxResult.jsp",	// 호출된 url
			method : "POST",		//메서드 type : post/get
			data : { paramNum : 1 }, //파라미터 생략가능
			dataType: "json"		// 응답타임 응답받을 전달받을 데이터가 없으면 생략가능
		
	});
	//db에서 조회했다는 가정하에 조건 처리
	
	//반환
	
%>
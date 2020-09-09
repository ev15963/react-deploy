<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.*" %>
<%
	//ajaxResult.jsp
	//ajax.html 
	
	// 응답 콘텐츠 타입 설정
	response.setContentType("application/json");

	/*
		Content-Disposiont : inline //브라우져에서 응답하기
		Content-Disposiont : attachment //팝업(alert) 형태 응답하기
	*/
	
	//해당 헤더로 브라우져에서 바로 응답
	response.setHeader("Content-Disposiont", "inline");
	
	String paramNum = request.getParameter("paramNum");
	System.out.println("==>"+paramNum + " : 파라미터 확인" );
	
	Map<String, Object> map = new HashMap<String, Object>();
	Gson gson = new Gson();
	map.put("param1", "1");
	map.put("param2", "2");
	
	if("1".equals(paramNum)){
		map.put("param1", "1");
	}else if("2".equals(paramNum)){
		map.put("param2", "2");
	}else {
		map.put("param1", "1");
		map.put("param2", "2");
	}
	
	String Json = gson.toJson(map);
	out.println(Json);
%>
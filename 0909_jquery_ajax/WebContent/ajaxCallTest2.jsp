<%@ page language="java" contentType="appplication/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.*" %>

<% // ajaxCallTest.jsp

	//응답요청 파일
	response.setContentType("application/json");

	//반응 타입 (브라우저 or 팝업 : attachment)
	response.setHeader("Content-Disposiont", "inline");

	Stirng num1 = request.getParameter("num1");
	Stirng num2 = request.getParameter("num2");
	System.out.println(num1+num2+"<- ajaxCallTest.jsp");
	
	if(num1 == null || num1.equals("")) { num1="0"	}
	//memberId를 ajaxTest.html에서 받는다.
	//String memberId = request.getParameter("memberId");

	//String 타입의 num1을 int로 형변환
	
	//MAP타입으로 응답 데이터 저장
	//Map<String, Object> map = new HashMap<String, Object>();
	
	//Gson을 활용하여 json 포맷방식으로 반환
	//Gson gson = new Gson();	
	
	
%>
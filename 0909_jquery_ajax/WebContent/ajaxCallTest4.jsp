<%@ page language="java" contentType="appplication/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.*" %>

<% 

/*
		문제3 #call 버튼 클릭시 #num의 선택된 숫자만큼의 크기를 갖는
		배열 (자신의 이름이 값)을 반환하여 #myName에 html 출력
		
		1) num 파라미터를 받아 해당 숫자 만큼 반복을 하여
			자신의 이름을 저장하고 저장한 객체를 반환
			
		2) List<String> myName = new ArrayList<String>();
			리스트 객체 생성하고
			이 객체 에 저장하여 myName을 반환하면 된다.
			
		3) List 객체.add(객체); -> 배열과 다르게 크기가 지정되어 있지 않다.
			add메서드를 활용해서 객체를 추가 할 수 있으며
			자동 인덱스가 증가된다.
			ex> myName.add("이름");
			
		4) List 객체.get(index); -> List에 저장된 내용을
		인덱스 매게변수로 가지고 올 수 있다.
		
*/

	response.setContentType("appplication/json");
	response.setHeader("Content-Disposiont", "inline");
	
	Map<String,Object> map = new HashMap<String, Object>();
	
	//키값이 배열이기 때문에 받아 올때도 배열을 받아서 와야한다.
	//배열을 받아올때는 getParameterValues를 이용해서 받아야한다.
	
	String[] str = request.getParameterValues("types[]");
	
	String strum
	
	
%>
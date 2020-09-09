<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.*" %>
<%@ page import="com.lsw.dto.*" %>
<%
	Gson gson = new Gson();	

	Member member = new Member();
	member.setAddress("전주");
	member.setAge("21");
	member.setName("홍길동");


	//Member 인스턴스화(객체)를 List에 담아, Gson를 이용하여 json 포맷방식 String 타입으로 반환
	String getJson = gson.toJson(member);
	out.println(getJson);				// <= 첫번째 (member 객체를 json으로)
	
	List<Member> list = new ArrayList<Member>();
	
	member = new Member();
	member.setAddress("전주");
	member.setAge("21");
	member.setName("홍길동");
	list.add(member);
	
	member = new Member();
	member.setAddress("제주");
	member.setAge("41");
	member.setName("홍동");
	list.add(member);
	
	String getJson2 = gson.toJson(list);
	out.println(getJson2);				// 두번째 (List를 json 객체로)
	
	member = new Member();
	member.setAddress("서울");
	member.setAge("31");
	member.setName("홍길");
	list.add(member);
	
	
	
	
%>
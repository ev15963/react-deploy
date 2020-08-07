<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.*, java.util.Date"%>
<!DOCTYPE html>
<html>
    <head>
    	<title>게시판 글쓰기 - 결과 화면</title>
    	<script type="text/javascript">
		   function postWrite(){
			   document.location="BBSInput.html";
		   }
		
		   function postDetail(obj){ //매개변수명 주면 주는대로 받는 스크립트 언어
			  if(obj.selectedIndex == 0){
			      alert("선택하세요~~");
			      return;
			  }
			  var selIDX=obj[obj.selectedIndex].text; //옵션태그 
			  alert(selIDX+"선택");
			  document.location="BBSPostReader.jsp?sel="+selIDX; //a태그 href 대용 BBSPostReader의 sel
		   }
	  </script>
    	
    </head>
    <body>
        <h2>파일형 게시판 글목록 - 글목록 화면</h2> <!-- onchange 선택한 값이 바뀔 때 이벤트 발생 -->
         <select id="s2ID" cols="30" size="10" onchange="postDetail(this)">
         	<option>보고 싶은 파일을 아래에서 선택하세요</option>
        	<%
	        	String filePath = application.getRealPath("/WEB-INF/bbs/");
	        	out.print(filePath);
	        	File f=new File(filePath);
	        	String[] sFN = f.list(); //파일을 쌓아놈
	        	for (int i=0; i < sFN.length; i++) {
	        		out.print("<option>"+sFN[i]+"</option>");
	        	}
        	%>
        </select>
        <input type="button" value="글쓰기" onclick="postWrite()">
        
    </body>
</html>

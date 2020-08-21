<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>투표프로그램</h1><hr><br>
설문작성<hr><br>
<tr>

<table border="1">
<td>질문</td>
<td colspan="2"><input type ="text" ></td>
</tr>

<tr>
<td rowspan="8">항목</td>
<td>1:<input type ="text" ></td>
<td>2:<input type ="text" ></td>
</tr>

<tr>
<td>3:<input type ="text" ></td>
<td>4:<input type ="text" ></td>
</tr>
<tr>
<td>5:<input type ="text" ></td>
<td>6:<input type ="text" ></td>
</tr>
<tr>
<td>7:<input type ="text" ></td>
<td>8:<input type ="text" ></td>
</tr>
<tr>
<td>시작일</td>
<td>
<form>
<select name ="sdateY">
<option value = ""></option>
</select>
</form>
</td>
</tr>
<tr>
<td>종료일</td>
<td></td>
</tr>
<tr>
<td>복수투표</td>
<td>
<input type ="radio" name="type" value="yes"> yes
<input type ="radio" name="type" value="no"> no
</td>
</tr>
<tr>
<td colspan="2"> 
<input type ="submit" value="작성하기" action="pollInsertProc.jsp"> 
<input type ="submit" value="다시쓰기"> 
<input type ="submit" value="리스트" onClick="javascript:location.href='pollList.jsp'">
</td>
</tr>
</table>
</body>
</html>
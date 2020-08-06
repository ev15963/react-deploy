<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardPost.jsp</title>
</head>
<body>
	<h2>글 파일 저장</h2>

	<%
		File f = new File("c:/bbs");
		String[] filenames = f.list();
		out.println("<table border=1>");
		for (String f_name : filenames) {
			out.println("<tr><td>");
			out.println("<a href=BoardContent.jsp?f=" + f_name + ">");
			out.println(f_name);
			out.println("</a>");
			out.println("</td></tr>");
		}

		out.println("</table>");
	%>

		
<button onclick = "location.href='BoardList.jsp'">글목록</button>

</body>
</html>
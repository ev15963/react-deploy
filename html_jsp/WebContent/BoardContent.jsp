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

	<%=request.getParameter("f")%>

	<%
		String select = request.getParameter("f");
		BufferedReader reader = null;
		try {
			String filePath = "c:/bbs/" + select;
			reader = new BufferedReader(new FileReader(filePath));
			String str = null;
			while ((str = reader.readLine()) != null) {
				out.println(str + "<br />");
			}
		} catch (FileNotFoundException fefe) {
			out.println("파일이 존재하지 않습니다.");
		} catch (IOException ioe) {
			out.println("파일을 읽을 수 없습니다.");
		} finally {
			try {
				reader.close();
			} catch (IOException ioe) {
				out.println("객체를 닫을 수 없습니다.");
			}
		}
	%>
<button onclick = "location.href='BoardList.jsp'">글목록</button>
</body>
</html>
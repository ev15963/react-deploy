<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 실행 시 자동으로 응답(web.xml)하는 파일 : index.jsp</title>
</head>
<body>
<%
response.sendRedirect(
			"http://localhost:9000/0827_model2_mvc_board/BoardServlet?command=board_list");

			// BoardServlet?파라미터=요청사항
			// @WebServlet("/BoardServlet")
			// public class BoardServlet extends HttpServlet {
%>
</body>
</html>
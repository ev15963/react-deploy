<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 실행 시 자동으로 응답(web.xml)하는 파일 : index.jsp</title>
</head>
<body>
<%
response.sendRedirect(
			"http://localhost:9000/0827_model2_mvc_board/Board/BoardServlet?command=board_list");

			// BoardServlet?파라미터=요청사항
			// @WebServlet("/BoardServlet")
			// public class BoardServlet extends HttpServlet {
%>
</body>
</html>
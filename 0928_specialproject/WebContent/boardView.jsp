<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardView.jsp</title>
<script src="js/board.js"></script>
</head>
<body>
<div id="wrap">
<h1>게시글 상세보기</h1>
<table>
<tr>
<th>작성자</th><td><fmt:formatDate value="${board.writedate }"/></td>
<th>조회수</th><td>${board.readcount }/></td>
</tr>
<tr>
<th>제목</th>
<td colspan="3">${board.title}</td>
</tr>
<tr>
<th>내용</th>
<td colspan="3"><pre>${board.content }</pre></td>
	<!-- <pre> 문자열을 쓴 그래돌 자유롭게 보여주는 선언자 -->
	</tr>
</table>

<input type="button" value="게시글 수정" onclick="open_win('BoardServlet?command=board_check_pass_form&num=${board.num}','update')"/>
<!-- open_win (board.js 자바스크립트파일 메서드)에 인자 (url, name ) -->

<input type="button" value="게시글 삭제" onclick="open_win('BoardServlet?command=board_check_pass_form&num=${board.num}', 'delete')" />
<input type="button" value="게시글 리스트" onclick="location.href='BoardServlet?command=board_list'"/>
<input type="button" value="게시글 등록" onclick="location.href='BoardServlet?command=board_write_form'"/>
</div>
</body>
</html>
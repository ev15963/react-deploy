<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardUpdate.jsp 게시글 수정 화면을 위한 jsp 페이지</title>
<script src="js/board.js"></</script>
</head>
<body>
<div id="wrap">
<h1>게시글 수정</h1>
<form name="form" method="post" action="BoardServlet">
<input type="hidden" name="command" value="board_update">
<input type="hidden" name="num" value="${board.num }">

<table>
<tr>
<th>작성자</th>
<td><input type="text" name="name" value="${board.name }"> *필수</td>
</tr>
<tr>
<th>비밀번호</th>
<td><input type="password" nass="pass"> *필수 (게기물 수정 삭제시 필요합니다.)</td>
</tr>
<tr>
<th>이메일</th>
<td><input type="text" maxlength="50" name="email" value="${board.email }"></td>
</tr>
<tr>
<th>제목</th>
<td><input type="text" name="title" value="${board.title}"></td>
</tr>
<tr>
<th>내용</th>
<td><textarea rows="15" cols="70" name="content">${board.cotent }</textarea></td>
</tr>
</table>
<input type="submit" value="등록" onclick="return boardCheck()">
<input type="reset" value="다시작성">
<input type="button" value="목록" onclick="location.href='BoardServlet?command=board_list'">
</form>
</div>
</body>
</html>
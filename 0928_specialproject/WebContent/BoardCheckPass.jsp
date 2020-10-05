<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardCheckPass.jsp 비밀번호 입력 화면을 위한 jsp 페이지</title>
<script type="text/javascript" src="js/board.js"></script>
</head>
<body>
	<div>
		<h1>비밀번호 확인</h1>
		<form action="BoardServlet" name="form" method="get">
			<input type="hidden" name="command" value="board_check_pass">
			<input type="hidden" name="num" value="${param.num }">

			<!-- 	boardView.jsp의 "게시글 수정" 부분에
		onclick="open_win('BoardServlet?command=board_check_pass_form&num=${board.num}')
		부분에서 num값을 보낸 것을 param(.$.{.}.EL에서 키를 지정하지 않은 파라미터)으로 받는다.
		-->
			<table>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass" size="20"></td>
				</tr>
			</table>
			<input type="submit" value="확인" onclick="return passCheck()">
			${message }
			
<!-- 			BoardCheckPassAction에 request영역의
				setAttribyte로 ("message", "비밀번호가 틀렸습니다.")의 키와 값을 주어
				"비밀번호가 틀렸습니다 출력"
 -->
		</form>
	</div>

</body>
</html>
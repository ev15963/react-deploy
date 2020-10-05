<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판등록 boardWrite.jsp</title>
<script src="js/board.js"></script>
<!-- context루트로 해서 오기 때문에 servlet위치 기준으로 경로를 지정해 주어야한다. -->
</head>
<body>
	<div id="wrap">
		<h1>게시글등록</h1>
		<form action="form" method="post" action="BoardServlet">
			<!-- form이름 form은 자바스크릅트로 form을 선택할때 사용 
	post 방식으로 보안상 값을 코드(바이트코드)로 변경해서 보냄
	BoardServlet이란 주소로 request로 보냄
	
	바이트코드 : 
	자바(JAVA) 컴퍼일러는 플랫폼에 독립적인 자바 가상머신(virtual machine) 상에서 동작하는 바이트 코드를 생성
	이것은 자바 애플릿이 자바 가상 머신을 지원하는 모든 기계 상에서 동작을 하는 것을 의미
	-->

			<input type="hidden" name="connand" value="board_write">
			<!-- command키로 board_write값을 보냄 -->
			<table>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass"> <span>필수
							(게시물 수정 삭제시 필요합니다.)</span></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title"> <span>*필수</span>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="70" rows="15" name="content"></textarea></td>
					<!-- textarea의 70x15 크기 -->
				</tr>
			</table>
			<input type="submit" value="등록" onclick="return boardCheck()">
			<!-- submit은 form의 키와 값을 request로 전송한다. -->
			<input type="reset" value="다시작성">
			
			<input type="button" value="목록" onclick="location.href='BoardServlet?command=board_list'">
			<!-- button을 onclick(한번 눌렀을때 ) 실행 되었을때 location(장소)의 경로를
			BoardServlet가상 주소의 command 키에 board_list 값을 지정하여 해당경로로 연결시킨다. -->
		</form>
	</div>
</body>
</html>
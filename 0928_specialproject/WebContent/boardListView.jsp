<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap">
	<h1>게시판 리스트</h1>
	<table>
		<tr>
		<td colspan="5">
		<a href="BoardServlet?command=board_white_form">게시글 등록</a>
		
		<!-- 링크 request영역으로 BoardServlet.java의 가상주소(BoardServlet) 주소로 보낸다 
		(링크로 갔을 경우 get방식으로 간다)
		Servlet으로 간 command(키)=board_write_form(값)을 받게 된다.
		-->
		</td>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회</th>
		</tr>
		<c:forEach var="board" items="${boardList}">
			<!-- JSTL core의 for문
			
			var는 board라는 키를 주고
			
			items는 BoardListAction.java에서
			List<BoardVO> boardList = bDao.selectAllBoards();을 통해서 받은 
			VO값과 DAO리스트 보기 부분이 담겨있다. -->
			
			<!-- taglibs 라이브러리 중 EL 가독성이 좋고 코드 양을 대폭 줄인다.(null값에 관대하다.)
			$[]은 주석에도 먹히니 주석처리 하지 않을 경우 해당된다. (꼭 주석 지우고 실행)
			키(board)와 DAO로 받은 VO값(num)을 연결하여 출력
			 -->
			
			<tr>
				<td>${board.num }</td>
			<td>
				<a href="BoardServlet?command=board_view&num=${board.num }">${board.title }</a>
				
				<!-- BoardServlet(가상 주소로)
				command키에 board_view와
				num키에 servlet으로 받은 num(VO)값이 담겨있는 값을 담는다. -->
			</td>
			
			<td>
				${board.name }
			</td>
			
			<td>
				<fmt:formatDate value="${board.writedate }"/>
				
				<!-- 날짜형식등의 기능의 taglibs 라이브러리 중 fmt를 사용하여
				날짜 데이터를 formatDate로 데이터를 뿌려준다.
				 -->
			</td>
			
			<td>${board.readcount }</td>
			</tr>
			</c:forEach>
	</table>
	</div>
</body>
</html>
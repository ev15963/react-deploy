<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ include file="submenu.jsp" %>
<article>
	<div> <!-- 상단 왼쪽에 자리배치 -->
		<input type="button" value="이전페이지" style="float: left;"
					onClick="go_back()">
		<br/>
		<br/>
		<br/>
	</div>
	
	<form name="formm"
			method="post">
	<div> <!-- 왼쪽에 자리배치 -->
		<table border="1" style="float: left;">
			<tr>
				<td>아이디 :</td>
				<td>${detail.id }
				<input type="hidden" name="id" value="${detail.id }"></td>
			</tr>
			<tr>
				<td>이름 :</td>
				<td><input type="text" name="name" value="${detail.name }"></td>
			</tr>
			<tr>
				<td>연락처 :</td>
				<td><input type="text" name="phone" value="${detail.phone }"></td>
			</tr>
			<tr>
				<td>주소 :</td>
				<td><input type="text" name="adress" value="${detail.address }"></td>
			</tr>
			<tr>
				<td>등록일자 :</td>
				<td>${detail.enroll }
				<input type="hidden" name="enroll" value="${detail.enroll }"></td>
			</tr>
		</table>
	</div>

	<div> <!-- 오른쪽에 자리배치 -->
		<c:forEach var="procedure" items="${procedureList }">
		<table border="1">
			<tr>
				<td>시술일자</td>
				<td>시술내역</td>
			</tr>
			
			<tr>
				<td>${procedure.date } 
				<input type="hidden" name="p_enroll" value="${procedure.enroll }"></td>
				<td><input type="text" name="p_type" value="${procedure.p_type }"></td>
			</tr>
		</table>
		</c:forEach>
	</div>

	<div> <!-- 하단 왼쪽의 버튼들 -->
		<input type="submit" value="수정" onclick="go_detail_update()">				
	</div>
	</form>
</article>
<%@ include file="footer.jsp" %>
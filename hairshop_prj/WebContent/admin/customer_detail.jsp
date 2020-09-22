<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ include file="submenu.jsp" %>
<article>
	<div> <!-- 상단 왼쪽에 자리배치 -->
		<input type="button" value="이전페이지" style="float: left;"
					onClick="location.href='login.jsp'">
		<br/>
		<br/>
		<br/>
	</div>
	
	<div> <!-- 왼쪽에 자리배치 -->
		<table border="1" style="float: left;">
			<tr>
				<td>아이디 :</td>
				<td id="id">${detail.id }</td>
			</tr>
			<tr>
				<td>이름 :</td>
				<td id="name">${detail.name }</td>
			</tr>
			<tr>
				<td>연락처 :</td>
				<td>${detail.phone }</td>
			</tr>
			<tr>
				<td>주소 :</td>
				<td>${detail.address }</td>
			</tr>
			<tr>
				<td>등록일자 :</td>
				<td>${detail.enroll }</td>
			</tr>
		</table>
	</div>

	<div> <!-- 오른쪽에 자리배치 -->
		<table border="1">
			<tr>
				<td>시술일자 </td>
				<td>시술내역 </td>

			</tr>
			
			<tr>
				<td>${detail.date }</td>
				<td>${detail.p_type }</td>
			</tr>
		</table>
	</div>

	<div> <!-- 하단 왼쪽의 버튼들 -->
		<input type="button" value="고객정보 및 시술내역 수정"
					onClick="location.href='아이디 값으로 고객상세정보수정 페이지로 가주세요'">				
		<input type="button" value="고객정보 삭제"
					onClick="delete_check()">
	</div>
</article>
<%@ include file="footer.jsp" %>
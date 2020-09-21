<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ include file="submenu.jsp" %>
<article>
	<div>
		<c:forEach var="list" items="${proList }">
		<form name="formm" method="post">
		<table border="1">
			<tr>
				<th>이름</th>
				<th>연락처</th>
				<th>시술일자</th>
				<th>시술내역</th>
				<th></th>
			</tr>
			<tr>
				<td><input type="text" name="name" value="${list.name }" readonly="readonly" ></td>
				<td><input type="text" name="phone" value="${list.phone }" readonly="readonly" ></td>
				<td><input type="text" name="res_date" value="${list.res_date }" readonly="readonly" ></td>
				<td><input type="text" name="pType" value="${list.p_type }"></td>
				<td><input type="hidden" name="id" value="${list.id }">
				<input type="button" value="시술완료" onclick="go_reservation_end()"></td>
			</tr>
		</table>
		</form>
		</c:forEach>
		
	</div>
</article>
<%@ include file="footer.jsp" %>
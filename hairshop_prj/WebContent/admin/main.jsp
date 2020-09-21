<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ include file="submenu.jsp" %>
<article>
	<div id= 'search'>
		<form name="formm" method="post">
			<label>고객검색</label>
			<select name="searchType">
				<option value="name">성 명</option>
				<option value="phone">연락처</option>
			</select>
			<input type="text" name="searchText" size="15">
			<input type="submit" value="검색" onclick="go_search()">
		</form>
	</div> <!-- 검색창 -->
	<br /><br /><br />
	<div>
	<c:choose>
		<c:when test="${resList.size()==0}">
			<h3 style="text-align: center;"> 현재 예약이 없습니다.</h3>
		</c:when> <!-- 예약관리 페이지에 들어갈 값이 없을 경우 -->
		<c:otherwise>
			<table border="1">
				<tr> 
					<th>예약일</th>
					<th>예약시간</th>
					<th>예약상태</th>
					<th>이름</th>
					<th>연락처</th>
					<th>최근시술일자</th>
					<th>최근시술내역</th>
					<th></th>
					<th></th>
				</tr>
				
				<c:forEach var="list" items="${resList}">
				<tr>
						
					<td>${list.res_date }</td>
					<td>${list.res_time }</td>
					<td>${list.res_status }</td>
					<td id="name"><a href="아이디 값으로 상세보기 조회해주세요 ${list.id}">${list.name }</a></td>
					<td>${list.phone }</td>
					<td>${list.res_date }</td>  <!-- 테이블 필드명이 겹쳐서 이름 정해지면 바꿔야해요-->
					<td>${list.p_type }</td>	<!-- 위쪽의 res_date는 예약테이블 아래쪽은 시술내역테이블 -->
					
					<c:choose>
						<c:when test="${list.res_status == 1}">
							<td></td>
						</c:when>
						<c:otherwise>
							<td><input type="button" value="확정" 
						onclick="location.href='HairshopServlet?command=cusres_update&id=&${list.id}'"></td>
						</c:otherwise>
					</c:choose>	<!-- 에약이 확정된 경우 버튼 안뜨도록 -->
					
					<td><input type="hidden" id="id" value="${list.id }"  >
					<input type="button" value="예약취소" name="cancel"
						onclick="cancel_check()"></td> <!-- cancel_check는 js에서 이동할 페이지 지정해주세요 -->
				</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
		</div>

</article>
<%@ include file="footer.jsp" %>
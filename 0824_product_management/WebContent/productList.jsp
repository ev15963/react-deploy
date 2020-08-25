<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import = "com.kjh.*, java.util.*"%>
<jsp:useBean id="pMgr" class = "com.kjh.DBConnectionMgr" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 리스트</title>
</head>
<style type="text/css">
table tr th {
	background-color: palegreen;
}
</style>
<body>
	<h3 align = "center">상품리스트</h3>
	<p align="right"><a href="productInsert.jsp" >상품 등록</a></p>
		<table align="center" width = "800" border="1">
			<tr>
				<th>번호</th>
				<th>상품명</th>
				<th>가격</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
				<%-- 상품 리스트가 없을 경우 --%>
				<%
					List<ProductBean> pList = pMgr.getList();
//				private int code=0;					// 상품번호
//				private String name="";			// 상품명
//				private int price=0;				// 가격
//				private String pictureurl="";		// 사진URL
//				private String description="";	// 상품설명
					if(pList.size()==0){
				%>
			<tr>
				<td colspan="5" align="center"> 상품리스트가 없습니다.</td>
			</tr>
				<%-- 상품 리스트가 있을 경우 --%>
				<%} else{
					for(int i=0; i<pList.size(); i++){
					ProductBean pBean = pList.get(i);
					int code = pBean.getCode();
					String name = pBean.getName();
					int price = pBean.getPrice();
				%>
				
			<tr>
				<td align = "center"><%=code%></td>
				<td align = "center"><%=name %></td>
				<td align = "center"><%=price %>원</td>
				<td align = "center"><a href="productUpdate.jsp?code=<%=code%>">상품 수정</a></td>
				<td align = "center"><a href="productDelete.jsp?code=<%=code%>">상품 삭제</a></td>
			</tr>
			<%

					}
					pMgr.close();
				}
			%>
		</table>
</body>
</html>
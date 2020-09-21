<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<br />
<br />
<hr>
<nav id="sub_menu">
	<ul>
		<li><a href='HairshopServlet?command=cus_list'> 예약관리</a></li>
		<li><a href='HairshopServlet?command=reson_list'> 고객리스트</a></li>
		<li style="cursor:pointer;" onclick="open_win('customer_insert.jsp', 'customerEnroll')"><a>고객등록</a></li>
		<li><a href='HairshopServlet?command=reson_list'>시술등록</a></li>
	</ul>
</nav>

<%@page import="com.sun.org.apache.xalan.internal.xsltc.compiler.sym"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<% request.setCharacterEncoding("UTF-8"); %>

<body>

</body>



<%

	//DB접속 정보
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";	
	String user = "lsw";
	String passwd = "1234";
	Connection con=null;
	Statement stmt;
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con = DriverManager.getConnection(url, user, passwd);
	
	//Statement 타입의 stmt생성시 커서가 양방향스크롤이 가능하고
	//Update가 가능한 ResultSet을 생성
	stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, //stmt 객체 생성시 상수값 추가
								ResultSet.CONCUR_UPDATABLE);
	
	/** ResultSet rs = stmt.executeQuery("select * from member");**/
	ResultSet rs = stmt.executeQuery("select name, address, email from member_jdbc"); //executeQuery에 넣어서 추가

	rs.last(); //커서를 마지막에 위치시킴
	int row = rs.getRow(); //커서의 위치의 값을 구함
	System.out.println("Last row : "+row);
	//rs.first();
	int firstRow = rs.getRow();
	//System.out.println("FirstRow : "+firstRow);	//FirstRow : 1
	//System.out.println("rs.getType() : "+rs.getType()); // rs.getType() : 1005
	int row2 = rs.getRow();
	System.out.println("row postion : "+row2);
	System.out.println("rs.previous() : "+rs.previous()); // rs.previous() : true
//	System.out.println("beforeFirst : "); // rs.previous() : false
//	rs.beforeFirst();
	
	//rs.absolute(레코드의 위치);
	//rs.absolute(3); //커서를 세번째 레코드위에 위치시켜 두번째 칼럼의 데이터를 수정
	//rs.updateString(필드 위치 변경값);
	//rs.updateString(2, "주소변경테스트2"); //변경사항으로 입력
	//rs.updateRow(); //실질적으로 UpdateRow()명령을 수행해야 수정됨 실제로 변경시켜줌
	//rs.updateRow(); //실질적으로 UpdateRow()명령을 수행해야 수정됨 실제로 변경시켜줌
	//rs.updateString(1, "다른걸로5"); //updateRow 위에 쓸것
	
	rs.beforeFirst();
	//beforeFirst() 첫번째 레코드 이전 위치, 즉 메타정보 위치로 커서를 이동 시킴
//	rs.relative(1);
	//System.out.println(rs.relative(1));
	
	ResultSetMetaData rsm = null;
	
	rsm = rs.getMetaData();
%>

	<table border=1>
		<tr>
			<td width=100> 이름</td>
			<td width=100> 주소</td>
			<td width=100> Email</td>
		</tr>
		
<%
		//next()를 이용 커서를 하나씩 이동하면서 모든 레코드 정보를 출력
		while(rs.next()) {
%>
			<tr>
			<td align=center><%=rs.getString(1) %></td> <!-- free/클라우드/애플 -->
			<td align=center><%=rs.getString(2) %></td> <!-- 서울시/뉴욕/주소변경테스트 -->
			<td align=center><%=rs.getString(3) %></td> <!-- freeflux@naver.com/cloud@gmail.com/apple@icloud.com -->
			</tr>
<%		}%>

	</table>
	
	
</html>
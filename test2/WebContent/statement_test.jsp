<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*, com.lsw.BBSClass" %>
<%
ArrayList<BBSClass> list=null; //추가코드
Connection conn=null;
Statement stmt=null;
ResultSet rs=null;
try {
	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/bbsdb";
	String id="root";
	String pw="1234";
	conn=DriverManager.getConnection(url, id, pw);
	if(conn == null) {
		throw new Exception("bbsdb 연결할 수 없습니다.");
	}
	
	stmt=conn.createStatement();
	String query="select * from bbs";
	rs=stmt.executeQuery(query);
	
	list=new ArrayList<BBSClass>(); //추가코드
	BBSClass bbs=null;
	//out.println(rs);
	
	while(rs.next()) {
	//수정코드
	bbs=new BBSClass(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
	list.add(bbs);
	bbs=null;
	/**
		out.print (rs.getInt(1)+"_");
		out.print (rs.getString(2)+"_");
		out.print (rs.getString(3)+"_");
		out.print (rs.getString(4)+"<br />");
	
	*/
	
	}

}finally {
	try{
		if(rs !=null)
		rs.close();
	} catch(Exception e) {
		out.print(e.getMessage());
	}
	try{
		if(stmt != null)
		stmt.close();
	} catch(Exception e) {
		out.print(e.getMessage());
	}
	try{
		if(conn != null)
		conn.close();
	} catch(Exception e) {
		out.print(e.getMessage());
	}
}

//아래내용추가
request.setAttribute("LIST", list); //list_test로
RequestDispatcher rd=request.getRequestDispatcher("list_test.jsp");
rd.forward(request, response);
%>
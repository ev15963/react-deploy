package com.lsw;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBManager {
	public static Connection getConnection() {
		
		final String dri = "oracle.jdbc.driver.OracleDriver";
		final String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		
	
		Connection conn =null;
		try {
			Context initContext = new InitialContext(); // InitialContext : context가 초기화 될때 
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			
			//jdbc.myoracle이란 이름을 객체를 찾아서 DataSource가 받는다.
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			
			//ds가 생성되었으므로 connection을 구합니다.
			conn = ds.getConnection();
			//etc.
		} catch (NamingException e) {
			System.out.println("dri load err => " +e.getMessage());
		} catch (SQLException e) {
			System.out.println("conn err => "+e.getMessage());
		}
		return conn;
		
	}
	
	//select을 수행한 후 리소스 해제를 위한 메소드
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("close err3" + e.getMessage());
		}
		
	}
	
	//insert, update, delete 작업을 수행한 후 리소스 해제를 위한 메소드
	public static void close(Connection conn, Statement stmt) {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("close err2" + e.getMessage());	
		}
	}
}

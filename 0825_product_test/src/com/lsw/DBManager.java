package com.lsw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	public static Connection getConnection() {
		
		final String dri = "oracle.jdbc.driver.OracleDriver";
		final String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		
		Connection conn = null;
		
		try {
			Class.forName(dri);
			conn = DriverManager.getConnection(url, "lsw", "1234");
			
		} catch (ClassNotFoundException e) {
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

package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBManager {
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String id = "choehun"; // 아이디
	private static String pw = "1234"; // 비밀번호
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static Connection conn;
	public DBManager() {
		// TODO Auto-generated constructor stub
	}

	public static Connection getConnection() {
		try {
		
			Class.forName(driver);
			System.out.println("driver 연결 성공");
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("connection 성공");
		} catch (ClassNotFoundException e) {
					System.out.println(e.getMessage()+"driver err");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"connection err");
		}
		return conn;

	}
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"close err");
		}
	
	}
	public static void close(Connection conn, Statement stmt) {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"close err");
		}
		
	}
}

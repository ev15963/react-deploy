package com.kjh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	public static Connection conn = null;
	public static PreparedStatement pstmt = null;
	public Statement stmt = null;
	public ResultSet rs = null;
	
	private final static String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String ORACLE_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	
	public DBManager() {
	}
	
	public static void connect() {
		try {
			Class.forName(ORACLE_DRIVER);
			System.out.println("=> 드라이버 로딩 성공");
			
			conn = DriverManager.getConnection(ORACLE_URL, "kjh", "5455");
			System.out.println("=> DB 접속 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver ERR : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("connect ERR : " + e.getMessage());
		}
	} // connect() END
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("CLOSED ERR => " + e.getMessage());
		}
	} // close() END
	
	public static void close(Connection conn, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("CLOSED ERR => " + e.getMessage());
		}
	} // close() END

}

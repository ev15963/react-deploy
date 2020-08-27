package com.lsw.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManger {
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String dri = "oracle.jdbc.driver.OracleDriver";
	private static String id = "lsw";
	private static String pwd = "1234";
	
	public static Connection getConnecton() {
		Connection conn = null;
		try {
			Class.forName(dri);
			conn = DriverManager.getConnection(url, id, pwd);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	

	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("close csr err : "+e.getMessage());
		}
		
	}
	
	public static void close(Connection conn, Statement stmt) {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("close cs err : "+e.getMessage());
		}
		
	}
}

package com.lsw.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManger {
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String id = "lsw";
	private static String pwd = "1234";
	
	public void Connection() {
		try {
			Class.forName(url);
			Connection conn = DriverManager.getConnection(url, id, pwd);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

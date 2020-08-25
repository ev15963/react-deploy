package com.lsw;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {
	public static Connection getConnection() {
		return null;
		
	}
	
	//select을 수행한 후 리소스 해제를 위한 메소드
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		
	}
	
	//insert, update, delete 작업을 수행한 후 리소스 해제를 위한 메소드
	public static void close(Connection conn, Statement stmt) {
		
	}
}

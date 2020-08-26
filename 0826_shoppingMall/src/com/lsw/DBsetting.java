package com.lsw;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBsetting {


	public void closeMethod(Connection conn, Statement stmt, ResultSet rs) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("closeMethod err1 : "+e.getMessage());
		}
	}
	
	public void closeMethod(Connection conn, Statement stmt) {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("closeMethod err2 : "+e.getMessage());
		}
	}
	
}

package com.lsw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.lsw.dto.BoardModel;

public class BoardDAO {

	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public Statement stmt = null;
	public ResultSet rs = null;
	public int r = 0;

	private final String dri = "oracle.jdbc.driver.OracleDriver";
	private final String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	
	/** 접속 메서드 : 각 Servlet 에서 가장 먼저 호출 **/
	public void connection() {
		try {
			Class.forName(dri);
			conn = DriverManager.getConnection(url, "lsw", "1234");
			System.out.println("연결");
		} catch (ClassNotFoundException e) {
			System.out.println("driver err : "+e.getMessage());
		} catch (SQLException e) {
			System.out.println("conn err : "+e.getMessage());
		}

	}
	
	/**
	 * 게시판 목록 조회 : BoardListServlet의 doGet()에서 호출
	 * 
	 * 
	 * 
	 */
	public List<BoardModel> selectList(BoardModel boardModel) { //매개변수 추가
		String query = "select no, subject, writer, hit from board_search_tbl";
		return null;
	} // selectList() end
	

	/**
	 * 게시판 총 레코드 수 조회 : BoardListServlet의 doGet()에서 전체 데이터 조회 전에 호출
	 * 
	 * 
	 * 
	 */
	public int selectCount(BoardModel boardModel) { //매개변수 추가
		int totalCount = 0;
		
		String query = "select count(no) as total from board_search_tbl";
		try {
			this.stmt = this.conn.createStatement();
			this.rs = this.stmt.executeQuery(query);
			if(rs.next()) {
				totalCount = this.rs.getInt("TOTAL");
			}
		} catch (SQLException e) {
			System.out.println("conn err : "+e.getMessage());
		}
		return totalCount;
		
	} // selectList() end
	
}

package com.lsw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
			System.out.println("driver err : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("conn err : " + e.getMessage());
		}

	}

	/**
	 * 게시판 목록 조회 : BoardListServlet의 doGet()에서 호출
	 * 
	 * 
	 * 
	 */
	public List<BoardModel> selectList(BoardModel boardModel) { // 매개변수 추가
		String query = "select no, subject, writer, hit, regdate from board_search_tbl";
		List<BoardModel> list = null;

		try {
			this.stmt = this.conn.createStatement();
			this.rs = this.stmt.executeQuery(query);

			list = new ArrayList<BoardModel>();
			BoardModel model = null;

			while (rs.next()) {
				model = new BoardModel();
				model.setNo(rs.getInt("no"));
				model.setSubject(rs.getString("subject"));
				model.setWriter(rs.getString("writer"));
				model.setHit(rs.getInt("hit"));
				model.setRegdate(rs.getString("regdate"));
				list.add(model);
				model = null;
			}
		} catch (SQLException e) {
			System.out.println("selectList() ERR => " + e.getMessage());
		}
		return list;
	} // selectList() end

	/**
	 * 게시판 총 레코드 수 조회 : BoardListServlet의 doGet()에서 전체 데이터 조회 전에 호출
	 * 
	 * 
	 * 
	 */
	public int selectCount(BoardModel boardModel) { // 매개변수 추가
		int totalCount = 0;
		List<BoardModel> list = null;

		String query = "select count(no) as total from board_search_tbl";

		if (rs.next()) {
			totalCount = this.rs.getInt("TOTAL");
		}

		return totalCount;

	} // selectList() end

	/**
	 * 게시글 검색 처리
	 * 
	 * 
	 * 
	 */
	public void search() {
		String query = "select * from board_search_tbl where subject like '%4'";
		
		try {
			this.stmt = this.conn.createStatement();
			this.rs = this.stmt.executeQuery(query);
			ArrayList<BoardModel> list = null;
			list = new ArrayList<BoardModel>();
			BoardModel bm = null;
			while (rs.next()) {
				bm = new BoardModel();
				bm.setNo(rs.getInt("no"));

			}

		} catch (SQLException e) {
			System.out.println("conn err : " + e.getMessage());
		}
	}

	/**
	 * 사용이 끝난 자원 해제 : 각 Servlet 에서 가장 나중에 호출
	 * 
	 * 
	 * 
	 */
	public void close() {
		try {
			if (rs != null)
				rs.close();

			if (pstmt != null)
				pstmt.close();

			if (conn != null)
				conn.close();

		} catch (SQLException e) {
			System.out.println("자원해제 err : " + e.getMessage());
		}
	} // insert() end

}

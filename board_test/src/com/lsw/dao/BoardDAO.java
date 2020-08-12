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

	public BoardDAO() { // 생성자

	}

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
	public List<BoardModel> selectList() {
		String query = "select no, subject, writer, hit from board_tbl";
		return null;
	} // selectList() end

	/**
	 * 게시판 목록 조회 : BoardListServlet의 doGet()에서 호출
	 * 
	 * 
	 * 
	 */
	public BoardModel selectOne(BoardModel boardModel) {
		String query = select
		return null;
	} // selectOne() end

	/**
	 * 게시판 등록 조회 : BoardWriteServlet의 doPost()에서 호출
	 * 
	 * 
	 * 
	 */
	public void insert(BoardModel boardModel) {
		
	} // insert() end
	
	/**
	 * 게시판 수정 처리 : BoardWriteServlet의 doPost()에서 호출
	 * 
	 * 
	 * 
	 */
	public void update(BoardModel boardModel) {
		
	} // update() end
	
	/**
	 * 게시판 조회수 증가 처리 및 조회수 수정 : BoardWriteServlet의 doGet()에서 호출
	 * 
	 * 
	 * 
	 */
	public void updateHit(BoardModel boardModel) {
	} // updateHit() end
	
	/**
	 * 게시글 삭제 처리 : BoardWriteServlet의 doGet()에서 호출
	 * 
	 * 
	 * 
	 */
	public void delete(BoardModel boardModel) {
	} // delete() end
	
	/**
	 * 사용이 끝난 자원 해제 : 각 Servlet 에서 가장 나중에 호출
	 * 
	 * 
	 * 
	 */
	public void close() {
		try {
			if(rs !=null)
				rs.close();
			
			if(pstmt !=null)
				pstmt.close();
			
			if(conn !=null)
				conn.close();
			
		} catch (SQLException e) {
			System.out.println("자원해제 err : "+e.getMessage());
		}
	} // insert() end
};
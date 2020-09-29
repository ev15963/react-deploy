package com.lsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.lsw.DBManager.DBManager;
import com.lsw.vo.BoardVO;

public class BoardDAO {
	private BoardDAO() {
		
	}
	
	private static BoardDAO instance= new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	public List<BoardVO> selectAllBoards() {
		String sql="select * from boardtest1 order by num desc";
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				BoardVO bVo= new BoardVO();
				
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setEmail(rs.getString("email"));
				bVo.setPass(rs.getString("pass"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
				
				list.add(bVo);
				
				
			}
		} catch (Exception e) {
			System.out.println("selectAllBoards err : "+e.getMessage());
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}
	
	public void insertBoard(BoardVO bVo) {
		String sql="insert into boardtest1 (num, name, email, pass, title, content, writedate) values (board_seq.nextval, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bVo.getName());
			pstmt.setString(2, bVo.getEmail());
			pstmt.setString(3, bVo.getPass());
			pstmt.setString(4, bVo.getTitle());
			pstmt.setString(5, bVo.getContent());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insertBoard err : "+e.getMessage());
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void updateReadCount(String num) {
		String sql="update boardtest1 set readcount = readcount+1 where num=?";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("updateReadCount err : "+e.getMessage());
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	/**
	 * 게시글 상세 내용 보기 : 글번호로 찾아오기
	 * */
	public BoardVO selectOnBoardByNum(String num) {
		String sql = "select * from boardtest1 where num=?";
		
		BoardVO bVo =null;
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = DBManager.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				bVo=new BoardVO();

				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setPass(rs.getString("pass"));
				bVo.setEmail(rs.getString("email"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
				bVo.setReadcount(rs.getInt("readcount"));
			}
		} catch (SQLException e) {
			System.out.println("selectOnBoardByNum err : "+e.getMessage());
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return bVo;
	}
	
	public void updateBoard(BoardVO bVo) {
		String sql="update boardtest1 set name=?, email=?, pass=?, title=?, content=? where num=?";
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, bVo.getName());
			pstmt.setString(2, bVo.getEmail());
			pstmt.setString(3, bVo.getPass());
			pstmt.setString(4, bVo.getTitle());
			pstmt.setString(5, bVo.getContent());
			pstmt.setInt(6, bVo.getNum());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("updateBoard : "+e.getMessage());
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	/**
	 * 비밀번호 확인
	 * */
	
	public BoardVO checkPassword(String pass, String num) {
		String sql = "select * from boardtest1 where pass=? and num=?";

		//모두 컬럼값을 찾는데 Password와 num
		
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		BoardVO bVo = null;
		
		conn=DBManager.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, pass);
			pstmt.setString(2, num);
			//checkPassword(인자 String num)가 가져온 num이라서 String  이다.
		
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				bVo=new BoardVO();
				
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setEmail(rs.getString("email"));
				bVo.setPass(rs.getString("pass"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
			}
		
		} catch (SQLException e) {
			System.out.println("checkPassword : "+e.getMessage());
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bVo;
		
	}
	
	
//	private int num;
//	private String name;
//	private String email;
//	private String pass;
//	private String title;
//	private String content;
//	private int readcount;
//	private Timestamp writedate;
	
	public void deleteBoard(String num) {
		String sql = "delete boardtest1 where num=?";
		//delete 삭제한다 boardtest1 테이블을 조건은 num에 일치하는 값만
		
		Connection conn=null;
		PreparedStatement pstmt = null;
		
		conn=DBManager.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			pstmt.executeUpdate();
			//DB의 값이 변동 삭제 되기 때문에 executeUpdate 사용
			
		} catch (SQLException e) {
			System.out.println("deleteBoard err : "+e.getMessage());
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		
	}
}

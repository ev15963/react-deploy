package com.lsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lsw.dto.BoardVO;
import com.lsw.util.DBManger;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();

	private BoardDAO() {

	}

	public static BoardDAO getInstance() {
		return instance;

	}

	public List<BoardVO> selectAllBoards() {
		String sql="select * from board order by num desc";
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = DBManger.getConnecton();
		try {
			stmt = conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while (rs.next()) {
				BoardVO bVo = new BoardVO();
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
			System.out.println("selectAllBoards err"+e.getMessage());
		}
		return null;

	}

	public void insertBoard(BoardVO bVo) {
		String sql ="insert into board (num, name, email, pass, title, content) "
				+ "values(board_seq.nextval, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		conn = DBManger.getConnecton();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bVo.getName());
			pstmt.setString(2, bVo.getEmail());
			pstmt.setString(3, bVo.getPass());
			pstmt.setString(4, bVo.getTitle());
			pstmt.setString(5, bVo.getContent());
			
			pstmt.executeUpdate();
			
			int r=pstmt.executeUpdate();
			if(r>0) {
				System.out.println("등록 성공");
			} else {
				System.out.println("등록 실패");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateReadCount(String num) {

	}

	// 게시판 글 상세 내용 보기 : 글번호로 찾아온다 : 실패 null
	public BoardVO selectOneBoardByNum(String num) {
		return null;

	}

	public void updateBoard(BoardVO bVo) {

	}

	public BoardVO checkPassWord(String pass, String num) {
		return null;

	}

	public void deleteBoard(String num) {

	}

}

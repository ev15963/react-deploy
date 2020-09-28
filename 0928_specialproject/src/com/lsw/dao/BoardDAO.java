package com.lsw.dao;

import java.sql.Connection;
import java.sql.ResultSet;
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
		String sql="select * from boardtest1; order by num desc";
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
}

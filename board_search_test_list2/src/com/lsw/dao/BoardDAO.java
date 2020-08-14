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
	public PreparedStatement pstmt =null;
	public Statement stmt =null;
	public ResultSet rs =null;
	public int r = 0;
	
	public final String dri = "oracle.jdbc.driver.OracleDriver";
	public final String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	
	public void connect() {
		try {
			Class.forName(dri);
			conn = DriverManager.getConnection(url, "lsw", "1234");
			System.out.println("CONN 연결");
		} catch (ClassNotFoundException e) {
			System.out.println("driver err : "+e.getMessage());
		} catch (SQLException e) {
			System.out.println("conn err : "+e.getMessage());
		}
	}
	
	public List<BoardModel> selectList(BoardModel model) {

		String searchType = model.getSearchType();
		String searchText = model.getSearchText();
		String whereSQL="";
		
		System.out.println(">>> searchText<<<" + searchText);
		
		//검색어 쿼리문 완성
		if (!searchText.equals("")) {
			if (searchType.equals("ALL")) {
				whereSQL += " subject LIKE? OR writer LIKE ? OR contents LIKE ? AND ";
				System.out.println("ALL"+whereSQL);
			} else if (searchType.equals("SUBJECT")) {
				whereSQL += " subject LIKE ? AND ";
			} else if (searchType.equals("WRITER")) {
				whereSQL += " writer LIKE ? AND ";
			} else if (searchType.equals("CONTENTS")) {
				whereSQL += " contents LIKE ? AND ";
			}
		}// 검색어 쿼리문 종료
		
		String basic_query="select no, subject, writer, hit, regdate from board_search_tbl";
		String last_query=" where no between ? and ? order by no desc";
		
		return null;
		
	}
}

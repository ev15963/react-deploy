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
		String bl = basic_query+last_query;
		
		System.out.println("model.getPageNum()"+model.getPageNum());
		int pNo=Integer.parseInt(model.getPageNum());
		
		int startNo=(pNo-1)*model.getListCount()+1;
		int endNo=startNo+9;
		
		System.out.println("PAGE_START_END===>"+startNo+"=="+endNo);
		
		List<BoardModel> list =null;
		System.out.println("sqllllllll"+bl);
		
		try {
			this.pstmt=this.conn.prepareStatement(bl);
			
			if(!"".equals(whereSQL)) {
				if ("ALL".equals(searchType)) {
					this.pstmt.setString(1, "&" + searchText + "%");
					this.pstmt.setString(2, "&" + searchText + "%");
					this.pstmt.setString(3, "&" + searchText + "%");
					this.pstmt.setInt(4, startNo);
					this.pstmt.setInt(5, endNo);
				} else {
					this.pstmt.setString(1, "%"+searchText+"%");
					this.pstmt.setInt(2, startNo);
					this.pstmt.setInt(3, endNo);
				}
			}
			
			this.rs = this.pstmt.executeQuery();
			list = new ArrayList<BoardModel> ();
			
			while (rs.next()) {
				model = new BoardModel();
				model.setNo(rs.getInt("no"));
				model.setWriter(rs.getString("writer"));
				model.setHit(rs.getInt("hit"));
				model.setRegdate(rs.getString("regdate"));
				
				System.out.println("==>model:members <===" + model.toString());
				list.add(model);
				model = null;
			}
		} catch (SQLException e) {
			System.out.println("selectList() err => "+e.getMessage());
			
		}
		
		return list;
		
	} //slectList()
	
	/**
	 * 게시판 총 레코드 수 조회 : BoardListServlet의 doget()에서 전체 데이터 조회 전에 호출
	 * 
	 */
	
	public int selectCount(BoardModel bm) {
		int totalCount =0;
		
		String searchType = bm.getSearchType();
		String searchText = bm.getSearchText();
		System.out.println(">>>>>searchType<<<<"+searchType);
		System.out.println(">>>>>searchText<<<<"+searchText);
		
		String whereSQL="";
		
		String sql = "select count(no) as total from board_search_tbl";
		
		//검색어 쿼리문 생성
		if (!searchText.equals("")) { //
			if(!searchText.equals("ALL")) {
				whereSQL += " subject like ? or where writer like ? where contents like ? ";
				System.out.println("ALL"+whereSQL);
			} else if (searchType.equals("SUBJECT")) {
				whereSQL += " subject like ? AND ";
			} else if (searchType.equals("WRITER")) {
				whereSQL += " writer like ? AND ";
			} else if (searchType.equals("CONTENTS")) {
				whereSQL += " contents like ? AND ";
			}
		}
	}
	 */
}

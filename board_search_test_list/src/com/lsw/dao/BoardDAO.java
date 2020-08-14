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
	public List<BoardModel> selectList(BoardModel model) { // 매개변수 추가
		// String query = "select no, subject, writer, hit, regdate from
		// board_search_tbl";
		// List<BoardModel> list = null;
		//
		String searchType = model.getSearchType();
		String searchText = model.getSearchText();
		String whereSQL = "";

		System.out.println(">>> searchText<<<" + searchText);

		// 검색어 쿼리문 완성
		if (!searchText.equals("")) { //
			if (searchType.equals("ALL")) {
				whereSQL += " WHERE subject LIKE? OR writer LIKE ? OR contents LIKE ? ";
				System.out.println("ALL" + whereSQL);
			} else if (searchType.equals("SUBJECT")) {
				whereSQL += " WHERE subject LIKE ? ";
			} else if (searchType.equals("WRITER")) {
				whereSQL += " WHERE writer LIKE ? ";
			} else if (searchType.equals("CONTENTS")) {
				whereSQL += " WHERE contents LIKE ? ";
			}
		} // 검색어 쿼리문 생성 종료

		String query = "select no, subject, writer, hit, regdate from board_search_tbl" + whereSQL;

		List<BoardModel> list = null;
		System.out.println("sqlllllllllllllllllllll"+query);
		// BoardModel model = null;
		try {
			this.pstmt = this.conn.prepareStatement(query);

			// list = new ArrayList<BoardModel>();
			// BoardModel model = null;

			if (!"".equals(whereSQL)) {
				if ("ALL".equals(searchType)) { // 전체검색
					this.pstmt.setString(1, "%" + searchText + "%");
					this.pstmt.setString(2, "%" + searchText + "%");
					this.pstmt.setString(3, "%" + searchText + "%");
				} else {
					this.pstmt.setString(1, "%" + searchText + "%");
				}
			}

			this.rs = this.pstmt.executeQuery();
			list = new ArrayList<BoardModel>();

			while (rs.next()) {
				model = new BoardModel();
				model.setNo(rs.getInt("no"));
				model.setSubject(rs.getString("subject"));
				model.setWriter(rs.getString("writer"));
				model.setHit(rs.getInt("hit"));
				model.setRegdate(rs.getString("regdate"));

				System.out.println("==>model:members <==" + model.toString());
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
	public int selectCount(BoardModel bm) { // 매개변수 추가 ////
		int totalCount = 0;

		String searchType = bm.getSearchType();
		String searchText = bm.getSearchText();
		System.out.println(">>>>searchType<<<"+searchType);
		System.out.println(">>>>searchText<<<"+searchText);
		
		String whereSQL = "";

		String query = "select count(no) as total from board_search_tbl";

		// 검색어 쿼리문 생성
		if(!searchText.equals("")) {
			if(searchType.equals("ALL")) {
				whereSQL += " where subject like ? or where writer like ? where contents like ? ";
				System.out.println("ALL"+whereSQL);
			} else if (searchType.equals("SUBJECT")) {
				whereSQL += " where subject like ? ";
				System.out.println("SUBJECT"+whereSQL);
			} else if (searchType.equals("WRITER")) {
				whereSQL += " where writer like ? ";
				System.out.println("WRITER"+whereSQL);
			} else if (searchType.equals("CONTENTS")) {
				whereSQL += " where contents like ? ";
				System.out.println("CONTENTS"+whereSQL);
			}
		}
		query += whereSQL;
		System.out.println("sqlllllllllllllllllllll22222"+query);
		try {
			this.pstmt = this.conn.prepareStatement(query);
			// 검색어 쿼리문 생성으로 이용
			if (!"".equals(whereSQL)) {
				if ("ALL".equals(searchType)) {
					this.pstmt.setString(1, "%" + searchText + "%");
					this.pstmt.setString(2, "%" + searchText + "%");
					this.pstmt.setString(3, "%" + searchText + "%");
					// whereSQL += " WHERE subject LIKE ? OR writer LIKE ? OR contents LIKE ? ";
				} else {
					this.pstmt.setString(1, "%" + searchText + "%");
					// whereSQL += " WHERE subject LIKE ? ";
					// whereSQL += " WHERE writer LIKE ? ";
					// whereSQL += " WHERE contents LIKE ? "; 셋중에 하나
				}

			}

			this.rs = this.pstmt.executeQuery(); //쿼리 실행 (날리면 안된다) 테이블 생성 할 때 execute()
			
			if (this.rs.next()) {
				totalCount = this.rs.getInt("TOTAL"); //as total로 꺼내옴
				
				System.out.println("=====> d=====> totalCount "+ totalCount);
			}
		} catch (SQLException e) {
			System.out.println("select err : " + e.getMessage());
		}
		return totalCount;
	} // selectList() end
		/////////////////////////////////////////////////////////////////

	/**
	 * 게시글 상세 조회 : BoardviewServlet의 doGet() 에서 호출
	 */
	
	public  BoardModel selectOne(BoardModel bm) {
		String sql = "select * from board_tbl  where no=?";
		BoardModel model = null;
		try {
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, bm.getNo());
			this.rs=this.pstmt.executeQuery();
			if (rs.next()) {
				model = new BoardModel();
				model.setNo(rs.getInt("no"));
				model.setSubject(rs.getString("string"));
				model.setWriter(rs.getString("wrtier"));
				model.setContents(rs.getString("contents"));
				model.setHit(rs.getInt("Hit"));


			}
		} catch (SQLException e) {
			System.out.println("selectOne err : "+e.getMessage());
		}
		return model;
	}

	/**
	 * 게시글 등록 처리 : BoardWriteServlet의 dopost()에서 호출
	 * 
	 * 
	 */
	public void insert(BoardModel boardModel) {
		String query = "insert into board_tbl (no, subject, writer, contents)";
		query += " values (board_seq.nextval, ?, ?, ?)";

		try {
			this.pstmt = this.conn.prepareStatement(query);
			this.pstmt.setString(1, boardModel.getSubject());
			this.pstmt.setString(2, boardModel.getWriter());
			this.pstmt.setString(3, boardModel.getContents());
			this.r = this.pstmt.executeUpdate();
			if (this.r > 0) {
				System.out.println("insert 드갔다");
			}
		} catch (SQLException e) {
			System.out.println("insert 오류 : " + e.getMessage());
		}

	}

	/**
	 * 게시글 수정 처리 : BoardModifyServlet의 dopost()에서 호출
	 */

	public void update(BoardModel bm) {
		String query = "update board_tbl set subject=?, writer=?, contents=?";
		query += " where no=?";

		try {
			this.pstmt = this.conn.prepareStatement(query);
			this.pstmt.setString(1, bm.getSubject());
			this.pstmt.setString(2, bm.getWriter());
			this.pstmt.setString(3, bm.getContents());
			this.pstmt.setInt(4, bm.getNo());
			this.r = this.pstmt.executeUpdate();
			if (this.r > 0) {
				System.out.println("연결성공");
			}
		} catch (SQLException e) {
			System.out.println("update conn err : " + e.getMessage());
		}

	}

	/**
	 * 게시글 조회수증가 처리 및 조회수 수정 : BoardViewServlet의 doGet()에서 더에터 조회 전에 호출
	 */
	public void updateHit(BoardModel bm) {
		String sql = "update board_tbl set hit=hit+1 where no=?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, bm.getNo());
			this.r = pstmt.executeUpdate();
			if (this.r > 0) {
				System.out.println("updateHit 연결");
			}
		} catch (SQLException e) {
			System.out.println("updateHit err" + e.getMessage());
		}
	}

	/**
	 * 게시글 삭제 처리 : BoardDeleteServlet의 deGet()에서 호출
	 */

	public void delete(BoardModel bm) {
		String sql = "delete from board_tbl where no=?";
		try {
			this.pstmt = conn.prepareStatement(sql);
			this.pstmt.setInt(1, bm.getNo());
			this.r = this.pstmt.executeUpdate();
			if (this.r > 0) {
				System.out.println("delete 연결 성공");
			}
		} catch (SQLException e) {
			System.out.println("delete err : " + e.getMessage());
		}
	}

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
				bm.setSubject(rs.getString("subject"));
				bm.setWriter(rs.getString("subject"));
				bm.setHit(rs.getInt("hit"));
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

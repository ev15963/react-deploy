package com.freeflux.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.freeflux.dto.BoardModel;

/** 실제 Oracle DB에 접속 : 각 Servlet 에서 사용 **/
public class BoardDAO {

	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public Statement stmt = null;
	public ResultSet rs = null;
	public int r = 0;

	private final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String ORACLE_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";

	/** 기본 생성자 : 각 Servlet 에서 가장 먼저 객체 생성 시 **/
	public BoardDAO() {
	}

	/** 접속 메서드 : 각 Servlet 에서 가장 먼저 호출 **/
	public void connect() {
		try {
			Class.forName(ORACLE_DRIVER);
			System.out.println("==> 드라이버 로딩 성공!");

			this.conn = DriverManager.getConnection(ORACLE_URL, "freeflux", "free");
			System.out.println("==> DB접속성공!");

		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER LOAD ERR => " + e.getMessage());

		} catch (SQLException e) {
			System.out.println("CONNECT ERR => " + e.getMessage());
		}
	}

	/**
	 * 게시판 목록 조회 : BoardListServlet의 doGet() 에서 호츨
	 * 
	 * @param boardModel
	 * @return
	 */
	public List<BoardModel> selectList(BoardModel boardModel) {
		String searchType = boardModel.getSearchType();
		String searchText = boardModel.getSearchText();
		String whereSQL = "";
		
System.out.println(" >>> searchText<<< "+searchText);

		// 검색어 쿼리문 생성
		if (!searchText.equals("")) {
			if (searchType.equals("ALL")) {
				whereSQL += " WHERE subject LIKE ? OR writer LIKE ? OR contents LIKE ? ";
System.out.println("ALL"+whereSQL);

			} else if (searchType.equals("SUBJECT")) {
				whereSQL += " WHERE subject LIKE ? ";
				
			} else if (searchType.equals("WRITER")) {
				whereSQL += " WHERE writer LIKE ? ";
				
			} else if (searchType.equals("CONTENTS")) {
				whereSQL += " WHERE contents LIKE ? ";
			}
		}   // 검색어 쿼리문 생성 종료

		String sql_query = "SELECT no, subject, writer, hit, moddate FROM  board_search_tbl"+whereSQL;
		
System.out.println("+++> sql_query <++++ "+sql_query);

		List<BoardModel> list = null;

		try {
			this.pstmt = this.conn.prepareStatement(sql_query);
			
			if (!"".equals(whereSQL)) {
				if ("ALL".equals(searchType)) {			// 전체검색일 경우
					this.pstmt.setString(1, "%"+searchText+"%");
					this.pstmt.setString(2, "%"+searchText+"%");
					this.pstmt.setString(3, "%"+searchText+"%");
				} else {
					this.pstmt.setString(1, "%"+searchText+"%");
				}
			} 
			
			
			this.rs = this.pstmt.executeQuery();

			list = new ArrayList<BoardModel>();
			BoardModel model = null;

			while (this.rs.next()) {
				model = new BoardModel();
				model.setNo(this.rs.getInt("no"));
				model.setSubject(this.rs.getString("subject"));
				model.setWriter(this.rs.getString("writer"));
				model.setHit(this.rs.getInt("hit"));
				model.setModdate(this.rs.getString("moddate"));

System.out.println("==>model : members <==" + model.toString());

				list.add(model);
				model = null;
			}

System.out.println("==> List : size <==" + list.size());

		} catch (SQLException e) {
			System.out.println("selectList() ERR => " + e.getMessage());
		}
		return list;
	} // selectList() END

	
	/** ============================================================== **/

	/**
	 * 게시판 총 레코드 수 조회 : BoardListServlet의 doGet() 에서 전체 데이터 조회전에 호츨
	 * 
	 * @param boardModel
	 * @return
	 */
	public int selectCount(BoardModel boardModel) {
		int totalCount = 0;
		
		String searchType = boardModel.getSearchType();
		String searchText = boardModel.getSearchText();
		String whereSQL = "";

		String sql_query = "SELECT COUNT(NO) AS TOTAL FROM board_search_tbl";

//		// 검색어 쿼리문 생성
//		if (!searchText.equals("")) {
//			if (searchType.equals("ALL")) {
//				whereSQL += " WHERE subject LIKE ? OR writer LIKE ? OR contents LIKE ? ";
//				System.out.println("ALL"+whereSQL);
//			} else if (searchType.equals("SUBJECT")) {
//				whereSQL += " WHERE subject LIKE ? ";
//			} else if (searchType.equals("WRITER")) {
//				whereSQL += " WHERE writer LIKE ? ";
//			} else if (searchType.equals("CONTENTS")) {
//				whereSQL += " WHERE contents LIKE ? ";
//			}
//		}
//		sql_query+=whereSQL;
		try {
			// 게시물의 총 수를 얻는 쿼리 실행
			this.pstmt = this.conn.prepareStatement(sql_query);
			
//			if (!whereSQL.equals("")) {
//				if (searchType.equals("ALL")) {
//					this.pstmt.setString(1, "%"+searchText+"%");
//					this.pstmt.setString(2, "%"+searchText+"%");
//					this.pstmt.setString(3, "%"+searchText+"%");
//				} else {
//					this.pstmt.setString(1, "%"+searchText+"%");
//				}
//			}
			this.rs = this.pstmt.executeQuery();
			if (this.rs.next()) {
				totalCount = this.rs.getInt("TOTAL");
			}
		} catch (SQLException e) {
			System.out.println("selectCount() ERR => " + e.getMessage());
		}
		return totalCount;
	} // selectCount() END

	/** ============================================================== **/

	/**
	 * 게시글 상세 조회 : BoardViewServlet의 doGet() 에서 호츨
	 * 
	 * @param boardModel
	 * @return
	 */
	public BoardModel selectOne(BoardModel boardModel) {
		String sql_query = "select * from board_tbl  where no=?";
		BoardModel model = null;
		try {
			this.pstmt = this.conn.prepareStatement(sql_query);
			this.pstmt.setInt(1, boardModel.getNo());
			this.rs = this.pstmt.executeQuery();
			if (rs.next()) {
				model = new BoardModel();
				model.setNo(rs.getInt("no"));
				model.setSubject(rs.getString("subject"));
				model.setWriter(rs.getString("writer"));
				model.setContents(rs.getString("contents"));
				model.setHit(rs.getInt("hit"));
			}
		} catch (SQLException e) {
			System.out.println("selectOne() ERR => " + e.getMessage());
		}

		return model;
	} // selectOne() END

	/**
	 * 게시글 등록 처리 : BoardWriteServlet의 doPost() 에서 호츨
	 * 
	 * @param boardModel
	 */
	public void insert(BoardModel boardModel) {
		String sql_query = "insert into board_tbl (no, subject, writer, contents)";
		sql_query += " values (board_seq.nextval, ?, ?, ?)";

		try {
			this.pstmt = this.conn.prepareStatement(sql_query);
			this.pstmt.setString(1, boardModel.getSubject());
			this.pstmt.setString(2, boardModel.getWriter());
			this.pstmt.setString(3, boardModel.getContents());
			this.r = this.pstmt.executeUpdate();
			if (this.r > 0) {
				System.out.println("=> INSERT  SUCCESS !!");
			}
		} catch (SQLException e) {
			System.out.println("insert() ERR => " + e.getMessage());
		}
	} // insert() END

	/**
	 * 게시글 수정 처리 : BoardModifyServlet의 doPost() 에서 호츨
	 * 
	 * @param boardModel
	 */
	public void update(BoardModel boardModel) {
		String sql_query = "update board_tbl set subject=?, writer=?, contents=?";
		sql_query += " where no=?";
		try {
			this.pstmt = this.conn.prepareStatement(sql_query);
			this.pstmt.setString(1, boardModel.getSubject());
			this.pstmt.setString(2, boardModel.getWriter());
			this.pstmt.setString(3, boardModel.getContents());
			this.pstmt.setInt(4, boardModel.getNo());
			this.r = this.pstmt.executeUpdate();
			if (this.r > 0) {
				System.out.println("=> UPDATE  SUCCESS !!");
			}
		} catch (SQLException e) {
			System.out.println("update() ERR => " + e.getMessage());
		}

	}

	/**
	 * 게시글 조회수 증가 처리 및 조회수 수정 : BoardViewServlet의 doGet() 에서 데이터 조회전에 호츨
	 * 
	 * @param boardModel
	 */
	public void updateHit(BoardModel boardModel) {
		String sql_query = "update board_tbl set hit=hit+1 where no=?";
		try {
			this.pstmt = this.conn.prepareStatement(sql_query);
			this.pstmt.setInt(1, boardModel.getNo());
			this.r = this.pstmt.executeUpdate();
			if (this.r > 0) {
				System.out.println("=> UPDATE HIT  SUCCESS !!");
			}
		} catch (SQLException e) {
			System.out.println("updateHit() ERR => " + e.getMessage());
		}

	}

	/**
	 * 게시글 삭제 처리 : BoardDeleteServlet의 doGet() 에서 호츨
	 * 
	 * @param boardModel
	 */
	public void delete(BoardModel boardModel) {
		String sql_query = "delete from board_tbl where no=?";
		try {
			this.pstmt = this.conn.prepareStatement(sql_query);
			this.pstmt.setInt(1, boardModel.getNo());
			this.r = this.pstmt.executeUpdate();
			if (this.r > 0) {
				System.out.println("=> DELETE  SUCCESS !!");
			}
		} catch (SQLException e) {
			System.out.println("delete() ERR => " + e.getMessage());
		}

	}

	/**
	 * 사용이 끝난 자원 해제 : 각 Servlet 에서 가장 나중에 호출
	 * 
	 * @param boardModel
	 */
	public void close() {
		try {
			if (this.rs != null) {
				this.rs.close();
			}
			if (this.stmt != null) {
				this.stmt.close();
			}
			if (this.pstmt != null) {
				this.pstmt.close();
			}
			if (this.conn != null) {
				this.conn.close();
			}
		} catch (SQLException e) {
			System.out.println("CLOSED ERR => " + e.getMessage());
		}
	}

}

package board.dao;

/** Connection, ProparedStatement, 쿼리 실행관련 **/

import java.sql.*;
import java.util.ArrayList;

//-----------------------------------------------------
/** Context(Interface이다.), InitialContext 객체**/
// lookup(찾고자하는 이름(JNDI명) -> 탐색기에서 검색하는 것과 같은 느낌

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
//-----------------------------------------------------
/** 추가 (JNDI 방식) **/
//DataSource 객체 -> getConnection()
import javax.sql.DataSource;

import board.command.BoardCommand; //사용자 직접 입력값
import board.dto.BoardDTO; //디비 찾을 때

public class BoardDAO {
	DataSource ds;
	
	//생성자 : DateSource 얻기 : InitialContext와 JNDI명
	public BoardDAO() {
		try {
			// InitialContext ctx = new InitialContext(); 이것도 가능
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/orcl");
			System.out.println("ds:"+ds);
			System.out.println("연결성공");
		} catch (NamingException e) {
			System.out.println(e.getMessage()+"연결 오류");
		}
	}
	
	
	/*글 목록 조회 메서드 */
	public ArrayList<BoardDTO> list() {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		String sql = "select * from springboard order by num desc";
		Connection con;
		try {
			con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				BoardDTO data = new BoardDTO();

				data.setNum(rs.getInt("num"));
				data.setAuthor(rs.getString("author"));
				data.setTitle(rs.getString("title"));
				data.setContent(rs.getString("content"));
				data.setDate(rs.getString("num"));
				data.setReadcnt(rs.getInt("readcnt"));
				
				list.add(data);
			} //end while
			
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("list err"+e.getMessage());
		}
		return list;
	}
}

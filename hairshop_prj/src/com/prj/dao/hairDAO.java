package com.prj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.prj.dto.hairDTO;
import com.prj.dto.hairVO;
import com.prj.util.DBManager;

public class hairDAO {

	private static hairDAO instance;

	public hairDAO() {
		// TODO Auto-generated constructor stub
	}

	public static hairDAO getInstance() {
		// TODO Auto-generated method stub
		return instance;
	}

	// 관리자 로그인
	public int wokerCheck(String workerid, String workerpw) {
		String sql = "select workerpw from worker where workerid=?";
		int result = -1;
		// 디비와 연동
		Connection conn = null;
		// 쿼리문(select)을 수행하기 위한 문장 객체
		PreparedStatement pstmt = null;
		// 결과값을 저장할 ResultSet
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, workerid);
			rs = pstmt.executeQuery();
			if (rs.next()) { // 아이디가 일치하면
				result = 0;
				String dbpw = rs.getString(1);
				if (dbpw.equals(workerpw)) {
					result = 1;
				}
			}
			DBManager.close(conn, pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + "로그인 체크 err");
		}
		return result;

	}// wokerCheck end

	// 등록,회원 가입
	public int costomer_insert(hairVO hVO) {// 상우 완료
		int result = 0;
		String sql = "insert into member(id, pwd, name, phoneNumber, address, enrollDate) values(?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hVO.getId());
			pstmt.setString(2, hVO.getPw());
			pstmt.setString(3, hVO.getName());
			pstmt.setString(4, hVO.getPhone());
			pstmt.setString(5, hVO.getAddress());
			pstmt.setString(6, hVO.getEnroll());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("customer_insert err : "+e.getMessage());
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	// 검색 (이름, 전화번호 뒷자리(4))
	public void costomer_searchone() {
		String sql = "select * from rPWjd";
		int result = -1;
		// 디비와 연동
		Connection conn = null;
		// 쿼리문(select)을 수행하기 위한 문장 객체
		PreparedStatement pstmt = null;
		// 결과값을 저장할 ResultSet
		ResultSet rs = null;
	}

	// 삭제
	public void costomer_delete(int id) {// 상우 완료
		String sql = "delete from table where id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 예약
	public void costomer_appointment() {

	}

	// 상세 보기
	public void costomer_detailview() {

	}

	// 전체 보기
	public void costmoer_selectList() {// 상우 완료
//		String sql = "select * from;"
	}

	// 정보 갱신
	public void costmoer_update(hairVO hVO) {// 상우 완료
		String sql = "update rPWjd set name=?, phonenumber=?, address=?, enroll=? where id is not null";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hVO.getName());
			pstmt.setString(2, hVO.getPhone());
			pstmt.setString(3, hVO.getAddress());
			pstmt.setString(4, hVO.getEnroll());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	
	///////
	public ArrayList<hairDTO> customer_selectList() {

		return null;

	}

	// 시술 내역, 날짜
	public void procedure_enroll() {
		String sql = "select rsv_date, p_type from sangSE where id=?";
		int i = 0;
		Connection conn = null;
		// 쿼리문(select)을 수행하기 위한 문장 객체
		PreparedStatement pstmt = null;
		// 결과값을 저장할 ResultSet
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			pstmt.setString(1, rs.getString("id"));
			while (rs.next()) {
				rs.getString("rsv_date");
				rs.getString("p_type");
			}
			i = pstmt.executeUpdate();
			System.out.println(i + "시술 내역 + 날짜 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + "시술 날짜 내역 오류");
		}

	}
	
	
//	아이디 중복확인
	public static boolean customer_searchone(String id) {
		
		String sql = "select id from member";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while(rs.next() ) {
				if(rs.getString("id").equals(id)) {
					return true;
				}
			}
			
		} catch (SQLException e) {
			System.out.println("customer_searchone err : "+e.getMessage());
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return false;
	}

}

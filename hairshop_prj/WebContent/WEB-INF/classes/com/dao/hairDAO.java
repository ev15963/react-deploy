package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBmanager;

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
			conn = DBmanager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) { // 아이디가 일치하면
				result = 0;
				String dbpw = rs.getString(1);
				if (dbpw.equals(workerpw)) {
					result = 1;
				}
			}
			DBmanager.close(conn, pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + "로그인 체크 err");
		}
		return result;

	}// wokerCheck end

	// 등록,회원 가입
	public void costomer_insert() {//상우 완료
		
	}
	//검색 (이름, 전화번호 뒷자리(4))
	public void  costomer_searchone() {
		String sql = "select * from rPWjd lㅑ";
		int result = -1;
		// 디비와 연동
		Connection conn = null;
		// 쿼리문(select)을 수행하기 위한 문장 객체
		PreparedStatement pstmt = null;
		// 결과값을 저장할 ResultSet
		ResultSet rs = null;
	}
	//삭제
	public void costomer_delete(){//상우 완료
				
	}
	//예약
	public void costomer_appointment() {
		
	}
	//상세 보기
	public void costomer_detailview() {
		
	}
	//전체 보기
	public void costmoer_selectList() {//상우 완료
		
	}
	//정보 갱신
	public void costmoer_update() {//상우 완료
		
	}
	//시술 내역, 날짜
	public void procedure_enroll() {
		String sql = "select rsv_date, p_type from sangSE where id=?";
		int i=0;
		Connection conn = null;
		// 쿼리문(select)을 수행하기 위한 문장 객체
		PreparedStatement pstmt = null;
		// 결과값을 저장할 ResultSet
		ResultSet rs = null;		
		try {
			conn=DBmanager.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			pstmt.setString(1, rs.getString("id"));
			while(rs.next()) {
				rs.getString("rsv_date");
				rs.getString("p_type");
			}
		i=pstmt.executeUpdate();
		System.out.println(i+"시술 내역 + 날짜 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"시술 날짜 내역 오류");
		}
		
	}

}

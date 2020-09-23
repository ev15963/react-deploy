package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.hairVO;
import com.util.DBManager;


public class hairDAO {

	private static hairDAO instance= new hairDAO();

	public hairDAO() {
		// TODO Auto-generated constructor stub
	}	
	public static hairDAO getInstance() {
		// TODO Auto-generated method stub
		return instance;
	}

	// 관리자 로그인
	public int wokerCheck(String userid, String userpw) {
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
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if (rs.next()) { // 아이디가 일치하면
				result = 0;
				String dbpw = rs.getString(1);
				if (dbpw.equals(userpw)) {
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
	public void costomer_insert() {//상우 완료
		
	}
	//검색 (이름, 전화번호 뒷자리(4))
	
	public void  costomer_searchone() {
		String sql = "select * from rPWjd where id=%?% || phoneNumber=";
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
	public ArrayList<hairVO> costomer_appointmentlist() {
		String sql = "select d.rsv_date, d.rsv_time, r.name, r.phonenumber, d.rsv_date, d.p_type"
				+ " from rPWjd r, dPdir d where r.id = d.id"; 
				
		ArrayList<hairVO> list = new ArrayList<hairVO>();
		
		// 디비와 연동
		Connection conn = null;
		// 쿼리문(select)을 수행하기 위한 문장 객체
		PreparedStatement pstmt = null;
		// 결과값을 저장할 ResultSet
		ResultSet rs = null;
		
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				hairVO hvo = new hairVO();
				hvo.setRsv_date(rs.getString("rsv_date"));
				hvo.setRsv_time(rs.getString("rsv_time"));
				hvo.setName(rs.getString("name"));
				hvo.setphoneNumber(rs.getString("phonenumber"));
				hvo.setRsv_date(rs.getString("rsv_date"));
				hvo.setP_type(rs.getString("p_type"));
				list.add(hvo);
			}
			System.out.println("예약 리스트 확인 "+list);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"예약 QUERY 오류");
		}
		return list;
		
	}
	//예약 확정
	public int costomer_appointment() {
		String sql = "select workerpw from worker where workerid=?";
		int result = 0;
		// 디비와 연동
		Connection conn = null;
		// 쿼리문(select)을 수행하기 위한 문장 객체
		PreparedStatement pstmt = null;
		// 결과값을 저장할 ResultSet
		ResultSet rs = null;
		return result;
		
	}
	//상세 보기
	public void costomer_detailview() {
		
	}
	//전체 보기
	public ArrayList<hairVO> costmoer_selectList() {//상우 완료
		String sql = "select d.rsv_date, d.rsv_time, d.p_type, d.id, s.rsv_date, s.p_type,"+ 
				" from dPdir d, sangSE s where d.id=s.id";
		
		ArrayList<hairVO> list = new ArrayList<hairVO>();
		
		// 디비와 연동
		Connection conn = null;
		// 쿼리문(select)을 수행하기 위한 문장 객체
		PreparedStatement pstmt = null;
		
		
		// 결과값을 저장할 ResultSet
		ResultSet rs = null;
		return null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				hairVO hvo = new hairVO();
				hvo.setRsv_date(rs.getString("rsv_date"));
				hvo.setRsv_time(rs.getString("rsv_time"));
				hvo.setP_type(rs.getString("p_type"));
				hvo.setId(rs.getString("id"));
				hvo.setRsv_date(rs.getString("rsv_date"));
				hvo.setP_type(rs.getString("p_type"));
				list.add(hvo);
			}
			System.out.println("예약 리스트 확인 "+list);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"예약 QUERY 오류");
		}
		return list;
		
		
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
			conn=DBManager.getConnection();
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

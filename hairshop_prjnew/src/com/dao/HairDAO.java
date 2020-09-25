package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.HairVO;
import com.util.DBManager;


public class HairDAO {

   private static HairDAO instance= new HairDAO();

   public HairDAO() {

   }   
   
   public static HairDAO getInstance() {
	   
      return instance;
   }

   // 관리자 로그인
   public int wokerCheck(String userid, String userpw) {
      String sql = "select workerpw from worker where workerid = ?";
      int result = -1;
      // 디비와 연동
      Connection conn = null;
      // 쿼리문(select)을 수행하기 위한 문장 객체
      PreparedStatement pstmt = null;
      // 결과값을 저장할 ResultSet
      ResultSet rs = null;
      try {
         conn = DBManager.getConnection();
         System.out.println("1");
         pstmt = conn.prepareStatement(sql);
         System.out.println("2");
         pstmt.setString(1, userid);
         System.out.println("3");
         rs = pstmt.executeQuery();
         System.out.println("4");
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
	   String sql = "insert into rPWjd(id, pwd, name, phoneNumber, address, enroll)" +
			   		" values(?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			//////
			
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
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
	   String sql = "delete * where id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("costomer_delete err : "+e.getMessage());
		} finally {
			DBManager.close(conn, pstmt);
		}    
   }
   //예약
   public ArrayList<HairVO> costomer_appointmentlist() {
	   	String sql = "select r. id, d.rsv_date, d.rsv_time, d.rsv_status, r.name, r.phonenumber, s.rsv_date, s.p_type "
	            + "from rPWjd r, dPdir d, sangSE s "
	            + "where r.id = d.id and d.rsv_date = s.rsv_date";
	            
	      ArrayList<HairVO> list = new ArrayList<HairVO>();
	      
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
	             HairVO hvo = new HairVO();
	             hvo.setId(rs.getString("id"));
	             hvo.setRsv_date(rs.getString("rsv_date"));
	             hvo.setRsv_time(rs.getString("rsv_time"));
	             hvo.setName(rs.getString("name"));
	             hvo.setPhoneNumber(rs.getString("phonenumber"));
	             hvo.setRsv_date(rs.getString("rsv_date"));
	             hvo.setP_type(rs.getString("p_type"));
	             list.add(hvo);
	          }
	            
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         System.out.println(e.getMessage()+"예약 QUERY 오류");
	      }
	      return list;
//	      
	   }
   
   
 //예약 확정 rsv_status +1
 	public void costomer_appointment(String id) {
 		String sql ="update dpdir set rsv_status=rsv_status+1 where id=?";
 		// 디비와 연동
 		Connection conn = null;
 		// 쿼리문(select)을 수행하기 위한 문장 객체
 		PreparedStatement pstmt = null;
 		// 결과값을 저장할 ResultSet
 		ResultSet rs = null;
 		
 		try {
 			conn = DBManager.getConnection();
 			pstmt = conn.prepareStatement(sql);
 			pstmt.setString(1, id);
 			
 			int r = pstmt.executeUpdate();
 			
 			if (r > 0) {
 				System.out.println("업데이트 성공");
 			} else {
 				System.out.println("업데이트 실패");
 			}			
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			System.out.println(e.getMessage()+"확정 오류");
 		}		
 	}
 	
   //상세 보기 - 고객 기본 정보 조회
   public HairVO customer_DetailInfo(String id) {
	   String sql = "select id, name, phonenumber, address, enroll from rpwjd where id = ?";
	   HairVO hVo = null;
	   System.out.println(sql);
	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   ResultSet rs = null;
	   
	   try {
		conn = DBManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			hVo = new HairVO();
			hVo.setId(rs.getString("id"));
			hVo.setName(rs.getString("name"));
			hVo.setPhoneNumber(rs.getString("phonenumber"));
			hVo.setAddress(rs.getString("address"));
			hVo.setEnroll(rs.getString("enroll"));	
			
		}
	} catch (SQLException e) {
		System.out.println("customer_DetailInfo ERR : " + e.getMessage());
	} finally {
		DBManager.close(conn, pstmt);
	}
	return hVo; 
   } // customer_detailView() END
   
   
   //상세보기 -- 시술내역 리스트 조회
   public ArrayList<HairVO> customer_Procedure(String id) {
	   String sql = "select rsv_date, p_type from sangse where id = ? order by rsv_date desc";
	   
	   HairVO hVo = null;
	   
	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   ResultSet rs = null;
	   
	   ArrayList<HairVO> list = new ArrayList<HairVO>();
	   try {
		conn = DBManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			hVo = new HairVO();
			hVo.setSisul_date(rs.getString("rsv_date"));
			hVo.setSisul_type(rs.getString("p_type"));
			list.add(hVo);
		}
		
	} catch (SQLException e) {
		System.out.println("customer_Procedure ERR : " + e.getMessage());
	} finally {
		DBManager.close(conn, pstmt, rs);
	}
	   return list;
    } // customer_Procedure() END
   
   
   
   
    /** 상세정보 수정 **/
	public void customer_detailUpdate(HairVO hVo) {
		String sql = "update rpwjd set name = ?, phonenumber = ?, address = ? where id = ? ";	
		Connection conn = null;
		PreparedStatement pstmt = null;
		int i;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hVo.getName());
			pstmt.setString(2, hVo.getPhoneNumber());
			pstmt.setString(3, hVo.getAddress());
			pstmt.setString(4, hVo.getId());
			pstmt.executeUpdate();
			i = pstmt.executeUpdate();
			System.out.println("고객정보 수정완료 : "+ i);
		} catch (SQLException e) {
			System.out.println("customer_detailUpdate ERR : " + e.getMessage());
		} finally {
			DBManager.close(conn, pstmt);
		}
	} // customer_detailUpdate() END
   
	
   /**시술 내역 수정**/
   public void customer_ProcedureUpdate(ArrayList<HairVO> hVo) {
      String sql = "";
   } // customer_ProcedureUpdate() END
   
   
   //전체 보기
   public ArrayList<HairVO> costmoer_selectList() {//상우 완료
      String sql = "select d.rsv_seq, d.rsv_date, d.rsv_time, d.p_type, d.id, s.rsv_date, s.p_type from dPdir d, sangSE s where d.rsv_seq=s.rsv_seq where ";
      // 디비와 연동
      Connection conn = null;
      // 쿼리문(select)을 수행하기 위한 문장 객체
      PreparedStatement pstmt = null;
      // 결과값을 저장할 ResultSet
      ResultSet rs = null;
      
      conn = DBManager.getConnection();
      
      try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(parameterIndex, x);
	} catch (SQLException e) {
		System.out.println("costmoer_selectList err : "+e.getMessage());
	} finally {
		DBManager.close(conn, stmt, rs);
	}
	return id;
      
      
      
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
package com.prj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.prj.dto.hairDTO;
import com.prj.util.DBManager;

public class prjDAO {

		private prjDAO() {
		}

		private static prjDAO instance = new prjDAO();

		public static prjDAO getInstance() {
			return instance;
		}

		

		// 회원가입 아이디 비번 이름 주소 폰번호 추가  //MemberDAO
		public int customer_insert(hairDTO hDTO) {
			int result = 0;
			String sql = "insert into member(id, pwd, name, phoneNumber, address, enrollDate) values(?, ?, ?, ?, ?, ?)";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, hDTO.getId());
				pstmt.setString(2, hDTO.getPw());
				pstmt.setString(3, hDTO.getName());
				pstmt.setString(4, hDTO.getPhone());
				pstmt.setString(5, hDTO.getAddress());
				pstmt.setString(6, hDTO.getEnroll());
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println("customer_insert err : "+e.getMessage());
			} finally {
				DBManager.close(conn, pstmt);
			}
			return result;
		}
		
		
//		아이디 중복확인
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
		
		
		//삭제하기
		public void customer_delete(int id) {
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
		

//		//회원 관리 dto
//		private String id=null;
//		private String pw= null;
//		private String name= null;
//		private String phone= null;
//		private String address= null;
//		private String enroll= null;
//		
//		//예약 테이블
//		private String rsv_date= null;
//		private String rsv_time= null;
//		private String rsv_status= null;
//		private String p_type= null;
//
//		//관리자 테이블 
//		private String workerid= null;
//		private String workerpw= null;
		
		
		//예약하기
//		public customer_appointment() {
//			String sql = ""
//			
//			
//		}
	
		
		//회원정보 변경 CartDAO.java
		public void customer_update(QnaVO qnaVO) {
			String sql = "update qna set reply=?, rep='2' where qseq=?";

			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, qnaVO.getReply());
				pstmt.setInt(2, qnaVO.getQseq());
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
		
		public ArrayList<hairDTO> customer_selectList() {
			
			
			return null;
			
			
		}


		/*
		 * * 관리자 모드에서 사용되는 메소드 * *
		 */
		
		//시간 기준으로 검색??
		public ArrayList<hairDTO> customer_selectList(String member_name) {
			ArrayList<hairDTO> memberList = new ArrayList<hairDTO>();
			String sql = "select * from member where name like '%'||?||'%' " + "order by indate desc";

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				if (member_name == "") {
					pstmt.setString(1, "%");
				} else {
					pstmt.setString(1, member_name);
				}
							
				rs = pstmt.executeQuery();
				while (rs.next()) {
					hairDTO hDTO = new hairDTO();
					hDTO.setId(rs.getString("id"));
					hDTO.setPw(rs.getString("pw"));
					hDTO.setName(rs.getString("name"));
					hDTO.setPhone(rs.getString("phone"));
					hDTO.setAddress(rs.getString("address"));
					hDTO.setEnroll(rs.getString("enroll"));
					
					memberList.add(hDTO);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return memberList;
		}
		
	

		//////////////////////////////////////////////////////////
		//아이디기준으로 회원정보 찾기
		public hairDTO getMember(String id) {
			hairDTO hDTO = null;
			String sql = "select * from member where id=?";

			Connection connn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				connn = DBManager.getConnection();
				pstmt = connn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					hDTO = new hairDTO();
					hDTO.setId(rs.getString("id"));
					hDTO.setPw(rs.getString("pw"));
					hDTO.setName(rs.getString("name"));
					hDTO.setAddress(rs.getString("address"));
					hDTO.setPhone(rs.getString("phone"));
					hDTO.setEnroll(rs.getString("email"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(connn, pstmt, rs);
			}
			return hDTO;
		}

		
		
		
		
	}

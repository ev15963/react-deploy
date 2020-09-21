package com.prj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.proj.dto.QnaVO;
import com.proj.util.DBManager;

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
				pstmt.setString(2, hDTO.getPwd());
				pstmt.setString(3, hDTO.getName());
				pstmt.setString(4, hDTO.getZipNum());
				pstmt.setString(5, hDTO.getAddress());
				pstmt.setString(6, hDTO.getPhone());
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
			return result;
		}
		
		
//		아이디 중복확인
		public int customer_searchone(String userid) {
			int result = -1;
			String sql = "select * from member where id=?";

			Connection connn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				connn = DBManager.getConnection();
				pstmt = connn.prepareStatement(sql);
				pstmt.setString(1, userid);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					result = 1;
				} else {
					result = -1;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(connn, pstmt, rs);
			}
			return result;
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
					hDTO.setPwd(rs.getString("pwd"));
					hDTO.setName(rs.getString("name"));
					hDTO.setEmail(rs.getString("email"));
					hDTO.setZipNum(rs.getString("zip_num"));
					hDTO.setAddress(rs.getString("address"));
					hDTO.setPhone(rs.getString("phone"));
					hDTO.setUseyn(rs.getString("useyn"));
					hDTO.setIndate(rs.getTimestamp("indate"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(connn, pstmt, rs);
			}
			return hairDTO;
		}

		

		/*
		 * * 관리자 모드에서 사용되는 메소드 * *
		 */
		
		//시간 기준으로 검색??
		public ArrayList<MemberVO> listMember(String member_name) {
			ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
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
					MemberVO memberVO = new MemberVO();
					memberVO.setId(rs.getString("id"));
					memberVO.setPwd(rs.getString("pwd"));
					memberVO.setName(rs.getString("name"));
					memberVO.setEmail(rs.getString("email"));
					memberVO.setZipNum(rs.getString("zip_num"));
					memberVO.setAddress(rs.getString("address"));
					memberVO.setPhone(rs.getString("phone"));
					memberVO.setUseyn(rs.getString("useyn"));
					memberVO.setIndate(rs.getTimestamp("indate"));
					memberList.add(memberVO);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return memberList;
		}
		
		//삭제하기
		public void deleteCart(int cseq) {
			String sql = "delete cart where cseq=?";

			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cseq);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
		
		//회원정보 변경 CartDAO.java
		public void updateAcount(QnaVO qnaVO) {
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
	}

package com.lsw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class smproductDAO {


	String dri = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";

	DBsetting dbse = new DBsetting();
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public List<shoppingMallVO> selectAllPro() {
		//전체조회
		String sql = "select * from smproduct order by code desc";
		List<shoppingMallVO> list = new ArrayList<shoppingMallVO>();
		
		
		try {
			Class.forName(dri);
			conn = DriverManager.getConnection(url, "lsw", "1234");
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while (rs.next()) {
				shoppingMallVO smvo = new shoppingMallVO();
				smvo.setCode(rs.getInt("code"));
				smvo.setPrice(rs.getInt("price"));
				smvo.setSale(rs.getInt("sale"));
				smvo.setUse(rs.getString("use"));
				list.add(smvo);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("selectAllPro dir err : "+ e.getMessage());
		} catch (SQLException e) {
			System.out.println("selectAllPro err: "+e.getMessage());
		} finally {
			dbse.closeMethod(conn, pstmt, rs);
		}
		return list;
		
	}
	
	public void insertsmproduct(shoppingMallVO spVO) {
		String sql = "INSERT INTO smproduct VALUES (product_seq.NEXTVAL, ?, ?, ?, ?, ?)";
		//SQL> INSERT INTO smproduct VALUES
		//2  (product_seq.NEXTVAL, '스니커즈', 15000, 20000, '2013-06-15', '사용');
		try {
			Class.forName(dri);
			conn = DriverManager.getConnection(url, "lsw", "1234");
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, spVO.getProName());
			pstmt.setInt(2, spVO.getPrice());
			pstmt.setInt(3, spVO.getSale());
			pstmt.setString(4, spVO.getDate());
			pstmt.setString(5, spVO.getUse());
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			System.out.println("insert dri err : "+e.getMessage());
		} catch (SQLException e) {
			System.out.println("insert into err : "+e.getMessage());
		} finally {
			dbse.closeMethod(conn, pstmt);
		}
	}
	
	

}

package com.lsw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//singletone 패턴 : 하나 객체만 사용 조건 : 생성자는 반드시 private (객체를 public 만들어야함)
//2) 자체객체생성이 안되서 자기 자신을 반환시키는 내부메소드 소환 getInstance로 지명
//static 함수가 있어야함
public class ProductDAO {
	private ProductDAO() {

	}

	private static ProductDAO instance = null;

	public static ProductDAO getInstance() {
		instance = new ProductDAO();
		return instance;
	}

	// create : insert into, Read : select ~ from, update : update ~ set, delete :
	// delete from
	public List<ProductVO> selectAllProducts() {
		//최근 등록한 상품 먼저 출력하기
		String sql = "select * from product order by code desc";
		List<ProductVO> list = new ArrayList<ProductVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		conn = DBManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		
		while (rs.next()) {
			ProductVO pVo = new ProductVO();
			pVo.setCode(rs.getInt("code"));
			pVo.setName(rs.getString("name"));
			pVo.setPrice(rs.getInt("price"));
			pVo.setName(rs.getString("pictureUrl"));
			pVo.setName(rs.getString("description"));
			list.add(pVo);
		}//while문
		
		}catch(SQLException e){
		e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
}	//selectAllProducts()

	public void insertProduct(ProductVO pVo) {
		String sql= "insert into product values (product_seq.nextval, ?, ?, ? ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pVo.getName());
			pstmt.setInt(2, pVo.getPrice());
			pstmt.setString(3, pVo.getPictureUrl());
			pstmt.setString(4, pVo.getDescription());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("conn err"+e.getMessage());
		}
	}

	public ProductVO selectProductByCode(String code) {
		return null;
		
	}

	public void updateProduct(ProductVO pVo) {
	}

	public void deleteProduct(String code) {
			
	}
}

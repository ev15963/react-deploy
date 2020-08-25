package com.kjh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBConnectionMgr {
	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public Statement stmt = null;
	public ResultSet rs = null;
	
	private final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String ORACLE_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	
	
	public DBConnectionMgr() {
	}
	
	private static DBConnectionMgr instance = new DBConnectionMgr();
	
	public static DBConnectionMgr getInstance() {
		return instance;
	}
	
	public void connect() {
		try {
			Class.forName(ORACLE_DRIVER);
			System.out.println("=> 드라이버 로딩 성공");
			
			this.conn = DriverManager.getConnection(ORACLE_URL, "kjh", "5455");
			System.out.println("=> DB 접속 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver ERR : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("connect ERR : " + e.getMessage());
		}
	} // connect() END
	
	public List<ProductBean> getList() {
		String sql = null;
		List<ProductBean> productList = new ArrayList<ProductBean>();
	
		try {
			this.connect();
			sql = "select * from product order by code desc";
			this.pstmt = this.conn.prepareStatement(sql);
		
			this.rs = this.pstmt.executeQuery();
			while(this.rs.next()) {
				ProductBean pbean = new ProductBean();

				pbean.setCode(this.rs.getInt("code"));
				pbean.setName(this.rs.getString("name"));
				pbean.setPrice(this.rs.getInt("price"));
				pbean.setDescription(this.rs.getString("description"));
				productList.add(pbean);
			}
			
		} catch (SQLException e) {
			System.out.println("getList ERR : " + e.getMessage());
		}
		return productList;
		
	} // getList() END
	
	public ProductBean getListByCodes(int code) {
		String sql = null;
		ProductBean pBean = new ProductBean();

		try {
			this.connect();
			this.pstmt = null;
			
			sql = "select * from product where code = " + code;
			this.pstmt = this.conn.prepareStatement(sql);
			
			this.rs = this.pstmt.executeQuery();
			while(this.rs.next()) {
				pBean.setCode(code);
				pBean.setName(this.rs.getString("name"));
				pBean.setPrice(this.rs.getInt("price"));
				pBean.setDescription(this.rs.getString("description"));
			}

		} catch (SQLException e) {
			System.out.println("getUpdateItem ERR : " + e.getMessage());
		}
		return pBean;
	} // getUpdateItem() END
	
	public void insertProduct(ProductBean pBean) {
		String sql = null;

		try {
			this.connect();
			this.pstmt =null;
			
			sql = "insert into product values (product_seq.nextval, ?, ?, null, ?)";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, pBean.getName());
			this.pstmt.setInt(2, pBean.getPrice());
			this.pstmt.setString(3, pBean.getDescription());
			
			int result = this.pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("상품이 등록되었습니다.");
			}
		} catch (SQLException e) {
			System.out.println("insertProduct ERR : " + e.getMessage());
		}
	} // insertProduct() END
	
	public void updateProduct(ProductBean pBean) {
		String sql = null;
		
		try {
			this.connect();
			this.pstmt = null;
			sql = "update product set name = ?, price = ?, description = ? where code= ?";
			this.pstmt = this.conn.prepareStatement(sql);
			
			this.pstmt.setString(1, pBean.getName());
			this.pstmt.setInt(2, pBean.getPrice());
			this.pstmt.setString(3, pBean.getDescription());
			this.pstmt.setInt(4, pBean.getCode());
			
			int result = this.pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("상품이 수정되었습니다.");
			}
		} catch (SQLException e) {
			System.out.println("updateProduct ERR : " + e.getMessage());
		}
	}
	
	public void deleteProduct(int code) {
		String sql = null;
		
		try {
			this.connect();
			sql = "delete from product where code=?";
			
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, code);
			
			int result = this.pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("상품이 삭제되었습니다.");
			}
		} catch (SQLException e) {
			System.out.println("deleteProduct ERR : " + e.getMessage());
		}
	
	}
	
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
	} // close() END
	
} // DBConnectionMgr Class END

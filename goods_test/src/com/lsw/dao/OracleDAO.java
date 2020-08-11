package com.lsw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lsw.dto.GoodsDTO;

public class OracleDAO {

	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public Statement stmt = null;
	public ResultSet rs = null;
	public int r = 0;

	public OracleDAO() {
	}

	/** 각 서블릿들이 기본 호출 **/
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("==> 드라이버 로딩 성공!");

			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			this.conn = DriverManager.getConnection(url, "lsw", "1234");
			System.out.println("==> 접속성공");
		} catch (ClassNotFoundException e) {
			System.out.println("driver err => " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("connect err =>" + e.getMessage());
		}
	} // connect() END

	/** GoodsListServlet 에서 호출 **/
	public List<GoodsDTO> selectAll() {
		
		String sql = "select * from store";
		
		ArrayList<GoodsDTO> list = new ArrayList<GoodsDTO>();
			
			
//			this.pstmt.setInt(1, goods.getCode()); // 1 숫자
//			this.pstmt.setString(2, goods.getProduct());
//			this.pstmt.setString(3, goods.getContent());
//			this.pstmt.setInt(4, goods.getQuantity());
//			this.pstmt.setInt(5, goods.getDiscount());
//			this.pstmt.setInt(6, goods.getDelivery_charge());
//			this.pstmt.setInt(7, goods.getPrice());
//			this.pstmt.setString(8, goods.getName());
		
		return null;
	} // selectAll() END

	/** GoodsDetailServlet 에서 호출 **/
	public void selectOne(int code) {

	} // selectOne() END

	/** GoodsEntryServlet 에서 호출 **/
	public void insert(GoodsDTO goods) {
		String sql = "insert into store values (?, ?, ?, ?, ?, ?, ?, ?)";

		int r;
		try {

			this.pstmt = this.conn.prepareStatement(sql);

			this.pstmt.setInt(1, goods.getCode()); // 1 숫자
			this.pstmt.setString(2, goods.getProduct());
			this.pstmt.setString(3, goods.getContent());
			this.pstmt.setInt(4, goods.getQuantity());
			this.pstmt.setInt(5, goods.getDiscount());
			this.pstmt.setInt(6, goods.getDelivery_charge());
			this.pstmt.setInt(7, goods.getPrice());
			this.pstmt.setString(8, goods.getName());

			r = this.pstmt.executeUpdate();
			if (r > 0) {
				System.out.println("성공");
			}
		} catch (SQLException e) {
			System.out.println("실패" + e.getMessage());
		}

	} // insert() END

	/** GoodsUpdateServlet 에서 호출 **/
	public void update(GoodsDTO goods) {

	} // update() END

	/** GoodsDeleteServlet 에서 호출 **/
	public void delete(int code) {

	} // delete() END

	/** 각 서블릿들이 데이터베이스 작업 완료 후, 호출 **/
	public void close() {
		try {

			if (this.rs != null)
				this.rs.close();
			if (this.stmt != null)
				this.stmt.close();
			if (this.pstmt != null)
				this.pstmt.close();
			if (this.conn != null)
				this.conn.close();
			System.out.println("close 성공");
		} catch (SQLException e) {
			System.out.println("close err" + e.getMessage());
		}
	} // close() END

}

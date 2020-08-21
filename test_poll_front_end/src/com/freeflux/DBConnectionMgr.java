package com.freeflux;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/** 데이터에 접근할 수 있는 객체 (DAO) 역할 담당**/
public class DBConnectionMgr {
	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public Statement stmt = null;
	public ResultSet rs = null;

	private final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String ORACLE_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";

    public DBConnectionMgr() {
    }

    /** 기본 생성자 : 각 Servlet 에서 가장 먼저 객체 생성 시 **/
	public void connect() {
		try {
			Class.forName(ORACLE_DRIVER);
			System.out.println("==> 드라이버 로딩 성공!");

			this.conn = DriverManager.getConnection(ORACLE_URL, "freeflux", "free");
			System.out.println("==> DB접속성공!");

		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER LOAD ERR => " + e.getMessage());

		} catch (SQLException e) {
			System.out.println("CONNECT ERR => " + e.getMessage());
		}
	}
	/** =========================================================== **/
	
	/**
	 * 설문의 가장 높은 num값 :
	 * 
	 * @return
	 */
	public int getMaxNum() {
		String sql = "select max(num) from tblPollList";
		int maxNum = 0;


		return maxNum;
	}
	
	/** =========================================================== **/
	
	/**
	 * 설문 등록 처리 : 
	 * 
	 * @param plBean, piBean
	 */
	public boolean insertPoll(PollListBean plBean, PollItemBean piBean) {
		boolean flag = false;
		String sql = "insert into tblPollList (num, question, sdate, edate, wdate, type) values (seqPollList.nextval, ?, ?, ?, sysdate, ?)";


		return flag;
	}
	
	/** =========================================================== **/
	
	/**
	 * 설문 목록 조회  : 
	 * 
	 * @return
	 */
	public List<PollListBean> getAllList() {
		String sql = "select * from tblPollList order by num desc";
		List<PollListBean> pollList = new ArrayList<PollListBean>();


		return pollList;
	}
	
	/** =========================================================== **/
	
	/**
	 * 설문 리스트 조회 : 
	 * 
	 * @param num
	 * @return
	 */
	public PollListBean getList(int num) {
		String sql = null;

		PollListBean plBean = new PollListBean();


		return plBean;
	}
	
	/** =========================================================== **/
	
	/**
	 * 설문 아이템  조회 : 
	 * 
	 * @param num
	 * @return
	 */
	public List<String> getItem(int num) {
		String sql = "select item from tblPollItem where listnum = ?";

		List<String> vlist = new ArrayList<String>();


		return vlist;
	}
	
	/** =========================================================== **/
	
	
	/**
	 * 설문 아이템  투표수 증가 : 
	 * 
	 * @param num, itemnum
	 * @return
	 */
	public boolean updatePoll(int num, String[] itemnum) {
		boolean flag = false;
		String sql = "update tblPollItem set count = count+1 where listnum=? and itemnum = ?";


		return flag;
	}
	
	/** =========================================================== **/
	
	/**
	 * 설문 아이템  조회 : 
	 * 
	 * @param num, itemnum
	 * @return
	 */
	public List<PollItemBean> getView(int num) {
		String sql = "select item, count from tblPollItem where listnum=?";
		List<PollItemBean> vlist = new ArrayList<PollItemBean>();

		return vlist;
	}
	
	
	
	/**
	 * 설문 count 합계 조회 : 
	 * 
	 * @param num, itemnum
	 * @return
	 */
	public int sumCount(int num) {

		String sql = "select sum(count) from tblPollItem where listnum=?";
		int count = 0;

		return count;
	}
	
	
	
	
	
	/**
	 * 사용이 끝난 자원 해제 : 각 Servlet 에서 가장 나중에 호출 
	 * 
	 * @param boardModel
	 */
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
	}
}

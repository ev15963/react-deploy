package com.lsw.dto;

public class BoardModel {

	private int no = 0;
	private String subject = null;
	private String writer = null;
	private String contents = null;
	private int hit = 0;
	
	
	private String regdate;
	private String moddate;
	
	private String pageNum = "1";
	private String searchType="";
	
	private String searchText="";
	private int listCount = 10;
	private int pagePerBlock = 10;
	
	public String toString() {
		String str ="==>";
		str += this.no + "_";
		str += this.subject + "_";
		str += this.writer + "_";
		str += this.contents + "_";
		str += this.hit + "_";
		
		str += this.regdate + "_";
		str += this.moddate + "_";
		str += this.searchType + "_";
		str += this.searchText + "_";
		
		return str;
	}
	
	public BoardModel() {
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getModdate() {
		return moddate;
	}

	public void setModdate(String moddate) {
		this.moddate = moddate;
	}

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getPagePerBlock() {
		return pagePerBlock;
	}

	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}
	
}

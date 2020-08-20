package com.freeflux.dto;
/** DTO 역할 **/
public class BoardModel {

	/** 외부 접근 불가능 : 값추출 : get~~() return /  값설정 : set~~~(매개변수) **/
	private int no = 0;
	private String subject = null;
	private String writer = null;
	private String contents = null; 
	private int hit = 0;
	
	/** 아래의 변수들 선언 후, getter / setter 추가 **/
	private String regdate;					// 등록 일시 
	private String moddate;					// 수정 일시 
	
	private String pageNum = "1"; 		// 페이지 번호 
	private String searchType = ""; 		// 검색 항목 
	private String searchText = "";  		// 검색어 
	private int listCount = 10;   				// 목록 페이지 게시물 노출 수 
	private int pagePerBlock = 10;  		// 목록 페이지 네비게이터 블록 수 

	public BoardModel() {
	}

	/** 아 Object.class의 toString() 재정의 : Override **/
	public String toString() {
		String str = "==> ";
		str += this.no + "__";
		str += this.subject + "__";
		str += this.writer + "__";
		str += this.contents + "__";
		str += this.hit + "__";
		str += this.regdate + "__";		// 추가
		str += this.moddate + "__";		// 추가
		str += this.searchType + "__";		// 추가
		str += this.searchText + " <==";	// 추가
		return str;
	}

	/** 아래는 private 변수들에 대한 getter/setter 들  **/
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

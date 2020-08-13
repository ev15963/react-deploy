package com.lsw.dto;

public class BoardModel {
	
	/** 외부 접근 불가능 : 값추출 : get~~() return **/
	private int no =0;
	private String subject =null;
	private String writer = null;
	private String contents = null;
	private int hit = 0;
	
	
	/** 아래의 변수들 선언후, getter setter 추가 **/
	
	//DB저장
	private  String regdate;		//등록일시
	private  String moddate;		//수정일시
	
	//DB저장 안함
	private  String pageNum ="1";		//페이지번호 기본값 1설정
	private  String searchType ="";		//검색항목 전체검색 내용검색 등..
	


	private  String searchText="";		//검색어 사용자 입력 검색어 삽입
	private  int listCount = 10;	//목록 페이지 게시물 노출 수 한 페이지 나오는 수
	private  int pagePerBlock = 10;	//목록 페이지 네이게이터 블록 수 페이지번호 10단위
	
	/**  Object.class의 toStirng() 재정의 : Override **/
	public String toString() {
		String str ="==> ";
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
		// TODO Auto-generated constructor stub
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
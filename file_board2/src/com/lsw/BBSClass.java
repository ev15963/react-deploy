package com.lsw;

public class BBSClass {
	private int seqno=0;
	private String title=null;
	private String content=null;
	private String writer=null;
	
	public BBSClass() {
		
	}
	
	public BBSClass(int i1, String s2, String s3, String s4) {
		this.seqno=i1;
		this.title=s2;
		this.content=s3;
		this.writer=s4;
	}
	
	public int getSeqno() {
		return seqno;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getWriter() {
		return writer;
	}
}

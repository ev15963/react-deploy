package com.lsw.dto;

import java.sql.Timestamp;

public class BoardVO {
	private Integer num;
	private String name;
	private String email;
	private String pass;
	private String title;
	private String content;
	private Integer readcount;
	private Timestamp writedate;
	
	public BoardVO() {
		
	}
	@Override
	public String toString() {
		String str = "==>";
		str += (this.num+"__");
		str += (this.name+"__");
		str += (this.email+"__");
		str += (this.pass+"__");
		str += (this.title+"__");
		str += (this.content+"__");
		str += (this.readcount+"__");
		str += (this.writedate+"__");
		
		return str;
	}
	
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getReadcount() {
		return readcount;
	}

	public void setReadcount(Integer readcount) {
		this.readcount = readcount;
	}

	public Timestamp getWritedate() {
		return writedate;
	}

	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}
	
	
}

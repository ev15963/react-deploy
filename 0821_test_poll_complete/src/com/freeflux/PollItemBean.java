package com.freeflux;

import java.util.Arrays;

public class PollItemBean {

	private int listnum; // 설문 번호    num 중 가장 큰 값
	private int itemnum; // 아이템 번호     item의 index
	private String [] item; // 아이템 내용  O
	private int count; // 투표수    0
	
	public PollItemBean() {
	}

	public String toString() {
		String str="";
		str+=this.listnum+"<=설문 번호__";
		str+=this.itemnum+"<=아이템 번호__";
		str+=Arrays.toString(this.item)+"<=아이템 내용__";
		str+=this.count+"<=투표수__";

		return str;
	}
	
	public int getListnum() {
		return listnum;
	}
	public void setListnum(int listnum) {
		this.listnum = listnum;
	}
	public int getItemnum() {
		return itemnum;
	}
	public void setItemnum(int itemnum) {
		this.itemnum = itemnum;
	}
	public String[] getItem() {
		return item;
	}
	public void setItem(String[] item) {
		this.item = item;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
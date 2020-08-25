package com.lsw;

public class ProductBean {
	private int prNum=0;
	private String name ="";
	private int price =0;
	private String pic = "";
	private String descr="";
	
	
	public int getPrNum() {
		return prNum;
	}
	public void setPrNum(int prNum) {
		this.prNum = prNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	public ProductBean() {
		
	}
}

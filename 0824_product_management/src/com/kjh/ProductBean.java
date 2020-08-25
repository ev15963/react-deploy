package com.kjh;

public class ProductBean {
	private int code=0;					// 상품번호
	private String name="";			// 상품명
	private int price=0;				// 가격
	private String pictureurl="";		// 사진URL
	private String description="";	// 상품설명
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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

	public String getPictureurl() {
		return pictureurl;
	}

	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductBean() {
	}

}

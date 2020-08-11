package com.lsw.dto;

public class GoodsDTO {

	private int code = 0;
	private String product = null;
	private String content = null;
	private int quantity = 0;
	private int discount = 0;
	private int delivery_charge = 0;
	private int price = 0;
	private String name = null;


	public GoodsDTO() {
	}
	
	public void setCode(int code) {
		this.code = code;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public void setDelivery_charge(int delivery_charge) {
		this.delivery_charge = delivery_charge;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

}

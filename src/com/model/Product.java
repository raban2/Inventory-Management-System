package com.model;

public class Product {

	private int productId;
	private String ProductName;
	private int Quantity_available;
	private int mrp;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public int getQuantity_available() {
		return Quantity_available;
	}

	public void setQuantity_available(int quantity_available) {
		Quantity_available = quantity_available;
	}

	public int getMrp() {
		return mrp;
	}

	public void setMrp(int mrp) {
		this.mrp = mrp;
	}

}

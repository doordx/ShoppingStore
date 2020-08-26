package com.ss.model;

public class Product {

	private Category category;
	private String name;
	private int price;

	public Product(String name, String categoryCode, int price) {
		this.name = name;
		this.price = price;
		setCategoryCode(categoryCode);
	}

	public int getprice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public String getCategoryCode() {
		return category.getCategoryCode();
	}
	
	public void setCategoryCode(String categoryCode) {
		switch(categoryCode) {
			case ProductConstant.CATEGORY_A:
				category = new CategoryA();
				break;
			case ProductConstant.CATEGORY_B:
				category = new CategoryB();
				break;
			case ProductConstant.CATEGORY_C:
				category = new CategoryC();
				break;
			default:
				throw new IllegalArgumentException("Incorrect Category Code");
		}
	}
	
	public double getSalesTax(int price) {
		return category.getSalesTax(price);
	}
}

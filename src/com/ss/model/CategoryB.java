package com.ss.model;

public class CategoryB extends Category {

	@Override
	String getCategoryCode() {
		return ProductConstant.CATEGORY_B;
	}
	
	@Override
	public double getSalesTax(int price) {
		return price * 20 / 100;
	}
}

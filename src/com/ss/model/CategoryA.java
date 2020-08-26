package com.ss.model;

public class CategoryA extends Category {

	@Override
	String getCategoryCode() {
		return ProductConstant.CATEGORY_A;
	}
	
	@Override
	public double getSalesTax(int price) {
		return price * 10 / 100;
	}
}

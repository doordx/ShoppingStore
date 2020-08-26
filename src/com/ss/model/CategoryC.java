package com.ss.model;

public class CategoryC extends Category {

	@Override
	String getCategoryCode() {
		return ProductConstant.CATEGORY_C;
	}
	
	@Override
	public double getSalesTax(int price) {
		return 0;
	}
}

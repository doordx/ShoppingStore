package com.ss.model;

public abstract class Category {

	abstract String getCategoryCode();
	
	abstract double getSalesTax(int price);	
}

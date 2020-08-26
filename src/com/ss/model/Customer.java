package com.ss.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String name;
	private List<Product> items;

	public Customer(String name) {
		this.name = name;
		this.items = new ArrayList<>();
	}

	public void addItem(Product item) {
		items.add(item);
	}

	public String getName() {
		return name;
	}
	
	public List<Product> getItems() {
		return items;
	}
	
	public String statement() {
		String result = "Purchase record for: " + getName() + "\n" + "\t" + "Product Name" + "\t" + "Sales Tax" + "\t"
				+ "Price" + "\n";
		;
		for (Product item : items) {
			result += "\t" + item.getName() + "\t\t" + String.valueOf(item.getSalesTax(item.getprice())) + "\t\t"
					+ item.getprice() + "\n";
		}
		result += "Total sales Tax owed is " + String.valueOf(totalSalesTax());
		result += "\nTotal amount owed is " + String.valueOf(totalAmount());
		return result;
	}
	
	public double totalSalesTax() {
		double result = 0;
		for(Product item : items) {
			result += item.getSalesTax(item.getprice());
		}
		return result;
	}
	
	public double totalAmount() {
		double result = 0;
		for(Product item : items) {
			result += item.getprice();
		}
		return result + totalSalesTax();
	}
}

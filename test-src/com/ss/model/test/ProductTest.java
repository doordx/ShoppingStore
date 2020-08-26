package com.ss.model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.ss.model.Product;

public class ProductTest {

	private Product product;
		
	@Test
	public void testGetName() {
		product = createProduct("Item-1", "A", 100);
		assertEquals(product.getName(), "Item-1");
	}
	
	@Test
	public void testGetPrice() {
		product = createProduct("Item-1", "A", 100);
		assertEquals(product.getprice(), 100);
	}
	
	@Test
	public void testGetCategoryCode() {
		product = createProduct("Item-1", "A", 100);
		assertNotNull(product.getCategoryCode());
	}
	
	@Test
	public void testGetSalesTax() {
		product = createProduct("Item-1", "A", 100);
		assertEquals(10.0, product.getSalesTax(product.getprice()), 0.0);
		product = createProduct("Item-2", "B", 200);
		assertEquals(40.0, product.getSalesTax(product.getprice()), 0.0);
		product = createProduct("Item-3", "C", 500);
		assertEquals(0.0, product.getSalesTax(product.getprice()), 0.0);
	}

	private Product createProduct(String name, String categoryCode, int price) {
		return new Product(name, categoryCode, price);
	}
}

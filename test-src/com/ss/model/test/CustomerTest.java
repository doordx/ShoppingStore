package com.ss.model.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ss.model.Customer;
import com.ss.model.Product;

public class CustomerTest {

	private Customer customer;
	
	@Test
	public void testAddItem() {
		customer = createCustomer("Customer-1");
		assertTrue(customer.getItems().isEmpty());
		Product product = createProduct("Item-1", "A", 100);
		customer.addItem(product);
		assertEquals(1, customer.getItems().size());
	}
	
	@Test
	public void testGetName() {
		customer = createCustomer("Customer-1");
		assertEquals(customer.getName(), "Customer-1");
	}
	
	@Test
	public void testGenerateStatement() {
		generateStatement();
		assertEquals(190.0, customer.totalSalesTax(), 0.0);
		assertEquals(1690.0, customer.totalAmount(), 0.0);
	}
	
	private void generateStatement() {
		customer = createCustomer("Customer-1");
		addItemsToCart(customer);
		System.out.println(customer.statement());		
	}
	
	private Customer createCustomer(String name) {
		return new Customer(name);
	}
	
	private Product createProduct(String name, String categoryCode, int price) {
		return new Product(name, categoryCode, price);
	}
	
	private void addItemsToCart(Customer customer) {
		Product product1 = createProduct("Item-1", "A", 100);
		Product product2 = createProduct("Item-2", "B", 200);
		Product product3 = createProduct("Item-3", "C", 300);
		Product product4 = createProduct("Item-4", "A", 400);
		Product product5 = createProduct("Item-5", "B", 500);
		customer.addItem(product1);
		customer.addItem(product2);
		customer.addItem(product3);
		customer.addItem(product4);
		customer.addItem(product5);
	}
}

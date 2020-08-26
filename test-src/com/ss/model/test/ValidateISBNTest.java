package com.ss.model.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.Before;
import org.junit.Test;

import com.ss.model.ValidateISBN;

public class ValidateISBNTest {

	private static ValidateISBN clazzUnderTest;
	
	@Before
	public void setUp() {
		clazzUnderTest = new ValidateISBN();
	}
	
	@Test
	public void test10DigitIsbn() {
		assertTrue(clazzUnderTest.validate("0134757599"));
		assertTrue(clazzUnderTest.validate("9352135245"));
	}
	
	@Test
	public void test13DigitIsbn() {
		assertTrue(clazzUnderTest.validate("9780134757599"));
	}
	
	
	@Test
	public void test10DigitInValidIsbn() {
		assertFalse(clazzUnderTest.validate("0134757598"));
	}
	
	@Test
	public void test13DigitInvalidIsbn() {
		assertFalse(clazzUnderTest.validate("9780144757599"));
	}
	
	@Test(expected=NumberFormatException.class)
	public void testIsbnLength() {
		clazzUnderTest.validate("013475759");
	}
	
	@Test(expected=InvalidParameterException.class)
	public void testNullIsbn() {
		clazzUnderTest.validate(null);
	}
	
	@Test(expected=NumberFormatException.class)
	public void testIsbnNotAllNumericCharacter() {
		clazzUnderTest.validate("013a75c599");
	}
	
	@Test
	public void testValidIsbnLastDigitX() {
		clazzUnderTest.validate("013475759X");
	}
}

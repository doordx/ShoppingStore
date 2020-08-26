package com.ss.model;

import java.security.InvalidParameterException;

public class ValidateISBN {

	private static final int LONG_ISBN_MULTIPLIER = 10;
	private static final int SHORT_ISBN_MULTIPLIER = 11;
	private static final int LONG_ISBN_LENGTH = 13;
	private static final int SHORT_ISBN_LENGTH = 10;

	public boolean validate(final String isbn) {
		if(isbn == null)
			throw new InvalidParameterException("Isbn no cannot be null");
		
		int length = isbn.length();
		if(length == LONG_ISBN_LENGTH) {
			return isValidLongISBN(isbn, length);
		} else if(length == SHORT_ISBN_LENGTH) {
			return isValidShortISBN(isbn, length);
		}
		throw new NumberFormatException("Isbn no length should be either 10 or 13");
	}

	private boolean isValidShortISBN(final String isbn, final int length) {
		int total = 0;
		for(int i = 0; i < length; i++) {
			if(!Character.isDigit(isbn.charAt(i))) {
				if(i == 9 && isbn.charAt(i) == 'X')
					total += 10;
				else
					throw new NumberFormatException("Not a valid number: " + isbn.charAt(i));
			}
			total += getNumericValue(isbn.charAt(i)) * (SHORT_ISBN_LENGTH - i);
		}
		return total % SHORT_ISBN_MULTIPLIER == 0;
	}

	private boolean isValidLongISBN(final String isbn, final int length) {
		int total = 0;
		for(int i = 0; i < length; i++) {
			if(!Character.isDigit(isbn.charAt(i))) {
				throw new NumberFormatException("Not a valid number: " + isbn.charAt(i));
			}
			if(i % 2 == 0) {
				total += getNumericValue(isbn.charAt(i));
			} else {
				total += getNumericValue(isbn.charAt(i)) * 3;
			}
			
		}
		return total % LONG_ISBN_MULTIPLIER == 0;
	}
	
	private int getNumericValue(final char ch) {
		return Character.getNumericValue(ch);
	}

}

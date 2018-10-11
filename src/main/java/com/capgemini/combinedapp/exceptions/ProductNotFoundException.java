package com.capgemini.combinedapp.exceptions;

public class ProductNotFoundException extends Exception {
	
	public ProductNotFoundException() {		
	}
	
	public ProductNotFoundException(String message) {
		super(message);
	}
}
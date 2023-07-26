package com.dc.shoppingcart.exception;

public class ApplicationException extends Exception {

	private static final long serialVersionUID = 1229560037832609451L;

	public ApplicationException(String message, Exception e) {
		super(message, e);
	}

	public ApplicationException(String message) {
		super(message, null);
	}
}

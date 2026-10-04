package com.sj.week4.bankaccount;

public class InsufficentFundsException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InsufficentFundsException(String message) {
		super(message);
	}
}

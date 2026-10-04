package com.sj.week4.bankaccount;

public class BankAccount {
	
	private String accountNumber;
	private double balance;
	private String name;
	
	//constructor
	public BankAccount(String accountNumber, double balance, String name) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.name = name;
	}
	
	//Deposit money
	public void deposit(double amount) {
		if (amount <=0) {
			throw new IllegalArgumentException("Deposit must be greater than 0");
		}
		balance += amount;
	}
	//withdraw money
	public void withdraw(double amount) throws InsufficentFundsException{
		if (balance < 0) {
			throw new IllegalArgumentException("Withdrawl must be greater than 0");
		}
		if (amount > balance) {
			throw new InsufficentFundsException("Cannot withdraw $" + amount + " balance is " + balance);
		}
		
		balance -= amount;
	
	}
	//Getters
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	//override default toString
	@Override
	public String toString() {
		return String.format("Current Balance of %s: $%.2f", name, balance);
	}

}

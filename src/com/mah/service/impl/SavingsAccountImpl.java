package com.mah.service.impl;

import com.mah.service.Account;

public class SavingsAccountImpl implements Account {

	private int savingsAccountNumber;
	private String savingsAccountCustomerName;
	private double savingsAccountBalance;

	public SavingsAccountImpl() {
	}

	public SavingsAccountImpl(int savingsAccountNumber, String savingsAccountCustomerName,
			double savingsAccountBalance) {
		this.savingsAccountNumber = savingsAccountNumber;
		this.savingsAccountCustomerName = savingsAccountCustomerName;
		this.savingsAccountBalance = savingsAccountBalance;
	}

	public int getSavingsAccountNumber() {
		return savingsAccountNumber;
	}

	public void setSavingsAccountNumber(int savingsAccountNumber) {
		this.savingsAccountNumber = savingsAccountNumber;
	}

	public String getSavingsAccountCustomerName() {
		return savingsAccountCustomerName;
	}

	public void setSavingsAccountCustomerName(String savingsAccountCustomerName) {
		this.savingsAccountCustomerName = savingsAccountCustomerName;
	}

	public double getSavingsAccountBalance() {
		return savingsAccountBalance;
	}

	public void setSavingsAccountBalance(double savingsAccountBalance) {
		this.savingsAccountBalance = savingsAccountBalance;
	}

	@Override
	public void getAccountDetails() {
		System.out.println("SAVINGS ACCOUNT DETAILS");
		System.out.println("****************************");
		System.out.println("ACCOUNT NUMBER: " + savingsAccountNumber);
		System.out.println("CUSTOMER NAME: " + savingsAccountCustomerName);
		System.out.println("ACCOUNT BALANCE: " + savingsAccountBalance);
		System.out.println("****************************");
	}

}

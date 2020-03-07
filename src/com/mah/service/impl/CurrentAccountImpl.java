package com.mah.service.impl;

import com.mah.service.Account;

public class CurrentAccountImpl implements Account {

	private int currentAccountNumber;
	private String currentAccountCustomerName;
	private double currentAccountBalance;

	public CurrentAccountImpl() {
	}

	public CurrentAccountImpl(int currentAccountNumber, String currentAccountCustomerName,
			double currentAccountBalance) {
		this.currentAccountNumber = currentAccountNumber;
		this.currentAccountCustomerName = currentAccountCustomerName;
		this.currentAccountBalance = currentAccountBalance;
	}

	public int getCurrentAccountNumber() {
		return currentAccountNumber;
	}

	public void setCurrentAccountNumber(int currentAccountNumber) {
		this.currentAccountNumber = currentAccountNumber;
	}

	public String getCurrentAccountCustomerName() {
		return currentAccountCustomerName;
	}

	public void setCurrentAccountCustomerName(String currentAccountCustomerName) {
		this.currentAccountCustomerName = currentAccountCustomerName;
	}

	public double getCurrentAccountBalance() {
		return currentAccountBalance;
	}

	public void setCurrentAccountBalance(double currentAccountBalance) {
		this.currentAccountBalance = currentAccountBalance;
	}

	@Override
	public void getAccountDetails() {
		System.out.println("CURRENT ACCOUNT DETAILS");
		System.out.println("****************************");
		System.out.println("ACCOUNT NUMBER: " + currentAccountNumber);
		System.out.println("CUSTOMER NAME: " + currentAccountCustomerName);
		System.out.println("ACCOUNT BALANCE: " + currentAccountBalance);
		System.out.println("****************************");
	}

}

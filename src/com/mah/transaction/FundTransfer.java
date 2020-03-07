package com.mah.transaction;

import com.mah.service.impl.CurrentAccountImpl;
import com.mah.service.impl.SavingsAccountImpl;

public class FundTransfer extends Thread {

	private Object senderAccount;
	private Object receiverAccount;
	private double fundTransferAmount;

	public FundTransfer() {
	}

	public FundTransfer(Object senderAccount, Object receiverAccount, double fundTransferAmount) {
		this.senderAccount = senderAccount;
		this.receiverAccount = receiverAccount;
		this.fundTransferAmount = fundTransferAmount;
	}

	/*******************************************************************************************************************************************************************************/

	public synchronized void doTransfer(SavingsAccountImpl senderSavingsAccount,
			SavingsAccountImpl receiverSavingsAccount) {
		senderSavingsAccount
				.setSavingsAccountBalance(senderSavingsAccount.getSavingsAccountBalance() - this.fundTransferAmount);

		receiverSavingsAccount
				.setSavingsAccountBalance(receiverSavingsAccount.getSavingsAccountBalance() + this.fundTransferAmount);
	}

	public void showTransferDetails(SavingsAccountImpl senderSavingsAccount,
			SavingsAccountImpl receiverSavingsAccount) {
		System.out.println("Sender's Savings Account: ");
		senderSavingsAccount.getAccountDetails();

		System.out.println("****************************");

		System.out.println("Receiver's Savings Account: ");
		receiverSavingsAccount.getAccountDetails();
	}

	/*******************************************************************************************************************************************************************************/

	public synchronized void doTransfer(SavingsAccountImpl senderSavingsAccount,
			CurrentAccountImpl receiverCurrentAccount) {
		senderSavingsAccount
				.setSavingsAccountBalance(senderSavingsAccount.getSavingsAccountBalance() - this.fundTransferAmount);

		receiverCurrentAccount
				.setCurrentAccountBalance(receiverCurrentAccount.getCurrentAccountBalance() + this.fundTransferAmount);
	}

	public void showTransferDetails(SavingsAccountImpl senderSavingsAccount,
			CurrentAccountImpl receiverCurrentAccount) {
		System.out.println("Sender's Savings Account: ");
		senderSavingsAccount.getAccountDetails();

		System.out.println("****************************");

		System.out.println("Receiver's Current Account: ");
		receiverCurrentAccount.getAccountDetails();
	}

	/*******************************************************************************************************************************************************************************/

	public synchronized void doTransfer(CurrentAccountImpl senderCurrentAccount,
			SavingsAccountImpl receiverSavingsAccount) {
		senderCurrentAccount
				.setCurrentAccountBalance(senderCurrentAccount.getCurrentAccountBalance() - this.fundTransferAmount);

		receiverSavingsAccount
				.setSavingsAccountBalance(receiverSavingsAccount.getSavingsAccountBalance() + this.fundTransferAmount);
	}

	public void showTransferDetails(CurrentAccountImpl senderCurrentAccount,
			SavingsAccountImpl receiverSavingsAccount) {
		System.out.println("Sender's Current Account: ");
		senderCurrentAccount.getAccountDetails();

		System.out.println("****************************");

		System.out.println("Receiver's Savings Account: ");
		receiverSavingsAccount.getAccountDetails();
	}

	/*******************************************************************************************************************************************************************************/

	public synchronized void doTransfer(CurrentAccountImpl senderCurrentAccount,
			CurrentAccountImpl receiverCurrentAccount) {
		senderCurrentAccount
				.setCurrentAccountBalance(senderCurrentAccount.getCurrentAccountBalance() - this.fundTransferAmount);

		receiverCurrentAccount
				.setCurrentAccountBalance(receiverCurrentAccount.getCurrentAccountBalance() + this.fundTransferAmount);
	}

	public void showTransferDetails(CurrentAccountImpl senderCurrentAccount,
			CurrentAccountImpl receiverCurrentAccount) {
		System.out.println("Sender's Current Account: ");
		senderCurrentAccount.getAccountDetails();

		System.out.println("****************************");

		System.out.println("Receiver's Current Account: ");
		receiverCurrentAccount.getAccountDetails();
	}

	/*******************************************************************************************************************************************************************************/

	@Override
	public void run() {
		// Sender's Account <=> Receiver's Account
		// SavingsAccountImpl <=> SavingsAccountImpl
		// SavingsAccountImpl <=> CurrentAccountImpl
		// CurrentAccountImpl <=> SavingsAccountImpl
		// CurrentAccountImpl <=> CurrentAccountImpl
		if (senderAccount instanceof SavingsAccountImpl && receiverAccount instanceof SavingsAccountImpl) {
			SavingsAccountImpl senderSavingsAccount = (SavingsAccountImpl) senderAccount;
			SavingsAccountImpl receiverSavingsAccount = (SavingsAccountImpl) receiverAccount;
			// Transaction Begins
			doTransfer(senderSavingsAccount, receiverSavingsAccount);
			// Transaction Ends
			showTransferDetails(senderSavingsAccount, receiverSavingsAccount);
		} else if (senderAccount instanceof SavingsAccountImpl && receiverAccount instanceof CurrentAccountImpl) {
			SavingsAccountImpl senderSavingsAccount = (SavingsAccountImpl) senderAccount;
			CurrentAccountImpl receiverCurrentAccount = (CurrentAccountImpl) receiverAccount;
			// Transaction Begins
			doTransfer(senderSavingsAccount, receiverCurrentAccount);
			// Transaction Ends
			showTransferDetails(senderSavingsAccount, receiverCurrentAccount);
		} else if (senderAccount instanceof CurrentAccountImpl && receiverAccount instanceof SavingsAccountImpl) {
			CurrentAccountImpl senderCurrentAccount = (CurrentAccountImpl) senderAccount;
			SavingsAccountImpl receiverSavingsAccount = (SavingsAccountImpl) receiverAccount;
			// Transaction Begins
			doTransfer(senderCurrentAccount, receiverSavingsAccount);
			// Transaction Ends
			showTransferDetails(senderCurrentAccount, receiverSavingsAccount);
		} else if (senderAccount instanceof CurrentAccountImpl && receiverAccount instanceof CurrentAccountImpl) {
			CurrentAccountImpl senderCurrentAccount = (CurrentAccountImpl) senderAccount;
			CurrentAccountImpl receiverCurrentAccount = (CurrentAccountImpl) receiverAccount;
			// Transaction Begins
			doTransfer(senderCurrentAccount, receiverCurrentAccount);
			// Transaction Ends
			showTransferDetails(senderCurrentAccount, receiverCurrentAccount);
		}
	}

}

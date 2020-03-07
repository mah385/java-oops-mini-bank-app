package com.mah.transaction;

import com.mah.service.impl.CurrentAccountImpl;
import com.mah.service.impl.SavingsAccountImpl;

public class WithdrawMoney extends Thread {

	private Object account;
	private double withdrawlAmount;

	public WithdrawMoney() {
	}

	public WithdrawMoney(Object account, double withdrawlAmount) {
		this.account = account;
		this.withdrawlAmount = withdrawlAmount;
	}

	public void doWithdrawl(SavingsAccountImpl savingsAccount) {
		savingsAccount.setSavingsAccountBalance(savingsAccount.getSavingsAccountBalance() - this.withdrawlAmount);
	}

	public void doWithdrawl(CurrentAccountImpl currentAccount) {
		currentAccount.setCurrentAccountBalance(currentAccount.getCurrentAccountBalance() - this.withdrawlAmount);
	}

	@Override
	public void run() {
		if (account instanceof SavingsAccountImpl) {
			SavingsAccountImpl savingsAccount = (SavingsAccountImpl) account;
			doWithdrawl(savingsAccount);
			savingsAccount.getAccountDetails();
		} else if (account instanceof CurrentAccountImpl) {
			CurrentAccountImpl currentAccount = (CurrentAccountImpl) account;
			doWithdrawl(currentAccount);
			currentAccount.getAccountDetails();
		}
	}

}

package com.mah.transaction;

import com.mah.service.impl.CurrentAccountImpl;
import com.mah.service.impl.SavingsAccountImpl;

public class DepositMoney extends Thread {

	private Object account;
	private double depositAmount;

	public DepositMoney() {
	}

	public DepositMoney(Object account, double depositAmount) {
		this.account = account;
		this.depositAmount = depositAmount;
	}

	public void doDeposit(SavingsAccountImpl savingsAccount) {
		savingsAccount.setSavingsAccountBalance(savingsAccount.getSavingsAccountBalance() + this.depositAmount);
	}

	public void doDeposit(CurrentAccountImpl currentAccount) {
		currentAccount.setCurrentAccountBalance(currentAccount.getCurrentAccountBalance() + this.depositAmount);
	}

	@Override
	public void run() {
		if (account instanceof SavingsAccountImpl) {
			SavingsAccountImpl savingsAccount = (SavingsAccountImpl) account;
			doDeposit(savingsAccount);
			savingsAccount.getAccountDetails();
		} else if (account instanceof CurrentAccountImpl) {
			CurrentAccountImpl currentAccount = (CurrentAccountImpl) account;
			doDeposit(currentAccount);
			currentAccount.getAccountDetails();
		}
	}

}

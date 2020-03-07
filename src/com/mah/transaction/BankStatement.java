package com.mah.transaction;

import com.mah.service.impl.CurrentAccountImpl;
import com.mah.service.impl.SavingsAccountImpl;

public class BankStatement extends Thread {

	private Object account;

	public BankStatement() {
	}

	public BankStatement(Object account) {
		this.account = account;
	}

	@Override
	public void run() {
		if (account instanceof SavingsAccountImpl) {
			SavingsAccountImpl savingsAccount = (SavingsAccountImpl) account;
			savingsAccount.getAccountDetails();
		} else if (account instanceof CurrentAccountImpl) {
			CurrentAccountImpl currentAccount = (CurrentAccountImpl) account;
			currentAccount.getAccountDetails();
		}
	}

}

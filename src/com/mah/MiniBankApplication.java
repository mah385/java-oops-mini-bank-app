package com.mah;

import java.util.HashMap;
import java.util.Scanner;

import com.mah.service.Account;
import com.mah.service.impl.CurrentAccountImpl;
import com.mah.service.impl.SavingsAccountImpl;
import com.mah.transaction.BankStatement;
import com.mah.transaction.DepositMoney;
import com.mah.transaction.FundTransfer;
import com.mah.transaction.WithdrawMoney;

public class MiniBankApplication {
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		HashMap<Integer, Account> accountHolders = new HashMap<Integer, Account>();
		while (true) {
			System.out.println("    WELCOME TO DENA BANK");
			System.out.println("****************************");
			System.out.println("1:CREATE ACCOUNT");
			System.out.println("2:DEPOSIT AMOUNT");
			System.out.println("3:WITHDRAW AMOUNT");
			System.out.println("4:FUND TRANSFER");
			System.out.println("5:PRINT ACCOUNT DETAILS");
			System.out.println("6:EXIT APPLICATION");
			System.out.println("****************************");
			System.out.print("ENTER YOUR CHOICE: ");
			int key = scanner.nextInt();
			switch (key) {
			case 1:
				System.out.println("CREATE ACCOUNT PAGE");

				System.out.print("ENTER ACCOUNT NUMBER: ");
				int accountNumber = scanner.nextInt();

				System.out.print("ENTER ACCUONT HOLDER'S NAME: ");
				String customerName = scanner.next();

				System.out.print("ENTER OPENING BALANCE: ");
				double openingBalance = scanner.nextDouble();

				System.out.println("ENTER ACCOUNT TYPE");
				System.out.println("a: FOR SAVINGS ACCOUNT  :::  b: FOR CURRENT ACCOUNT");
				char typeOfAccount = scanner.next().charAt(0);

				if (typeOfAccount == 'a' || typeOfAccount == 'A') {
					SavingsAccountImpl newSavingsAccount = new SavingsAccountImpl(accountNumber, customerName,
							openingBalance);
					accountHolders.put(accountNumber, newSavingsAccount);
				} else if (typeOfAccount == 'b' || typeOfAccount == 'B') {
					CurrentAccountImpl newCurrentAccount = new CurrentAccountImpl(accountNumber, customerName,
							openingBalance);
					accountHolders.put(accountNumber, newCurrentAccount);
				}

				break;

			case 2:
				System.out.println("DEPOSIT AMOUNT PAGE");

				System.out.print("ENTER ACCOUNT NUMBER: ");
				int depositAccountNumber = scanner.nextInt();

				Object existingAccountUsedForDepositing = accountHolders.get(depositAccountNumber);

				if (existingAccountUsedForDepositing == null) {
					System.out.println("INVALID ACCOUNT NUMBER");
				} else {
					System.out.print("ENTER DEPOSIT AMOUNT: ");
					double depositAmount = scanner.nextDouble();
					DepositMoney depositMoney = new DepositMoney(existingAccountUsedForDepositing, depositAmount);
					depositMoney.start();
				}

				break;

			case 3:
				System.out.println("WITHDRAW AMOUNT PAGE");

				System.out.print("ENTER ACCOUNT NUMBER: ");
				int withdrawlAccountNumber = scanner.nextInt();

				Object existingAccountUsedForWithdrawl = accountHolders.get(withdrawlAccountNumber);

				if (existingAccountUsedForWithdrawl == null) {
					System.out.println("INVALID ACCOUNT NUMBER");
				} else {
					System.out.print("ENTER WITHDRAWL AMOUNT: ");
					double withdrawlAmount = scanner.nextDouble();

					WithdrawMoney withdrawlMoney = new WithdrawMoney(existingAccountUsedForWithdrawl, withdrawlAmount);
					withdrawlMoney.start();
				}

				break;

			case 4:
				System.out.println("FUND TRANSFER PAGE");

				System.out.print("ENTER SENDER'S ACCOUNT NUMBER: ");
				int sendersAccountNumber = scanner.nextInt();

				Object existingSendersAccountUsedForFundTransfer = accountHolders.get(sendersAccountNumber);

				System.out.print("ENTER RECEIVER'S ACCOUNT NUMBER: ");
				int receiversAccountNumber = scanner.nextInt();

				Object existingReceiversAccountUsedForFundTransfer = accountHolders.get(receiversAccountNumber);

				if (existingSendersAccountUsedForFundTransfer == null
						|| existingReceiversAccountUsedForFundTransfer == null) {
					System.out.println("INVALID ACCOUNT NUMBER");
				} else {
					System.out.print("ENTER THE AMOUNT TO BE TRANSFERED: ");
					double transferAmount = scanner.nextDouble();

					FundTransfer fundTransfer = new FundTransfer(existingSendersAccountUsedForFundTransfer,
							existingReceiversAccountUsedForFundTransfer, transferAmount);
					fundTransfer.start();
				}

				break;

			case 5:
				System.out.println("ACCOUNT DETAILS PAGE");

				System.out.print("ENTER ACCOUNT NUMBER: ");
				int searchForAccountNumber = scanner.nextInt();

				Object foundExistingAccount = accountHolders.get(searchForAccountNumber);

				if (foundExistingAccount == null) {
					System.out.println("INVALID ACCOUNT NUMBER");
				} else {
					BankStatement bankStatement = new BankStatement(foundExistingAccount);
					bankStatement.start();
				}

				break;

			case 6:
				System.exit(0);

			default:
				System.out.println("INVALID INPUT ENTERED");
			}

		}
	}

}

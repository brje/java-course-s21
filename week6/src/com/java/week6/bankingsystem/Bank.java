package com.java.week6.bankingsystem;


import java.util.ArrayList;

public class Bank {
	ArrayList<Account> Accounts = new ArrayList<>();
	public Bank(){
	}
	public void addAccount(String accountNumber, int deposit){
		DebitAccount newAccount = new DebitAccount(accountNumber, deposit);
		Accounts.add(newAccount);
		System.out.println("Account created.");
	}
	public void addCreditAccount(String accountNumber, int deposit, int limit){
		CreditAccount newAccount = new CreditAccount(accountNumber, deposit, limit);
		Accounts.add(newAccount);
		System.out.println("Account created.");
	}
	public void depositMoney(String accountNumber, int deposit){
		for (Account acc : Accounts){
			if (acc.getAccountNumber().equals(accountNumber)){
				deposit += acc.getBalance();
				acc.setBalance(deposit);
			}
		}
	}
	public void withdrawMoney(String accountNumber, int withdraw){
		int newBalance;
		for (Account acc : Accounts) {
			if (acc.getAccountNumber().equals(accountNumber)) {
				newBalance = acc.getBalance() - withdraw;
				acc.setBalance(newBalance);
			}
		}
	}
	public void removeAccount(String accountNumber){
		int id = 0;
		for (Account acc : Accounts) {
			if (acc.getAccountNumber().equals(accountNumber)) {
				Accounts.remove(id);
				break;
			}
			id += 1;
		}
		System.out.println("Account removed.");
	}
	public void accountInfo(String accountNumber){
		for (Account acc : Accounts) {
			if (acc.getAccountNumber().equals(accountNumber) & acc instanceof DebitAccount) {
				System.out.println("Account number: "+acc.getAccountNumber()+" Amount of money: " +acc.getBalance());
			}
			if (acc.getAccountNumber().equals(accountNumber) & acc instanceof CreditAccount) {
				System.out.println("Account number: "+acc.getAccountNumber()+" Amount of money: " +acc.getBalance()+" Credit limit: "+((CreditAccount)acc).limit);
			}
		}
	}
	public void allAccounts(){
		System.out.println("All accounts:");
		for (Account acc : Accounts) {
			if (acc instanceof DebitAccount){
				System.out.println("Account number: "+acc.getAccountNumber()+" Amount of money: " +acc.getBalance());
			}
			if (acc instanceof CreditAccount){
				System.out.println("Account number: "+acc.getAccountNumber()+" Amount of money: " +acc.getBalance()+" Credit limit: "+((CreditAccount)acc).limit);
			}
		}
	}
}

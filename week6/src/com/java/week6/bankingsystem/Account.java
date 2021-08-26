package com.java.week6.bankingsystem;

public abstract class Account {
	String accountNumber;
	int balance;
	public Account(String accountNumber, int balance){
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
}
class DebitAccount extends Account{
	public DebitAccount(String accountNumber, int balance){
		super (accountNumber, balance);
	}
}
class CreditAccount extends Account{
	int limit;
	public CreditAccount(String accountNumber, int balance, int limit){
		super(accountNumber, balance);
		this.limit = limit;
	}
}

package com.java.week6.bankingsystem;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mainclass {
	public static void main(String[] args) {

		Bank bankClass = new Bank();
		String accountNumber;
		int choice = 0;

		do{
			int amount = 0;
			int deposit = 0;
			int creditLimit = 0;
			int withdraw = 0;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println();
			System.out.println("*** BANK SYSTEM ***");
			System.out.println("1) Add a regular account");
			System.out.println("2) Add a credit account");
			System.out.println("3) Deposit money");
			System.out.println("4) Withdraw money");
			System.out.println("5) Remove an account");
			System.out.println("6) Print account information");
			System.out.println("7) Print all accounts");
			System.out.println("0) Quit");
			System.out.print("Your choice: ");
			try {
				choice = Integer.parseInt(br.readLine());
				switch (choice){
					case 1:
						System.out.print("Give an account number: ");
						accountNumber = br.readLine();
						System.out.print("Amount of money to deposit: ");
						deposit = Integer.parseInt(br.readLine());
						bankClass.addAccount(accountNumber, deposit);
						break;
					case 2:
						System.out.print("Give an account number: ");
						accountNumber = br.readLine();
						System.out.print("Amount of money to deposit: ");
						deposit = Integer.parseInt(br.readLine());
						System.out.print("Give a credit limit: ");
						creditLimit = Integer.parseInt(br.readLine());
						bankClass.addCreditAccount(accountNumber, deposit, creditLimit);
						break;
					case 3:
						System.out.print("Give an account number: ");
						accountNumber = br.readLine();
						System.out.print("Amount of money to deposit: " );
						deposit = Integer.parseInt(br.readLine());
						bankClass.depositMoney(accountNumber, deposit);
						break;
					case 4:
						System.out.print("Give an account number: ");
						accountNumber = br.readLine();
						System.out.print("Amount of money to withdraw: ");
						withdraw = Integer.parseInt(br.readLine());
						bankClass.withdrawMoney(accountNumber, withdraw);
						break;
					case 5:
						System.out.print("Give the account number of the account to delete: ");
						accountNumber = br.readLine();
						bankClass.removeAccount(accountNumber);
						break;
					case 6:
						System.out.print("Give the account number of the account to print information from: ");
						accountNumber = br.readLine();
						bankClass.accountInfo(accountNumber);
						break;
					case 7:
						bankClass.allAccounts();
						break;
					case 0:
						return;
					default:
						System.out.println("Invalid choice.");
				}
			} catch (IOException ex) {
				Logger.getLogger(Mainclass.class.getName()).log(Level.SEVERE, null, ex);
			}
		}while (choice != 0);
	}
}

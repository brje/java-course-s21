package com.week3.BottleDispenser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class BottleDispenser {
	private int bottles;
	private double money;
	//private Bottle[] bottle_array;
	private ArrayList <Bottle> bottle_array;
	private int choice = 0;
	//Constructor//

	public BottleDispenser() {
		bottles = 5;
		money = 0;

		// Initialize the array
		//bottle_array = new Bottle[bottles];
		bottle_array = new ArrayList();
		// Add Bottle-objects to the array
		for (int i = 0; i < bottles; i++) {
			// Use the default constructor to create new Bottles
			if (i == 0){
				bottle_array.add(new Bottle("Pepsi", "Pepsi Max", 0.3, 0.5, 1.8));
			}
			else if (i == 1){
				bottle_array.add(new Bottle("Pepsi", "Pepsi Max", 0.3, 1.5, 2.2));
			}
			else if (i == 2){
				bottle_array.add(new Bottle("Coca-Cola", "Coca-Cola Zero", 0.3, 0.5, 2.0));
			}
			else if (i == 3){
				bottle_array.add(new Bottle("Coca-Cola", "Coca-Cola Zero", 0.3, 1.5, 2.5));
			}
			else if (i == 4){
				bottle_array.add(new Bottle("Fanta", "Fanta Zero", 0.3, 0.5, 1.95));
			}
			else {
				bottle_array.add(new Bottle("Pepsi", "Pepsi Max", 0.3, 0.5, 1.8));
			}
		}
	}

	//Getters and setters//
	public double getBalance(double money){
		System.out.println(money);
		return money;
	}

	//Methods//
	public void addMoney() {
		money += 1;
		System.out.println("Klink! Added more money!");
	}

	public void buyBottle() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Your choice: ");
		try {
			choice = Integer.parseInt(br.readLine())-1;
		}catch (IOException ex){
			System.out.println("Error");
		}
		if (money <= bottle_array.get(choice).getPrice()){
			System.out.println("Add money first!");
		}
		else if (bottles <= 0){
			System.out.println("Add bottles first!");
		}
		else{
			System.out.println("KACHUNK! " +bottle_array.get(choice).getManufacturer()+ " came out of the dispenser!");
			money -= bottle_array.get(choice).getPrice();
		}
	}

	public void returnMoney() {
		System.out.println("Klink klink. Money came out! You got "+ String.format("%.2f", money) + "€ back");
		money = 0;
	}

	public void dispenserMenu(){
		System.out.println();
		System.out.println("*** BOTTLE DISPENSER ***");
		System.out.println("1) Add money to the machine");
		System.out.println("2) Buy a bottle");
		System.out.println("3) Take money out");
		System.out.println("4) List bottles in the dispenser");
		System.out.println("0) End");
		System.out.print("Your choice: ");
	}

	public void dispenserProducts(){
		int ordinal = 1;
		for (int i = 0; i < bottles; i++) {
			try{
				Bottle b = bottle_array.get(i);
				System.out.println(ordinal + ". Name: " + b.getManufacturer() );
				System.out.println("\tSize: " + b.getSize() + "\tPrice: " + b.getPrice());
				ordinal++;
			}
			catch (NullPointerException ex){
				continue;
			}
		}
	}
}


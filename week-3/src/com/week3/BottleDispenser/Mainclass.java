package com.week3.BottleDispenser;

import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Mainclass {

	private static BottleDispenser bd = null;

	private Mainclass(){}
	public static BottleDispenser getInstance(){
		if(bd == null){
			bd = new BottleDispenser();
		}
		return bd;
	}

	public static void main(String[] args) {

		int choice = 0;
		BottleDispenser bd = Mainclass.getInstance();
		BottleDispenser bdTest = Mainclass.getInstance();
		System.out.println(bd);
		System.out.println(bdTest);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do {
			bd.dispenserMenu();
			try {
				choice = Integer.parseInt(br.readLine());
			}catch (IOException ex){
				System.out.println("Error");
			}
			switch (choice){
				case 1:
					bd.addMoney();
					break;
				case 2:
					bd.dispenserProducts();
					bd.buyBottle();
					break;
				case 3:
					bd.returnMoney();
					break;
				case 4:
					bd.dispenserProducts();
					break;
			}

		}while (choice != 0);
		bd.returnMoney();

	}
}


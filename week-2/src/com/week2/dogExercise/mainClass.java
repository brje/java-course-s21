package com.week2.dogExercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class mainClass {

	public static void main(String[] args) {

		String dogName1 = "";
		String dogSpark1 = "";

		Dog newObj1 = new Dog(dogName1, dogName1);

		System.out.print("Give a name to the dog: ");
		BufferedReader brName = new BufferedReader(new InputStreamReader(System.in));
		try {
			dogName1 = brName.readLine();
		}catch (IOException ex){
		}

		newObj1.setName(dogName1);
		newObj1.speak(newObj1.getName());

		do{
			System.out.print("What does a dog say: ");
			BufferedReader brSpark = new BufferedReader(new InputStreamReader(System.in));
			try {
				dogSpark1 = brSpark.readLine();
			}catch (IOException ex){
			}
			newObj1.setSpark(dogSpark1);
			//newObj1.spark(newObj1.getSpark());
		}while(newObj1.getSpark() == "Much wow!");
	}
}

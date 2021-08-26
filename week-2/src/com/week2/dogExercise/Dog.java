package com.week2.dogExercise;

import java.lang.Boolean;
import java.util.Locale;

public class Dog {

	//Variables
	private String name;
	private String spark;

	//Constructor
	public Dog(String dogName, String dogSpark){
		this.name = dogName;
		this.spark = dogSpark;
	}

	//Getters and setters
	public String getName(){
		return name;
	}

	public void setName(String name) {
		if (name.trim().length() == 0 || name.isEmpty()) {
			this.name = "Doggo";
		}else {
			this.name = name;
		}
	}

	public void setSpark (String spark) {

		if (spark.trim().length() == 0 || spark.isEmpty()) {
			this.spark = "Much wow!";

		}else {
			this.spark = spark;
			String[] strArray = spark.split(" ");
			for (String output : strArray){
				try {
					Integer.parseInt(output);
					System.out.println("Such integer: " + output);
				}
				catch (NumberFormatException ex){
					if (output.toLowerCase().trim().equals("true") || output.toLowerCase().trim().equals("false")){
						System.out.println("Such boolean: " + output);
					}
					else
						{
						System.out.println(output);
					}
				}
			}

			}

		}



	public String getSpark() {
		return spark;
	}

	//Methods
	public void speak(String name){
		System.out.println("Hey, my name is " +name);
	}

	public void spark(String spark){
		this.spark = spark;
		System.out.println(name+ ": " + spark);
	}
}

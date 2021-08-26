package com.week5.car;

public class Mainclass {
	public static void main(String[] args) {
		Car car = new Car();
		System.out.println("Manufacturing: " +car.body);
		System.out.println("Manufacturing: " +car.chassis);
		System.out.println("Manufacturing: " +car.engine);
		for (int i = 0; i< car.wheels; i++){
			System.out.println("Manufacturing: " +car.wheel);
		}
		System.out.println("Car parts:");
		System.out.println("\t\t"+car.body);
		System.out.println("        " + car.chassis);
		System.out.println("        " + car.engine);
		System.out.println("        " + car.wheels + " " + car.wheel);

	}
}

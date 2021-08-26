package com.week3.BottleDispenser;

public class Bottle {

	private String name;
	private String manufacturer;

	private double total_energy;
	private double size;
	private double price;

	//Constructor//
	public Bottle(){
		String name = "Pepsi";
		String manufacturer = "Pepsi Max";
		total_energy = 0.3;
		size = 0.5;
		price = 1.8;

	}

	public Bottle(String name, String manuf, double totE, double size, double price ){
		this.name = name;
		this.manufacturer = manuf;
		this.total_energy = totE;
		this.size = size;
		this.price = price;
	}
	public String getName(){
		return name;
	}
	public String getManufacturer(){
		return manufacturer;
	}
	public double getEnergy(){
		return total_energy;
	}

	public double getPrice() {
		return price;
	}

	public double getSize() {
		return size;
	}
}

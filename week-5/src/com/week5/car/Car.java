package com.week5.car;

public class Car {
	public String body;
	public String engine;
	public String chassis;
	public String wheel;
	public int wheels;

	public Car() {
		body = this.Body();
		engine = this.Engine();
		chassis = this.Chassis();
		wheel = this.Wheel();
		wheels = this.Wheels();
		}
	public String Body (){
		body = "Body";
		return body;
	}
	public String Engine (){
		engine = "Engine";
		return engine;
	}
	public String Chassis (){
		chassis = "Chassis";
		return chassis;
	}
	public String Wheel (){
		wheel = "Wheel";
		return wheel;
	}
	public int Wheels(){
		wheels = 4;
		return wheels;
	}
}


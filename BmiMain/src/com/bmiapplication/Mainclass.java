package com.bmiapplication;

public class Mainclass {

	public static void main(String[] args) {

		bmiBackend bb = new bmiBackend();
		bb.request();
		//System.out.println(bb.getBmi());
		bb.getBmiFromWho("Male", "1990");
		System.out.println(bb.getBmiFromWho("Male", "1991"));

	}
}

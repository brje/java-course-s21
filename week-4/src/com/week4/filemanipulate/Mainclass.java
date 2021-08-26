package com.week4.filemanipulate;

public class Mainclass {
	public static void main(String[] args) {
		String txtFileInput = "input.txt";
		String zipFileInput = "zipinput.zip";
		String OUTPUT = "output.txt";
		ReadAndWriteIO rw = new ReadAndWriteIO();
		rw.setIO(txtFileInput, zipFileInput, OUTPUT);
		rw.readFile();
		rw.readZip();
		System.out.println(Runtime.getRuntime().totalMemory());
		Runtime.getRuntime().freeMemory();
		System.gc();
	}
}

package com.week4.filemanipulate;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipInputStream;

public class ReadAndWriteIO {

	private String txtFileInput;
	private String OUTPUT;
	private String zipFileInput;


	public ReadAndWriteIO(){
	}
	public void getDirectory(){
		System.out.println( System.getProperty( "user.dir" ) );
	}

	//Getters and setters
	public String getFile(){
		return txtFileInput;
	}

	public void setIO(String txtFileInput, String zipFileInput, String OUTPUT){
		this.txtFileInput = txtFileInput;
		this.OUTPUT = OUTPUT;
		this.zipFileInput = zipFileInput;
	}

	//Methods
	public void readFile(){
		try{
			BufferedReader br = new BufferedReader(new FileReader(txtFileInput));
			BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT));
			String line;
			while((line = br.readLine()) != null){
				if (line.length() < 30 && line.trim().length() != 0 && line.contains("v")){
					bw.write(line);
					bw.newLine();
				}

			}
			bw.close();
			br.close();
		}catch (FileNotFoundException ex) {
			Logger.getLogger(ReadAndWriteIO.class.getName()).log(Level.SEVERE, null, ex);
		}catch (IOException ex){
			Logger.getLogger(ReadAndWriteIO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void readZip(){
		try(FileInputStream fis = new FileInputStream(zipFileInput)){

			int buf;
			byte[] buffer = new byte[1048];
			String temp;

			//Katsottu apua stackoverflowsta
			ZipInputStream zis = new ZipInputStream(fis);
			zis.getNextEntry();
			buf =  zis.read(buffer);
			zis.closeEntry();
			zis.close();

			temp = new String (buffer, 0, buf);
			System.out.println(temp);
		}catch (IOException ex){
			Logger.getLogger(ReadAndWriteIO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}

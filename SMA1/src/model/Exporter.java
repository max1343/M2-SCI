package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public  class Exporter {
	
	private String fileName;
	FileWriter writer;
	File file;
	BufferedWriter bw;
	PrintWriter printW;

	public Exporter(String filename) {
		this.fileName = filename;
		file = new File(filename + ".txt");

		try {

			if (!file.exists()) {
			   file.createNewFile();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeOnFile(String trace) {

		try {
			//writer = new FileWriter(file);
			System.out.println(trace);
			printW = new PrintWriter(file);
			printW.println(trace);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void closeFile() {
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

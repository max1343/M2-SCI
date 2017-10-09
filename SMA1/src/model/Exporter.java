package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public  class Exporter {
	
	private String fileName;
	FileWriter writer;
	BufferedWriter bw;

	public Exporter(String filename) {
		this.fileName = filename;
		File file = new File(filename + ".txt");

		try {

			if (!file.exists()) {
			   file.createNewFile();
			}
			writer = new FileWriter(file);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeOnFile(String trace) {

		try {
			System.out.println(trace);
			bw = new BufferedWriter(writer);
			bw.write(trace);
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

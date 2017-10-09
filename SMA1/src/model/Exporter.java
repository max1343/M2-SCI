package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public  class Exporter {
	
	private String fileName;
	FileWriter writer;
	BufferedWriter bw;

	public Exporter(String filename) {
		this.fileName = filename;
		try {
			writer = new FileWriter(this.fileName);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeOnFile(String trace) {

		bw = new BufferedWriter(writer);
		try {
			bw.write(trace);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void closeFile() {
		try {
			bw.close();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

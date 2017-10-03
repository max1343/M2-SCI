package main;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import model.Agent;
import model.Environment;
import model.SMA;
import vue.CanvasGrille;
import vue.Fenetre;
import wator.EnvironmentWator;
import wator.SMAWator;

public class Main {
	public boolean grid;
	
	public static int gridSizeX = 0;
	public static int gridSizeY = 0;
	

	public static boolean TORUS = false;
	public static int seed;
	public static boolean trace;
	final static Properties prop = new Properties();
	static InputStream input = null;
	static Environment env;	
	static CanvasGrille c; 
	static SMA sma;
	
	public static void main(String[] args) {

		
		try {
			// load a properties file
			input = new FileInputStream("src/constant.properties");
			prop.load(input);
			
			// r�cup�ration et traitement des donn�es du fichiers
			if(Integer.parseInt(prop.getProperty("db.seed")) == 0){
				 seed = (int) Math.round(Math.random()*65000); 
			}else
				seed = Integer.parseInt(prop.getProperty("db.seed"));
		
			
			createCanvas();
			
			switch(prop.getProperty("db.type")) {
				case "particles" : 	//sma = new SMAParticles();
								   	break;								   
				case "fishes": 	   	createWatorEnvironment();
									sma = new SMAWator((EnvironmentWator) env, Boolean.valueOf(prop.getProperty("db.trace")), prop.getProperty("db.scheduling"), Integer.parseInt(prop.getProperty("db.nbTicks")), seed, 
						Integer.parseInt(prop.getProperty("db.nbFish")), Integer.parseInt(prop.getProperty("db.nbShark")), Integer.parseInt(prop.getProperty("db.fishBreedTime")),
						Integer.parseInt(prop.getProperty("db.sharkBreedTime")), Integer.parseInt(prop.getProperty("db.sharkStarveTime")));
							       break;
			}
			
			Fenetre fen = new Fenetre(c);
			//c.setType(Integer.parseInt(prop.getProperty("db.type")));
			sma.addObserver(c);
			sma.firstRun();
		
		
		} catch (final IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
		}	
	}
	
	
	public static void createWatorEnvironment() {
		//create an environment
		int gridSizeX = Integer.parseInt(prop.getProperty("db.gridSizeX"));
		int gridSizeY = Integer.parseInt(prop.getProperty("db.gridSizeY"));
		env = new EnvironmentWator(gridSizeX,gridSizeY);
		env.setTorique(Boolean.valueOf(prop.getProperty("db.torus")));

	}
	
	public static void createCanvas() {
		c = new CanvasGrille(env);
		c.grid = Boolean.valueOf(prop.getProperty("db.grid"));
		c.setCSizeX(Integer.parseInt(prop.getProperty("db.canvasSizeX")));
		c.setCSizeY(Integer.parseInt(prop.getProperty("db.canvasSizeY")));
	}

}
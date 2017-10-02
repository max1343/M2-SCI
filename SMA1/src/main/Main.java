package main;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import modele.Agent;
import modele.Environnement;
import modele.SMA;
import particules.AgentParticule;
import vue.CanvasGrille;
import vue.Fenetre;
import wator.Fish;
import wator.Shark;

public class Main {
	public boolean grid;
	
	public static int gridSizeX = 0;
	public static int gridSizeY = 0;
	

	public static boolean TORUS = false;
	public static int seed;
	public static boolean trace;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Properties prop = new Properties();
		InputStream input = null;
		Environnement env;

		
		
		
		CanvasGrille c; 
		ArrayList<Agent> truc = new ArrayList<Agent>();
		Agent a;
		SMA sma;

		
		
		try {

			input = new FileInputStream("src/constant.properties");

			// load a properties file
			prop.load(input);
			
			if(Integer.parseInt(prop.getProperty("db.seed")) == 0){
				 seed = (int) Math.round(Math.random()*65000); 
			}else
				seed = Integer.parseInt(prop.getProperty("db.seed"));
			
			int gridSizeX = Integer.parseInt(prop.getProperty("db.gridSizeX"));
			int gridSizeY = Integer.parseInt(prop.getProperty("db.gridSizeY"));
			env = new Environnement(gridSizeX,gridSizeY);
			env.setTorique(Boolean.valueOf(prop.getProperty("db.torus")));

			c = new CanvasGrille(env);
			c.grid = Boolean.valueOf(prop.getProperty("db.grid"));
			c.setCSizeX(Integer.parseInt(prop.getProperty("db.canvasSizeX")));
			c.setCSizeY(Integer.parseInt(prop.getProperty("db.canvasSizeY")));
			
			trace = Boolean.valueOf(prop.getProperty("db.trace"));

			if(Integer.parseInt(prop.getProperty("db.type"))==1){
				for(int i =1;i<=Integer.parseInt(prop.getProperty("db.nbParticles"));i++){
					a = new AgentParticule(env, seed, trace);
					truc.add( (Agent) a);
					env.setBall(a);
					seed++;
				}	
			}
			else if(Integer.parseInt(prop.getProperty("db.type")) == 2){
				for(int i =1;i<=Integer.parseInt(prop.getProperty("db.nbFish"));i++){			
					a = new Fish(0,0,2,Color.BLUE,env, seed, trace,false);
					truc.add( (Agent) a);
					env.setBall((Agent) a);
					seed++;
				}
			
				for(int i =1;i<=Integer.parseInt(prop.getProperty("db.nbShark"));i++){			
					a = new Shark(0,0,3,Color.BLUE,4,trace, env, seed,false);
					truc.add( (Agent) a);
					env.setBall((Agent) a);
					seed++;
				}
			}
			
			sma = new SMA(truc,env, trace);
			sma.nbTicks =  Integer.parseInt(prop.getProperty("db.nbTicks"));
			sma.FPS =  Integer.parseInt(prop.getProperty("db.delay"));
			sma.scheduling = prop.getProperty("db.scheduling");
			Fenetre fen = new Fenetre(c);
			c.setType(Integer.parseInt(prop.getProperty("db.type")));
			sma.addObserver(c);
			sma.run();
		
			
			
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

}

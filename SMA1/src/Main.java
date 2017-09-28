import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import modele.Environnement;
import modele.SMA;
import particules.Particule;
import vue.CanvasGrille;
import vue.Fenetre;

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
		ArrayList<Particule> truc = new ArrayList<Particule>();
		Particule a;
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

			
			for(int i =1;i<=Integer.parseInt(prop.getProperty("db.nbParticles"));i++){
				a = new Particule(env, seed, trace);
				truc.add(a);
				env.setBall(a);
				seed++;
			}
			
	
			sma = new SMA(truc,env, trace);
			sma.nbTicks =  Integer.parseInt(prop.getProperty("db.nbTicks"));
			sma.FPS =  Integer.parseInt(prop.getProperty("db.delay"));
			sma.scheduling = prop.getProperty("db.scheduling");
			Fenetre fen = new Fenetre(c);
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

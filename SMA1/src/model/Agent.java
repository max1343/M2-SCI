package model;

import java.awt.Color;
import java.util.HashMap;
import java.util.Observable;
import java.util.Random;

public abstract class Agent {
	
	public enum Direction{
		Nord(0,1),
		Sud(0,-1),
		Est(1,0),
		Ouest(-1,0),
		NordEst(1,1),
		NordOuest(-1,1),
		SudEst(1,-1),
		SudOuest(-1,-1);
		
		int pasX, pasY;
		Direction(int pasX, int pasY){
			this.pasX = pasX;
			this.pasY = pasY;
		}
		
		public int getX(){
			return this.pasX;
		}
		
		public int getY(){
			return this.pasY;
		}
	};
	
	protected int posX;
	protected int posY;
	private Environment env;
	private HashMap<String,Action> actions;
	protected Color couleur;
	public boolean trace;
	
	public Agent(int posX, int posY, Color c, Environment e, boolean trace){
		this.posX = posX;
		this.posY = posY;
		this.couleur = c;
		this.env = e;
		
		this.trace = trace;
	}
	
	public abstract void decide();
	
	public int getPosX() {
		return posX;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}


	public int getPosY() {
		return posY;
	}


	public void setPosY(int posY) {
		this.posY = posY;
	}


	public Color getColor() {
		return this.couleur;
	}
	
	public void setColor(Color couleur) {
		this.couleur = couleur;
	}
	
	public Environment getEnv(){
		return this.env;
	}
}
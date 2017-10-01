package modele;

import java.awt.Color;
import java.util.HashMap;
import java.util.Observable;

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
	};
	
	protected int posX;
	protected int posY;
	private Observable env;
	private HashMap<String,Action> actions;
	private Color couleur;
	
	public Agent(int posX, int posY, Observable e){
		this.posX = posX;
		this.posY = posY;
		this.env = e;
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
}

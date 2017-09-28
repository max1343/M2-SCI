package modele;

import java.util.HashMap;

import wator.Movement;

public abstract class Agent {
	private int posX;
	private int posY;
	private HashMap<String,Action> actions;
	
	public Agent(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
	}
	
	public void decide(){
		
	}
	
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


	
}

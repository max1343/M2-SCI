package wator;

import java.awt.Color;

import modele.Agent;

public class Fish extends Agent{
	private int fishBreedTime;
	private Color couleur;
	
	
	public Fish(int posX, int posY, int fishBreedTime, Color couleur){
		super(posX, posY);
		this.fishBreedTime = fishBreedTime;
		this.couleur = couleur;
	}
	
	
}

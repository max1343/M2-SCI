package wator;

import java.awt.Color;

import modele.Agent;

public class Shark extends Agent {
	private int sharkBreedTime;
	private Color couleur;
	private int sharkStarveTime;

	public Shark(int posX, int posY, int sharkBreedTime, Color couleur, int sharkStarveTime){
		super(posX, posY);
		this.sharkBreedTime = sharkBreedTime;
		this.sharkStarveTime = sharkStarveTime;
		this.couleur = couleur;
	}
}

package wator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import modele.Action;
import modele.Agent;
import modele.Environnement;

public class Fish extends Agent{
	private int fishBreedTime, countFishBreedTime;
	private Color couleur;
	private Action ac;
	private int seed;
	
	public Fish(int posX, int posY, int fishBreedTime, Color couleur,Environnement env,int seed, boolean trace, boolean child){
		super(posX, posY,couleur,env,trace);
		this.fishBreedTime = fishBreedTime;
		this.countFishBreedTime = fishBreedTime;
		this.seed = seed;
		if (!child){
			Random rnd = new Random(seed);
			this.posX = rnd.nextInt(env.height - 1); 
			this.posY = rnd.nextInt(env.width - 1); 
		}
	}

	@Override
	public void decide() {
		ArrayList<Direction> ad = this.getEnv().lookAt("vide",this.posX,this.posY);
		if(ad != null){
			Collections.shuffle(ad);
			ac.move(ad.get(1).getX(),ad.get(1).getY(), this);
			if(countFishBreedTime == 0){
				Fish f = new Fish(this.posX - ad.get(1).getX(), this.posY - ad.get(1).getY(), this.fishBreedTime, Color.green, this.getEnv(), seed, super.trace, true);
				this.getEnv().setBall((Agent) f);
				countFishBreedTime = fishBreedTime;
			}else
				countFishBreedTime--;
		}
		this.couleur = Color.BLUE;
	}
	
	
	
	
}

package wator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import modele.Action;
import modele.Agent;
import modele.Environnement;

public class Shark extends Agent {
	private int sharkBreedTime, countSharkBreedTime;
	private Color couleur;
	private int sharkStarveTime, countSharkStarveTime;
	private Action ac;
	private int seed;

	public Shark(int posX, int posY, int sharkBreedTime, Color couleur, int sharkStarveTime,boolean trace,Environnement env,int seed,boolean child){
		super(posX, posY,couleur,env,trace);
		this.sharkBreedTime = sharkBreedTime;
		this.countSharkBreedTime = sharkBreedTime;
		this.sharkStarveTime = sharkStarveTime;
		this.countSharkStarveTime = sharkStarveTime;
		this.couleur = couleur;
		this.seed = seed;
		
		if (!child){
			Random rnd = new Random(seed);
			this.posX = rnd.nextInt(env.height - 1); 
			this.posY = rnd.nextInt(env.width - 1); 
		}
	}	

	@Override
	public void decide() {
		ArrayList<Direction> ad = this.getEnv().lookAt("poisson",this.posX, this.posY);
		if(ad != null){
			Collections.shuffle(ad);
			ac.eat(ad.get(0).getX(), ad.get(0).getY(), this);
			this.countSharkStarveTime = sharkStarveTime;
			if(countSharkBreedTime == 0){
				Shark k = new Shark(this.posX - ad.get(1).getX(), this.posY - ad.get(1).getY(), this.sharkBreedTime, Color.PINK, this.sharkStarveTime, super.trace,  this.getEnv(), seed, true);
				this.getEnv().setBall((Agent) k);
				countSharkBreedTime = sharkBreedTime;
			}else
				countSharkBreedTime--;
		}else{
			
			ad = this.getEnv().lookAt("vide",this.posX,this.posY);
			if(ad != null){
				Collections.shuffle(ad);
				ac.move(ad.get(0).getX(),ad.get(0).getY(), this);
				if(countSharkBreedTime == 0){
					Shark k = new Shark(this.posX - ad.get(1).getX(), this.posY - ad.get(1).getY(), this.sharkBreedTime, Color.PINK, this.sharkStarveTime, super.trace,  this.getEnv(), seed, true);
					this.getEnv().setBall((Agent) k);
					countSharkBreedTime = sharkBreedTime;
				}else
					countSharkBreedTime--;
			}
			countSharkStarveTime--;
			if(countSharkStarveTime == 0){
				this.getEnv().deleteBall(this);
			}
		}
		this.couleur = Color.RED;
	}
}

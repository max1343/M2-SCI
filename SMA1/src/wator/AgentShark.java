package wator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import model.Action;
import model.Agent;

public class AgentShark extends Agent {
	private int sharkBreedTime, countSharkBreedTime;
	private Color couleur;
	private int sharkStarveTime, countSharkStarveTime;
	private Action ac;

	public AgentShark(int posX, int posY, int sharkBreedTime, Color couleur, int sharkStarveTime,boolean trace,EnvironmentWator env){
		super(posX, posY,couleur,env,trace);
		this.sharkBreedTime = sharkBreedTime;
		this.countSharkBreedTime = sharkBreedTime;
		this.sharkStarveTime = sharkStarveTime;
		this.countSharkStarveTime = sharkStarveTime;
		this.couleur = couleur;

	}	

	@Override
	public void decide() {
		ArrayList<Direction> ad = ((EnvironmentWator) getEnv()).lookAt("poisson",this.posX, this.posY);
		if(ad != null){
			Collections.shuffle(ad);
			ac.eat(ad.get(0).getX(), ad.get(0).getY(), this);
			this.countSharkStarveTime = sharkStarveTime;
			if(countSharkBreedTime == 0){
				AgentShark k = new AgentShark(this.posX - ad.get(1).getX(), this.posY - ad.get(1).getY(), this.sharkBreedTime, Color.PINK, this.sharkStarveTime, super.trace, (EnvironmentWator) getEnv());
				this.getEnv().setBall((Agent) k);
				countSharkBreedTime = sharkBreedTime;
			}else
				countSharkBreedTime--;
		}else{
			
			ad = ((EnvironmentWator) getEnv()).lookAt("vide",this.posX,this.posY);
			if(ad != null){
				Collections.shuffle(ad);
				ac.move(ad.get(0).getX(),ad.get(0).getY(), this);
				if(countSharkBreedTime == 0){
					AgentShark k = new AgentShark(this.posX - ad.get(1).getX(), this.posY - ad.get(1).getY(), this.sharkBreedTime, Color.PINK, this.sharkStarveTime, super.trace, (EnvironmentWator) getEnv());
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
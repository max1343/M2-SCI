package wator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import model.Agent;
import model.Environment;

public class AgentFish extends Agent{
	private int fishBreedTime, countFishBreedTime;
	private Color couleur;
	private int seed;
	
	public AgentFish(int posX, int posY, int fishBreedTime, Color couleur,EnvironmentWator env, boolean trace){
		super(posX, posY,couleur,env,trace);
		this.fishBreedTime = fishBreedTime;
		this.countFishBreedTime = fishBreedTime;
	}

	@Override
	public void decide() {
		System.out.println("DEBUG fish");
		this.couleur = Color.BLUE;
		ArrayList<Direction> ad = ((EnvironmentWator) getEnv()).lookAt("vide",this.posX,this.posY);
		if(!ad.isEmpty()){
			Collections.shuffle(ad);
			int childPosX = getPosX();
			int childPosY = getPosY();
			Direction d = ad.get(0);
			move(d.getX(),d.getY());
			if(countFishBreedTime == 0){
				AgentFish f = new AgentFish(childPosX, childPosY, this.fishBreedTime, Color.green, (EnvironmentWator) getEnv(), super.trace);
				getEnv().setBall((Agent) f);
				countFishBreedTime = fishBreedTime;
			}else
				countFishBreedTime--;
		}
	}
	
	
	
	
}

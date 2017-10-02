package wator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import model.Action;
import model.Agent;
import model.Environment;

public class AgentFish extends Agent{
	private int fishBreedTime, countFishBreedTime;
	private Color couleur;
	private Action ac;
	private int seed;
	
	public AgentFish(int posX, int posY, int fishBreedTime, Color couleur,Environment env, boolean trace){
		super(posX, posY,couleur,env,trace);
		this.fishBreedTime = fishBreedTime;
		this.countFishBreedTime = fishBreedTime;
	}

	@Override
	public void decide() {
		ArrayList<Direction> ad = ((EnvironmentWator) getEnv()).lookAt("vide",this.posX,this.posY);
		if(!ad.isEmpty()){
			Collections.shuffle(ad);
			Direction d = ad.get(0);
			ac.move(d.getX(),d.getY(), this);
			if(countFishBreedTime == 0){
				AgentFish f = new AgentFish(this.posX - ad.get(1).getX(), this.posY - ad.get(1).getY(), this.fishBreedTime, Color.green, getEnv(), super.trace);
				getEnv().setBall((Agent) f);
				countFishBreedTime = fishBreedTime;
			}else
				countFishBreedTime--;
		}
		this.couleur = Color.BLUE;
	}
	
	
	
	
}

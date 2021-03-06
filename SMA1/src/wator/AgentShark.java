package wator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import model.Agent;

public class AgentShark extends Agent {
	private int sharkBreedTime, countSharkBreedTime;
	private int sharkStarveTime, countSharkStarveTime;

	public AgentShark(int posX, int posY, int sharkBreedTime, Color couleur, int sharkStarveTime,boolean trace,EnvironmentWator env){
		super(posX, posY,couleur,env,trace);
		this.sharkBreedTime = sharkBreedTime;
		this.countSharkBreedTime = sharkBreedTime;
		this.sharkStarveTime = sharkStarveTime;
		this.countSharkStarveTime = sharkStarveTime;
	}	

	@Override
	public void decide() {
	//	System.out.println("DEBUG shark");
		setColor(Color.RED);
		ArrayList<Direction> ad = ((EnvironmentWator) getEnv()).lookAt("poisson", this);
		if(!ad.isEmpty()){
			Collections.shuffle(ad);
			System.out.println(ad);
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Direction d = ad.get(0);
			eat(d.getX(), d.getY());
			System.out.println("count" + countSharkStarveTime);

			this.countSharkStarveTime = sharkStarveTime;
			if(countSharkBreedTime == 0){
				AgentShark k = new AgentShark(this.posX - d.getX(), this.posY - d.getY(), this.sharkBreedTime, Color.PINK, this.sharkStarveTime, super.trace, (EnvironmentWator) getEnv());
				this.getEnv().setBall((Agent) k);
				countSharkBreedTime = sharkBreedTime;
			}else
				countSharkBreedTime--;
		}else{
			
			ad = ((EnvironmentWator) getEnv()).lookAt("vide",this);
			if(!ad.isEmpty()){
				Collections.shuffle(ad);
				Direction d = ad.get(0);
				move(d.getX(),d.getY());
				if(countSharkBreedTime == 0){
					AgentShark k = new AgentShark(this.posX - d.getX(), this.posY - d.getY(), this.sharkBreedTime, Color.PINK, this.sharkStarveTime, super.trace, (EnvironmentWator) getEnv());
					getEnv().setBall((Agent) k);
					countSharkBreedTime = sharkBreedTime;
				}else
					countSharkBreedTime--;
			}
			countSharkStarveTime--;
			if(countSharkStarveTime == 0){
				getEnv().deleteBall(this);
			}
		}
	}
	
	
	public void eat(int x, int y){
		getEnv().deleteBall(getEnv().getAgentAtPosition(posX + x, posY + y));
		move(x, y);
	}
}

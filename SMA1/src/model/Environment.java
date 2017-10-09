package model;
import java.util.ArrayList;
import java.util.Observable;

import model.Agent.Direction;
import pacman.AgentHunter;
import particles.AgentParticles;
import wator.AgentFish; 

public abstract class Environment extends Observable {
	public int height, width;
	public Agent[][] agents;
	public boolean torique;
	
	public Environment(int height, int width) {
		this.height = height;
		this.width = width;
		agents = new Agent[width][height];
	}

	public boolean hasAgentAtPosition(int x, int y){
		return getAgents()[x][y] != null;
	}
	
	public Agent getAgentAtPosition(int x, int y){
		return getAgents()[x][y];
	}
	

	public void setBall(Agent a){
		getAgents()[a.getPosX()][a.getPosY()] = a;
	}
	
	public void deleteBall(Agent a){
		/** if(a instanceof AgentHunter){
			getAgents()[a.getPosX()][a.getPosY()] = new AgentNull(a.getPosX(), a.getPosY(),a.getEnv(),true);
		}
		else **/
			getAgents()[a.getPosX()][a.getPosY()] = null;
	}

	public ArrayList<Agent> getAllBall() {
		ArrayList<Agent> liste = new ArrayList<Agent>();
		for(int i = 0; i<width; i++){
			for(int j=0; j<height; j++){
				if(getAgents()[i][j] != null){
					liste.add(getAgents()[i][j]);
				}		
			}
		}
		return liste;
	}


	public void setTorique(boolean tor){
		this.torique = tor;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}

	public Agent[][] getAgents() {
		return agents;
	}

}
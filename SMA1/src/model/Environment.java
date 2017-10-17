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
		return agents[x][y] != null;
	}
	
	public Agent getAgentAtPosition(int x, int y){
		return agents[x][y];
	}
	

	public void setBall(Agent a){
		agents[a.getPosX()][a.getPosY()] = a;
	}
	
	public void deleteBall(Agent a){
		/** if(a instanceof AgentHunter){
			getAgents()[a.getPosX()][a.getPosY()] = new AgentNull(a.getPosX(), a.getPosY(),a.getEnv(),true);
		}
		else **/
		agents[a.getPosX()][a.getPosY()] = null;
	}

	public ArrayList<Agent> getAllAgents() {
		ArrayList<Agent> liste = new ArrayList<Agent>();
		for(int i = 0; i<width; i++){
			for(int j=0; j<height; j++){
				if(agents[i][j] != null){
					liste.add(agents[i][j]);
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
	
	public void sendFinish() {
		ArrayList<Agent> liste = getAllAgents();
		for(Agent ag: liste) {
			ag.setGameFinished(true);
		}
	}

}
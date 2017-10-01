package modele;
import java.util.ArrayList;


import java.util.Observable;
import java.util.Observer;

import particules.AgentParticule; 

public class Environnement extends Observable {
	public int height, width;
	Agent[][] agents;
	public boolean torique;
	
	public Environnement(int height, int width) {
		this.height = height;
		this.width = width;
		agents = new AgentParticule[height][width];
	}

	public boolean hasAgentAtPosition(int x, int y){
		return agents[x][y] != null;
	}
	
	public Agent getAgentAtPosition(int x, int y){
		return agents[x][y];
	}
	
	public void setBall(AgentParticule a){
		agents[a.getPosX()][a.getPosY()] = a;
	}
	
	public void deleteBall(AgentParticule a){
		agents[a.getPosX()][a.getPosY()] = null;
	}

	public ArrayList<Agent> getAllBall() {
		ArrayList<Agent> liste = new ArrayList<Agent>();
		for(int i = 0; i<height; i++){
			for(int j=0; j<width; j++){
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
	
	
}
package pacman;

import model.AgentNull;
import model.Environment;

public class EnvironmentPacman extends Environment {
	
	private int[][] dijsktra;
	public EnvironmentPacman(int height, int width) {
		super(height, width);
		dijsktra = new int[width][height];
		
	}
	
	
	public void initDijkstra(){
		for(int i=0; i<height; i++){
			for(int j=0; j<width; j++){
				if(this.agents[i][j] != null){
					this.agents[i][j].dijkstra = -1;
				}
				else{
					//this.agents[i][j] = new AgentNull(i,j,this,true);
					
				}
			}
		}
	}
	
	
}

package pacman;

import java.util.ArrayList;

import model.Agent;
import model.Agent.Direction;
import model.Environment;

public class EnvironmentPacman extends Environment {
	
	private int[][] dijsktra;
	private AgentAvatar avatar;
	
	public EnvironmentPacman(int height, int width) {
		super(height, width);
		dijsktra = new int[width][height];
		
	}
	
	
	public void initDijkstra(AgentAvatar av){
		for(int i=0; i<height; i++){
			for(int j=0; j<width; j++){
				dijsktra[i][j] = Math.abs(i - av.getPosX()) + Math.abs(j - av.getPosY());
				if(getAgentAtPosition(i, j) instanceof AgentWall)
					dijsktra[i][j] += 10;
			}
		}
	}
	
	
	public Direction getMinDirection(AgentHunter ah) {
		int dmin = width+height;
		Direction dir = Direction.Nord;
		for (Direction d : Direction.values()){		
			if(d.equals(Direction.Nord) || d.equals(Direction.Sud) || d.equals(Direction.Est) || d.equals(Direction.Ouest)) {
				if(dijsktra[ah.getPosX() + d.getX()][ah.getPosY() + d.getY()] <= dmin ) {
					dmin = dijsktra[ah.getPosX() + d.getX()][ah.getPosY() + d.getY()];
					dir = d;
				}
			}
		}
		return dir;
	}
	
	public AgentAvatar getAvatar() {
		return this.avatar;
	}
	
	public void setAvatar(AgentAvatar av) {
		this.avatar = av;
	}
	
	
	public void findAvatar(int pasX, int pasY){
		AgentAvatar ag = null;
		for(int i = 0; i<height; i++){
			for(int j = 0; i<width; j++){
				if(getAgentAtPosition(i, j) instanceof AgentAvatar)
					ag = (AgentAvatar) getAgentAtPosition(i, j);
			}
		}
		ag.setPasX(pasX);
		ag.setPasY(pasY);
	}
	


	public String toString() {
		String rt = null;
		ArrayList<Agent> ags = getAllAgents();
		for(Agent ag : ags) {
			rt += "Agent " + ag.getClass() + "\n";
		}
		return rt;
	}
	
	
}

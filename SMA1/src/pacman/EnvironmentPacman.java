package pacman;

import model.Agent.Direction;
import model.Environment;

public class EnvironmentPacman extends Environment {
	
	private int[][] dijsktra;
	public EnvironmentPacman(int height, int width) {
		super(height, width);
		dijsktra = new int[width][height];
		
	}
	
	
	public void initDijkstra(AgentAvatar av){
		for(int i=0; i<height; i++){
			for(int j=0; j<width; j++){
				dijsktra[i][j] = Math.abs(i - av.getPosX()) + Math.abs(j - av.getPosY());
			}
		}
	}
	
	
	public Direction getMinDirection(AgentHunter ah) {
		int dmin = 10;
		Direction dir = Direction.Nord;
		for (Direction d : Direction.values()){		
			if(dijsktra[ah.getPosX() + d.getX()][ah.getPosY() + d.getY()] <= dmin ) {
				dmin = dijsktra[ah.getPosX() + d.getX()][ah.getPosY() + d.getY()];
				dir = d;
			}
		}
		return dir;
	}
	
	
	
}

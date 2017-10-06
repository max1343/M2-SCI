package pacman;

import java.awt.Color;

import model.Agent;
import model.Environment;

public class AgentHunter extends Agent {

	public AgentHunter(int posX, int posY, Color c, Environment e, boolean trace) {
		super(posX, posY, c, e, trace);
	}	
	
	@Override
	public void decide() {
		EnvironmentPacman e = (EnvironmentPacman) this.getEnv();
		int min=e.getHeight()*e.getWidth(), ix=0, iy=0;
		for (Direction d : Direction.VALUES){
			if(e.getAgentAtPosition(this.posX+d.getX(), this.posY + d.getY()).getDijkstra() < min){
				ix = d.getX();
				iy = d.getY();
				min = e.getAgentAtPosition(this.posX+d.getX(), this.posY + d.getY()).getDijkstra();
			}
		}
		move(ix,iy);
	}
	
}

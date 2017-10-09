package pacman;

import java.awt.Color;

import model.Agent;
import model.Environment;

public class AgentNull extends Agent {
	
	public AgentNull(int x,int y,Environment environment, boolean trace) {
		super(x, y,Color.white, environment, trace);
		this.dijkstra = -1;
	}

	@Override
	public void decide() {
		// TODO Auto-generated method stub
		
	}
}

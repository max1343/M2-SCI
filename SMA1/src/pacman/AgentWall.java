package pacman;

import java.awt.Color;

import model.Agent;
import model.Environment;

public class AgentWall extends Agent {
	
	public AgentWall(int posX, int posY, Environment env, boolean trace) {
		super(posX,posY,Color.black,env, trace);
	}

	@Override
	public void decide() {
		// TODO Auto-generated method stub
		
	}
}

package pacman;

import java.awt.Color;

import model.Agent;
import model.Environment;

public class AgentHunter extends Agent {

	private int tour, i =0;
	
	public AgentHunter(int posX, int posY, Color c, Environment e, boolean trace, int tour) {
		super(posX, posY, c, e, trace);
	}	
	
	@Override
	public void decide() {
		if(!gameFinished) {
			if(i == tour) {
				Direction dirMin = ((EnvironmentPacman) getEnv()).getMinDirection(this);
				//int min=e.getHeight()*e.getWidth(), ix=0, iy=0;

				move(dirMin.getX(),dirMin.getY());

				i=0;
			}else
				i++;
	
			}
		}
	
}

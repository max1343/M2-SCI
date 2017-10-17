package wator;

import java.util.ArrayList;

import model.Agent;
import model.Agent.Direction;
import model.Environment;

public class EnvironmentWator extends Environment {

	public EnvironmentWator(int height, int width) {
		super(height, width);
	}
	
	public ArrayList<Direction> lookAt(String param, Agent a){
		ArrayList<Direction> listeDir = new ArrayList<Direction>();
		int posX = 0, posY = 0;

		
		if(param == "vide"){
			for (Direction d : Direction.values()){		

				if ((a.getPosX() + d.getX()) < 0)
					posX = width - 1;
				if ((a.getPosY() + d.getY()) < 0)
					posY = height - 1;
				//regarde la case si vide add la liste
				if(!hasAgentAtPosition(posX % getWidth(), posY % getHeight()))
					listeDir.add(d);
			}
		}else if(param == "poisson"){
			for (Direction d : Direction.values()){		

				if ((a.getPosX() + d.getX()) < 0)
					posX = width - 1;
				if ((a.getPosY() + d.getY()) < 0)
					posY = height - 1;
				
				if(getAgentAtPosition(posX % getWidth(), posY % getHeight()) instanceof AgentFish)
					listeDir.add(d);
			}
		}
		return listeDir;
	}
}

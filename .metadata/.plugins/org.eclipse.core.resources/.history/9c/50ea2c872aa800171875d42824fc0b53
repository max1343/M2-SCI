package wator;

import java.util.ArrayList;

import model.Agent;
import model.Agent.Direction;
import model.Environment;

public class EnvironmentWator extends Environment {

	public EnvironmentWator(int height, int width) {
		super(height, width);
	}
	
	public ArrayList<Direction> lookAt(String param,int x, int y){
		ArrayList<Direction> listeDir = new ArrayList<Direction>();
		if(param == "vide"){
			for (Direction d : Direction.values()){		
				//regarde la case si vide add la liste
				if(x + d.getX() < getWidth() && x + d.getX() >= 0 && y + d.getY() < getHeight() && y + d.getY() >= 0) {
					if( getAgentAtPosition(x + d.getX(), y + d.getY()) == null)
						listeDir.add(d);
				}
			}
		}else if(param == "poisson"){
			for (Direction d : Direction.values()){		
				System.out.println(x + d.getX());
				if(x + d.getX() < getWidth() && x + d.getX() >= 0 && y + d.getY() < getHeight() && y + d.getY() >= 0) {
					if(getAgentAtPosition(x + d.getX(), y + d.getY()) instanceof AgentFish)
						listeDir.add(d);
				}
			}
		}
		return listeDir;
	}
}

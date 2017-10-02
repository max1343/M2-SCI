package wator;

import java.util.ArrayList;

import model.Environment;
import model.Agent.Direction;

public class EnvironmentWator extends Environment {

	public EnvironmentWator(int height, int width) {
		super(height, width);
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Direction> lookAt(String param,int x, int y){
		ArrayList<Direction> listeDir = new ArrayList<Direction>();
		if(param == "vide"){
			for (Direction d : Direction.values()){		
				//regarde la case si vide add la liste
				if(getAgentAtPosition(x, y) == null)
					listeDir.add(d);
			}
		}else if(param == "poisson"){
			for (Direction d : Direction.values()){		
				//regarde la case si vide add la liste
				if(getAgentAtPosition(x, y) instanceof AgentFish)
					listeDir.add(d);
			}
		}
		return listeDir;
	}
}

package particles;
import java.util.ArrayList;

import model.Agent;
import model.Agent.Direction;
import model.Environment;


public class EnvironmentParticles extends Environment {

	public EnvironmentParticles(int height, int width) {
		super(height, width);
	}
	
	public String toString() {
		ArrayList<Agent> ags = getAllAgents();
		return ags.toString();
	}
}

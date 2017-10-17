package pacman;

import java.awt.Color;
import java.util.Random;

import model.Agent;
import model.Environment;

public class AgentBonus extends Agent {
	private int tour, i, place;
	private Random rnd;
	
	public AgentBonus(int posX, int posY, Color c, Environment e, boolean trace, int tour, Random rnd, int place) {
		super(posX, posY, c, e, trace);
		this.tour = tour;
		this.rnd = rnd;
		this.place = place;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void decide() {
		if(i == tour) {
			move(rnd.nextInt(getEnv().height - 1),rnd.nextInt(getEnv().width - 1));
		}else
			i++;
	}

}

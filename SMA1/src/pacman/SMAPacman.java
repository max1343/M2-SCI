package pacman;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import model.SMA;

public class SMAPacman extends SMA{
	private ArrayList<AgentWall> walls;
	private ArrayList<AgentHunter> hunters;
	private AgentAvatar avatar;
	private AgentHunter ah;
	private AgentWall aw;

	private int seed;
	private int posX, posY, nbHunters, nbWalls;

	public SMAPacman(EnvironmentPacman e, boolean trace, String scheduling, int nbTicks,int seed, int nbH, int nbW) {
		super(e, trace, scheduling, nbTicks);
		this.seed = seed;
		this.nbHunters = nbH;
		this.nbWalls = nbW;
	}

	@Override
	public void firstRun() {
		// TODO Auto-generated method stub
		Random rnd = new Random(seed);
		walls = new ArrayList<AgentWall>();
		hunters = new ArrayList<AgentHunter>();
		
		for(int i =1;i<=nbHunters;i++){
			posX = rnd.nextInt(e.height - 1); 
			posY = rnd.nextInt(e.width - 1); 
						
			ah = new AgentHunter(posX,posY,Color.RED,(EnvironmentPacman) getEnvironnement(),trace);
			hunters.add(ah);
			e.setBall(ah);
		}
	
		for(int i =1;i<=nbWalls;i++){	
			posX = rnd.nextInt(e.height - 1); 
			posY = rnd.nextInt(e.width - 1);
			
			aw = new AgentWall(posX,posY, (EnvironmentPacman) getEnvironnement(),trace);
			walls.add(aw);
			e.setBall(aw);
		}
		
		posX = rnd.nextInt(e.height - 1); 
		posY = rnd.nextInt(e.width - 1);
		avatar = new AgentAvatar(posX, posY, Color.blue, e, trace);
		e.setBall(avatar);
		
		run();
	}

}

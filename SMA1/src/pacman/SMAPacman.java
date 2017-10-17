package pacman;

import java.awt.Color;
import java.awt.event.KeyEvent;
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

	public SMAPacman(EnvironmentPacman e, boolean trace, String scheduling, int nbTicks,int seed, int nbH, int nbW, String filename) {
		super(e, trace, scheduling, nbTicks, filename);
		this.seed = seed;
		this.nbHunters = nbH;
		this.nbWalls = nbW;
		avatar = new AgentAvatar(2, 2, Color.BLUE, (EnvironmentPacman) e, true);
		e.setBall(avatar);
	}

	@Override
	public void firstRun() {
		// TODO Auto-generated method stub
		Random rnd = new Random(seed);
		walls = new ArrayList<AgentWall>();
		hunters = new ArrayList<AgentHunter>();
		((EnvironmentPacman) e).initDijkstra(avatar);
		
		posX = rnd.nextInt(e.height - 1);
		posY = rnd.nextInt(e.width - 1);
		e.setBall(avatar);
		//((EnvironmentPacman) e).setAvatar(avatar);
		
		for(int i =1;i<=nbHunters;i++){
			posX = rnd.nextInt(e.height - 1);
			posY = rnd.nextInt(e.width - 1);
			ah = new AgentHunter(posX,posY,Color.RED,(EnvironmentPacman) getEnvironnement(),trace, 2);
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

		for(AgentHunter ah: hunters){
			e.setBall(ah);
		}
		
		AgentBonus ab = new AgentBonus(rnd.nextInt(e.height - 1), rnd.nextInt(e.width - 1), Color.yellow, getEnvironnement(), trace, 10, rnd, 1);
		e.setBall(ab);
		run();
	}

	@Override
	public String doTrace(int idTick) {
			String trace = "Tick" + idTick;
			return trace;
	}

	public AgentAvatar getAvatar() {
		return avatar;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_DOWN : avatar.setPasY(-1);
								avatar.setPasX(0);
								break;
		case KeyEvent.VK_UP	:	avatar.setPasY(1);
						  		avatar.setPasX(0);
						  		break;
						  		
		case KeyEvent.VK_LEFT : avatar.setPasY(0);
								avatar.setPasX(-1);
								break;
								
		case KeyEvent.VK_RIGHT :avatar.setPasY(0);
								avatar.setPasX(1);
								break;
	}
	}
	
	
}

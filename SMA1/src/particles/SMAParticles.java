package particles;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import model.Agent.Direction;
import model.Environment;
import model.SMA;
import wator.AgentFish;
import wator.AgentShark;
import wator.EnvironmentWator;

public class SMAParticles extends SMA{
	private ArrayList<AgentParticles> particules;
	private int nbParticules;
	private int seed;
	private AgentParticles ap;
	private int posX, posY;


	public SMAParticles(Environment e, boolean trace, String scheduling, int nbTicks, int seed, int nbPart, String filename) {
		super(e, trace, scheduling, nbTicks, filename);
		this.nbParticules = nbPart;
		this.seed = seed;
	}

	@Override
	public void firstRun() {
		// TODO Auto-generated method stub
		Random rnd = new Random(seed);
		particules = new ArrayList<AgentParticles>();
		Direction dir;

		for(int i =1;i<=nbParticules;i++){
			posX = rnd.nextInt(e.height - 1);
			posY = rnd.nextInt(e.width - 1);
			dir = Direction.getRandomDir();
			ap = new AgentParticles(posX, posY, dir, Color.gray, e, trace);
			particules.add(ap);
			e.setBall(ap);
		}
		run();
	}

	@Override
	public String doTrace(int idTick) {
		int count = 0;
		for(AgentParticles ag : particules) {
			if(ag.getColor().equals(Color.RED))
				count++;
		}
		String trace = "Tick " + idTick +"\n";
		trace += "Nb Particules collisionnées " + count + "\n";
		return trace;

	}

}

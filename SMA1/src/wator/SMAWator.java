package wator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import model.Agent;
import model.SMA;

public class SMAWator extends SMA{
	private ArrayList<AgentFish> fishes;
	private ArrayList<AgentShark> sharks;
	private AgentFish af;
	private AgentShark as;
	private int nbFish, nbShark, fishBreedTime, sharkBreedTime, sharkStarveTime;
	private int seed;
	private int posX, posY;
	private int cpf = 0, cps = 0;

	public SMAWator(EnvironmentWator e, boolean trace, String scheduling, int nbTicks, int seed, int nbFish, int nbShark, int fishBreedTime, int sharkBreedTime, int sharkStarveTime, String filename) {
		super(e, trace, scheduling, nbTicks, filename);
		this.nbFish = nbFish;
		this.nbShark = nbShark;
		this.fishBreedTime = fishBreedTime;
		this.sharkBreedTime = sharkBreedTime;
		this.sharkStarveTime = sharkStarveTime;
		this.seed = seed;
	}

	@Override
	public void firstRun() {
		Random rnd = new Random(seed);
		fishes = new ArrayList<AgentFish>();
		sharks = new ArrayList<AgentShark>();

		for(int i =1;i<=nbFish;i++){
			posX = rnd.nextInt(e.height - 1);
			posY = rnd.nextInt(e.width - 1);

			af = new AgentFish(posX,posY,fishBreedTime,Color.BLUE,(EnvironmentWator) getEnvironnement(), trace);
			fishes.add(af);
			e.setBall(af);
		}

		for(int i =1;i<=nbShark;i++){
			posX = rnd.nextInt(e.height - 1);
			posY = rnd.nextInt(e.width - 1);

			as = new AgentShark(posX,posY,sharkBreedTime,Color.RED,sharkStarveTime,trace, (EnvironmentWator) getEnvironnement());
			sharks.add(as);
			e.setBall(as);
		}

		run();

	}

	@Override
	public String doTrace(int idTick) {
		System.out.println("Tick" + idTick);
		return "";
	}
}

package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

import org.omg.CORBA.SetOverrideType;

import particles.AgentParticles;
import wator.AgentFish;
import wator.AgentShark;
import wator.SMAWator;

public abstract class SMA extends Observable {

	private ArrayList<Agent> agents;
	protected Environment e;
	public static int FPS = 1;
	public int nbTicks;
	public String scheduling;
	public boolean trace;
	private int idTick;
	private int rand, nb;
	private String type;
	protected String exportTrace;

	public SMA(Environment e, boolean trace, String scheduling, int nbTicks){
		this.e = e;
		this.trace = trace;
		this.idTick = 1;
		this.scheduling = scheduling;
		this.nbTicks = nbTicks;
	}

	public void schedule() throws InterruptedException{
		rand = 0;
		agents = e.getAllBall();
		nb = agents.size();
		if(scheduling.equals("sequentiel")){
			for(Agent ag : agents){
				ag.decide();
			}
		}
		else if(scheduling.equals("aleatoire")){
				for(int i = nb; i>0; i--){
					rand = (int) Math.round(Math.random()*(nb-1));
					agents.get(rand).decide();
				}
		}
		else{
			Collections.shuffle(agents);
			for(Agent ag : agents){
				ag.decide();
			}
		}
	}

	public void run(){
		agents = new ArrayList<Agent>();
			while(idTick != nbTicks)
				try {
					schedule();
					setChanged();
					notifyObservers("env");
					if(this.trace)
							doTrace(idTick);
					idTick++;
					Thread.sleep(200 *FPS);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

	}

	public abstract void firstRun();

	public Environment getEnvironnement() {
		return this.e;
	}

	public abstract void doTrace(int idTick);

	public void setType(String type){
		this.type = type;
	}

	public void setTrace(String exportTrace) {
		this.exportTrace = exportTrace;
	}

	public String getTrace() {
		return this.exportTrace;
	}


}

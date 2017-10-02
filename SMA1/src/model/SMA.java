package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

public abstract class SMA extends Observable {

	private ArrayList<Agent> agents;
	protected Environment e;
	public static int FPS;
	public int nbTicks;
	public String scheduling;
	public boolean trace;
	private int idTick;
	private int rand, nb;
	
	public SMA(Environment e, boolean trace, String scheduling, int nbTicks){
		this.e = e;
		this.trace = trace;
		this.idTick = 0;
		this.scheduling = scheduling;
		this.nbTicks = nbTicks;
	}
	
	public void schedule(){
		rand = 0;
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
		if(nbTicks == 0)
			while(true)
				try {
					idTick++;
					if(this.trace)
						System.out.println("Tick" + idTick);
					agents = e.getAllBall();
					schedule();
					setChanged();
					notifyObservers(e);
					Thread.sleep(200 *FPS);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}	
		else
			for(int i = nbTicks +1 ; i>0; i--){	
				try {
					agents = e.getAllBall();
						schedule();
						setChanged();
						notifyObservers(e);
						Thread.sleep(500 * FPS);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		
			}				
	}	
	
	public abstract void firstRun();
	
	public Environment getEnvironnement() {
		return this.e;
	}
}

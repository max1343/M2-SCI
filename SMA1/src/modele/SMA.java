package modele;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Random;

import particules.AgentParticule;

public class SMA extends Observable {
	private ArrayList<Agent> agents;
	private Observable e;
	public static int FPS;
	public int nbTicks;
	public String scheduling;
	public boolean trace;
	private int idTick;
	

	public boolean getTrace() {
		return trace;
	}

	public void setTrace(boolean trace) {
		this.trace = trace;
	}

	public SMA(ArrayList<Agent> agents, Observable e, boolean trace){
		this.agents = agents;
		this.e = e;
		this.trace = trace;
		this.idTick = 0;
	}

	public void schedule(){
		int rand = 0,nb = agents.size();
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
		if(nbTicks == 0)
			while(true)
				try {
					idTick++;
					if(this.trace)
						System.out.println("Tick" + idTick);
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

	public String getScheduling() {
		return scheduling;
	}

	public void setScheduling(String scheduling) {
		this.scheduling = scheduling;
	}

}

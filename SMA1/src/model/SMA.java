package model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

public abstract class SMA extends Observable implements KeyListener{

	protected ArrayList<Agent> agents;
	protected Environment e;
	public static int FPS = 1;
	public int nbTicks;
	public String scheduling;
	public boolean trace;
	private int idTick;
	private int rand, nb;
	private String sTrace;
	protected Exporter export;


	public SMA(Environment e, boolean trace, String scheduling, int nbTicks, String filename){
		this.e = e;
		this.trace = trace;
		this.idTick = 1;
		this.scheduling = scheduling;
		this.nbTicks = nbTicks;
		this.export = new Exporter(filename);
		agents = new ArrayList<Agent>();

	}

	public void schedule() throws InterruptedException{
		rand = 0;
		agents = e.getAllAgents();
		nb = agents.size();
		
		if(scheduling.equals("sequentiel")){
			for(Agent ag : agents){
				//if(!(ag instanceof AgentNull))walls
						ag.decide();
			}
		}
		else if(scheduling.equals("aleatoire")){
				for(int i = nb; i>0; i--){
					rand = (int) Math.round(Math.random()*(nb-1));
					//if(!(agents.get(rand) instanceof AgentNull))
						agents.get(rand).decide();
				}
		}
		else{
			Collections.shuffle(agents);
			for(Agent ag : agents){
				//if(!(ag instanceof AgentNull))
					ag.decide();
			}
		}
	}

	public void run(){
			while(idTick != nbTicks)
				try {
					schedule();
					setChanged();
					notifyObservers("env");
					if(this.trace) {
							sTrace = doTrace(idTick);
							export.writeOnFile(sTrace);
					}
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

	public abstract String doTrace(int idTick);


	public void setTrace(String sTrace) {
		this.sTrace = sTrace;
	}

	public String getTrace() {
		return this.sTrace;
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void keyReleased(KeyEvent e) {
			
	}


}

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
		this.idTick = 0;
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
		if(nbTicks == 0)
			while(true)
				try {
					idTick++;
					if(this.trace)
						System.out.println("Tick" + idTick);
					schedule();
					setChanged();
					notifyObservers("env");
					Thread.sleep(200 *FPS);
					ArrayList<Agent> la = e.getAllBall();
					int cpf = 0;
					int cps = 0;
					int cpp = 0;
					for( Agent a : la){
						if(a instanceof AgentFish)
							cpf++;
						if(a instanceof AgentShark)
							cps++;
						if(a instanceof AgentParticles)
							if(a.couleur == Color.gray)
								cpp++;
					}
					if(this.trace){
						if(this.type.equals("fishes")){
							System.out.println("nb requin : "+cps);
							System.out.println("nb poisson : "+cpf);
						}
						if(this.type.equals("particules"))
							System.out.println("particules non collisionées : "+cpp);
					}
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
						Thread.sleep(200 * FPS);
						ArrayList<Agent> la = e.getAllBall();
						int cpf = 0;
						int cps = 0;
						int cpp = 0;
						for( Agent a : la){
							if(a instanceof AgentFish){
								cpf++;
							}
							if(a instanceof AgentShark)
								cps++;
							if(a instanceof AgentParticles){
								if(a.couleur == Color.gray)
									cpp++;
							}
						}
						if(trace){
							System.out.println("Tick" + (nbTicks - i+1));
							if(this.type.equals("fishes")){
								System.out.println("nb requin : "+cps);
								System.out.println("nb poisson : "+cpf);
							}
							if(this.type.equals("particules"))
								System.out.println("particules non collisionnées : "+cpp);
						}
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
	
	public abstract void doTrace();
	
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

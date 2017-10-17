package pacman;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JTextField;

import model.Agent;
import model.Position;

public class AgentAvatar extends Agent {
	private int pasX, pasY;
	private JTextField textField;  
	private int bonus;
	private Random rnd;
	int nbBonus;

	
	public AgentAvatar(int posX, int posY, Color c, EnvironmentPacman e, boolean trace, Random rnd, int nbBonus) {
		super(posX, posY, c, e, trace);
		this.setPasX(0);
		this.setPasY(0);
		this.rnd = rnd;
		this.nbBonus = nbBonus;
		bonus = 0;
	}

	
	public void setPathDijkstra(EnvironmentPacman e, ArrayList<Position> l){
		for(int i=0; i<e.getHeight(); i++){
			for(int j=0; j<e.getWidth(); j++){
				
			}
		}
		
	    int xc = this.posX;
	    int yc = this.posY;
	    int dist = 0;
	    Position p = new Position(xc, yc, dist);
		do{
		    xc=p.getX();
		    yc = p.getY();	
		    dist = p.getValeur(); 
		    //on ajoute les 4 voisins à la liste
		    ajoutListe(e,xc,yc,dist,l);
		    p = l.get(0); 
		    l.remove(0);
		}while(l.size() != 0);
	}

    public void ajoutListe(EnvironmentPacman e, int posX, int posY,int val, ArrayList<Position> l){
    	Position p;
		if(posValide(posX-1,posY,e)){
			p = new Position(posX-1, posY, val+1);	
		    l.add(p);
		}
		if(posValide(posX,posY-1,e)){
			p = new Position(posX,posY-1, val+1);
		    l.add(p);
	    }
	    if(posValide(posX+1,posY,e)){
	    	p = new Position(posX+1,posY,val+1);
		    l.add(p);
	    }
	    if(posValide(posX,posY+1,e)){
	    	p = new Position(posX,posY+1,val + 1);
	    	l.add(p);
	    }
    }

    public boolean posValide(int x,int y, EnvironmentPacman e){
    	if(x>0 && x<e.width && y>0 && y<e.height )
    		return true;
    	return false;
    }
	    
	

	@Override
	public void decide() {
		if(!gameFinished) {
			int x,y;
		
			x = ((getPosX() + pasX) % env.width);
			y = ((getPosY() + pasY) % env.height);
	
			if ((getPosX() + pasX) < 0)
				x = env.width - 1;
			if ((getPosY() + pasY) < 0)
				y = env.height - 1;
			
			if(env.getAgentAtPosition(x, y) instanceof AgentBonus) {
				eatBonus(env.getAgentAtPosition(x, y));
			}
			
			if(env.getAgentAtPosition(x, y) instanceof AgentFin) {
				eatFin(env.getAgentAtPosition(x, y));
			}
			
			if(!env.hasAgentAtPosition(x,y)) {
				move(pasX, pasY);
				((EnvironmentPacman) env).initDijkstra(this);
			}
		}
		//setPathDijkstra((EnvironmentPacman) this.getEnv(),new ArrayList<Position>());
	}
	
	public void eatBonus(Agent a) {
		env.deleteBall(a);
		bonus++;
		if(bonus < nbBonus){
			AgentBonus ab = new AgentBonus(rnd.nextInt(env.height - 1), rnd.nextInt(env.width - 1), Color.yellow, env, trace, 10, rnd);
		}else if(bonus == nbBonus) {
			AgentFin af = new AgentFin(rnd.nextInt(env.height - 1), rnd.nextInt(env.width - 1), Color.pink, env, trace);
		}
	}
	
	public void eatFin(Agent a) {
		env.deleteBall(a);
		env.sendFinish();
	}

	public int getPasX() {
		return pasX;
	}

	public void setPasX(int pasX) {
		this.pasX = pasX;
	}

	public int getPasY() {
		return pasY;
	}

	public void setPasY(int pasY) {
		this.pasY = pasY;
	}
	
	public void setDirection(Direction dir) {
		
	}

}

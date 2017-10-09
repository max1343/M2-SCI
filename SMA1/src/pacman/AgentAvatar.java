package pacman;

import java.awt.Color;
import java.awt.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import model.Agent;
import model.Environment;
import model.Position;

public class AgentAvatar extends Agent implements KeyListener {
	private int pasX, pasY;
	
	public AgentAvatar(int posX, int posY, Color c, Environment e, boolean trace) {
		super(posX, posY, c, e, trace);
		this.setPasX(0);
		this.setPasY(0);
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
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
			case KeyEvent.VK_DOWN : setPasY(-1);
									setPasX(0);
									break;
			case KeyEvent.VK_UP	:	setPasY(1);
							  		setPasX(0);
							  		break;
							  		
			case KeyEvent.VK_LEFT : setPasY(0);
									setPasX(-1);
									break;
									
			case KeyEvent.VK_RIGHT :setPasY(0);
									setPasX(1);
									break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		setPasY(0);
		setPasX(0);		
	}

	@Override
	public void decide() {
		move(pasX, pasY);
		//setPathDijkstra((EnvironmentPacman) this.getEnv(),new ArrayList<Position>());
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

}

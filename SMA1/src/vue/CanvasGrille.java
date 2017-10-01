package vue;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import modele.Agent;
import modele.Environnement;
import particules.AgentParticule;

public class CanvasGrille extends Canvas implements Observer{
	private Environnement e;
	private ArrayList<Agent> listeAgents;
	public boolean grid;
	public int cSizeX, cSizeY;
	
	public CanvasGrille(Environnement env){
		this.e = env;
		this.setSize(cSizeX, cSizeY);
	}
	
	
	public void paint(Graphics g){
		g.setColor(Color.BLACK);
		
		if(this.grid == true){
			int x1 = this.getWidth()/e.height;
			int y1 = this.getHeight()/e.width;        
			for (int x= x1; x<this.getWidth(); x+=x1){
				g.drawLine(x, 0, x, this.getHeight());
			}
	    
		    for (int y= y1; y<this.getHeight(); y+=y1){
		    	g.drawLine(0, y, this.getWidth(),y);
		    }
		    
		}
		
		
		int tailleCaseX = this.cSizeX / e.height;
		int tailleCaseY = this.cSizeY / e.width;

		
		listeAgents = e.getAllBall();
		int posX, posY;
		for(Agent ag : listeAgents){
			posX = ag.getPosX()*getWidth()/e.height;
			posY = ag.getPosY()*getHeight()/e.width;
			g.setColor(ag.getColor());
			g.fillOval(posX, posY, tailleCaseX, tailleCaseY);
		}
	}

	

	@Override
	public void update(Observable o, Object arg) {
		this.setEnv((Environnement) arg);
		repaint();
	}
	
	
	public void setEnv(Environnement e){
		this.e = e;
		
	}


	public void setCSizeX(int parseInt) {
		this.cSizeX = parseInt;
	}
	
	public void setCSizeY(int parseInt) {
		this.cSizeY = parseInt;
	}
}

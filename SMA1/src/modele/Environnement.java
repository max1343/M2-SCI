package modele;
import java.util.ArrayList;


import java.util.Observable;
import java.util.Observer;

import particules.Particule; 

public class Environnement extends Observable {
	public int gridSizeX, gridSizeY;
	Particule[][] agents;
	public boolean torique;
	
	public Environnement(int gridSizeX2, int gridSizeY2) {
		this.gridSizeX = gridSizeX2;
		this.gridSizeY = gridSizeY2;
		agents = new Particule[gridSizeX][gridSizeY];
	}

	public boolean hasBallAtPosition(int x, int y){
		return agents[x][y] != null;
	}
	
	public Particule getBallAtPosition(int x, int y){
		return agents[x][y];
	}
	
	public void setBall(Particule a){
		agents[a.getPosX()][a.getPosY()] = a;
	}
	
	public void deleteBall(Particule a){
		agents[a.getPosX()][a.getPosY()] = null;
	}

	public ArrayList<Particule> getAllBall() {
		ArrayList<Particule> liste = new ArrayList<Particule>();
		for(int i = 0; i<gridSizeX; i++){
			for(int j=0; j<gridSizeY; j++){
				if(agents[i][j] != null){
					liste.add(agents[i][j]);
				}		
			}
		}
		return liste;
	}

	public void setTorique(boolean tor){
		this.torique = tor;
	}
	
	
}
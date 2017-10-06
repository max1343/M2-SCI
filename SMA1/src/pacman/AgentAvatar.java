package pacman;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Agent;
import model.Environment;

public class AgentAvatar extends Agent implements KeyListener {
	private int pasX, pasY;
	
	public AgentAvatar(int posX, int posY, Color c, Environment e, boolean trace) {
		super(posX, posY, c, e, trace);
		this.setPasX(0);
		this.setPasY(0);
	}

	public void setPathDijkstra(EnvironmentPacman e){
		int x = e.width;
		int y = e.height;
		
		
		
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

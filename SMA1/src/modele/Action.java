package modele;

public abstract class Action {

	public void move(int x, int y, Agent a){
		Environnement env = a.getEnv();
		if ((a.getPosX() + x) < 0)
			x = env.width - 1;
		if ((a.getPosY() + y) < 0)
			y = env.height - 1;
				
		a.getEnv().deleteBall(a);
		a.setPosX((a.getPosX() + x) % env.width);
		a.setPosY((a.getPosY() + y) % env.height);
		a.getEnv().setBall(a);
	}
	
	public void eat(int x, int y, Agent a){
		a.getEnv().deleteBall(a.getEnv().getAgentAtPosition(a.posX + x, a.posY + y));
		move(x, y , a);
	}
	
	
}

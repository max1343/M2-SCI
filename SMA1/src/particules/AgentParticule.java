package particules;

import java.awt.Color;
import java.util.Random;

import modele.Agent;
import modele.Environnement;

public class AgentParticule extends Agent{
	private int  pasX, pasY;
	private Environnement env;
	public boolean trace;
	
	public AgentParticule(Environnement env, int seed, boolean trace){
		super(0,0,Color.gray,env,trace);
		int eX = env.height;
		int eY = env.width;
		this.trace = trace;
		
		Random rnd = new Random(seed);
		
		this.posX = rnd.nextInt(eX - 1); 
		this.posY = rnd.nextInt(eY - 1); 
		this.pasX = rnd.nextInt(2) - 1; 
		this.pasY = rnd.nextInt(2) - 1; 
		this.env = env;
	}
	

	public void decide(){
		int regardX, regardY;
		regardX = posX + pasX;
		regardY = posY + pasY;
		
		if(regardX < 0 || regardX >= env.height){
			if(regardY < 0 || regardY >= env.width){
				actionAngle();
			}
			else
				action3();
		}
		else{
			if(regardY < 0 || regardY >= env.width){
				if(regardX < 0 || regardX >= env.width){
					actionAngle();	

				}
				action4();
			}
			else{
				if(env.hasAgentAtPosition(regardX, regardY)){
					action1((AgentParticule) env.getAgentAtPosition(regardX, regardY));
				}
				else
					action2();
			}
		}
		if(trace)
			System.out.println("Agent couleur: " + super.couleur);
	}
	
	
	public void action1(AgentParticule a){
		int pasXi = pasX;
		int pasYi = pasY;
		pasX = a.getPasX();
		a.setPasX(pasXi);
		pasY = a.getPasY();
		a.setPasY(pasYi);
		a.couleur = Color.red;
		this.couleur = Color.red;
		//System.out.println("collision");
	}
	
	public void action2(){
		env.deleteBall(this);
		posX += pasX;
		posY += pasY;
		env.setBall(this);
		//System.out.println("bougé");
	}
	
	public void action3(){
		if(!env.torique){
			pasX *= -1;
			//System.out.println("collision mur");
		}
		else{
			if(posX + pasX > (env.height-1)){
				env.deleteBall(this);
				posX = 0;
				posY += pasY;
				env.setBall(this);
			//	System.out.println("bougé");
			}
			if(posX + pasX < 0){
				env.deleteBall(this);
				posX = env.height -1;
				posY += pasY;
				env.setBall(this);
			//	System.out.println("bougé");
			}
		}
	}
	
	public void action4(){
		if(!env.torique){
			pasY *= -1;
			//System.out.println("collision mur");
		}
		else{
			if(posY + pasY > (env.width-1)){
				env.deleteBall(this);
				posY = 0;
				posX += pasX;
				env.setBall(this);
			//	System.out.println("bougé");
			}
			if(posY + pasY < 0){
				env.deleteBall(this);
				posY = env.width -1;
				posX += pasX;
				env.setBall(this);
			//	System.out.println("bougé");
			}
		}
	}
	
	public void actionAngle(){
		if(!env.torique){
			pasY *= -1;
			pasX *= -1;
		//	System.out.println("collision mur");
		}
		else{
			env.deleteBall(this);
			if(posY == 0 && posX == 0){
				posY = env.width - 1;
				posX = env.height - 1;
			}
			if(posX == 0 && posY == (env.width-1)){
				posY = 0;
				posX = env.height-1;
			}
			if(posX == (env.height - 1) && posY == (env.width-1)){
				posY = 0;
				posX = 0;
			}
			if(posX == (env.height - 1) && posY == 0){
				posY = env.width-1;
				posX = 0;
			}
			env.setBall(this);
		//	System.out.println("bouge angle");
		}
	}
	

	
	public int getPasX(){
		return this.pasX;
			
		
	}
	
	public void setPasX(int nPas){
		this.pasX = nPas;
	}
	
	public int getPasY(){
		return this.pasY;
	}
	
	public void setPasY(int nPas){
		this.pasY = nPas;
	}
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	
}
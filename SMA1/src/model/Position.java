package model;

public class Position {
	private int x;
	private int y;
	private int valeur;
	
	public Position(int x, int y, int val) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.valeur = val;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
}

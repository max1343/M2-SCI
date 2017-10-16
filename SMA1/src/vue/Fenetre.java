package vue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame{
	
	public Fenetre(CanvasGrille c){
		this.setTitle("vue");
		this.setSize(c.cSizeX, c.cSizeY);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setFocusable(true);
		this.add(c);
	    this.setVisible(true);
	
	}
	

		
}

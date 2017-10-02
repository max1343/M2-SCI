package vue;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;

public class Fenetre extends JFrame{
	
	public Fenetre(CanvasGrille c){
		this.setTitle("vue");
		this.setSize(c.cSizeX, c.cSizeY);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	    this.add(c); 
	    		
	    this.setVisible(true);
	
	}
	
	
		
}

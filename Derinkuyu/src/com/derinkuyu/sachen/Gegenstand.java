package com.derinkuyu.sachen;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

import com.derinkuyu.organisation.Kram;

public class Gegenstand extends JLabel implements Kram{

	private String name;
	private Point pos;
	//private int posX;
	//private int posY;
	private int hoehe;
	private int breite;
	//private String imageAktiv;
	//private String imageInAktiv;
	private BufferedImage imageAktiv;
	private BufferedImage imageInAktiv;
	
	public Gegenstand(String name, Point pos, int hoehe, int breite ,String imageAktiv, String imageInAktiv) {
		this.name = name;
		this.pos = pos;
		this.hoehe = hoehe;
		this.breite = breite;
		try {
			this.imageAktiv = ImageIO.read(new File(imageAktiv));
			this.imageInAktiv = ImageIO.read(new File(imageInAktiv));
		} catch (IOException e) {
			e.printStackTrace();
			this.imageAktiv = null;
			this.imageInAktiv = null;
			System.out.println("IOException: " + imageAktiv + ", " + imageInAktiv); 
		}
	}
	
	public void test() {
		//pos.
	}

	@Override
	public void blinken() {
		// TODO Auto-generated method stub
		
	}
}

//public Gegenstand(int width, int height, String Path) throws IOException {	//TYPE_INT_ARGB	/int width, int height, int imageType
//	//BufferedImage image = ImageIO.read(new File(Path));
//	super(width, height, ImageIO.read(new File(Path)).getType());
//	// TODO Auto-generated constructor stub
//}
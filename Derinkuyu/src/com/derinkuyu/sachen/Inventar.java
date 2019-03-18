package com.derinkuyu.sachen;

import java.awt.Point;

public class Inventar {
	//private List<Gegenstand> gegenstande;
	Gegenstand[] gegenstande = new Gegenstand[5];; 
	String image;
	Point pos;
	Point posGegenstand1;
	Point posGegenstand2;
	Point posGegenstand3;
	Point posGegenstand4;
	Point posGegenstand5;
	
	public Inventar(String image, Point pos, Point posGegenstand1, Point posGegenstand2,
			Point posGegenstand3, Point posGegenstand4, Point posGegenstand5) {
		this.image = image;
		this.pos = pos;
		this.posGegenstand1 = posGegenstand1;
		this.posGegenstand2 = posGegenstand2;
		this.posGegenstand3 = posGegenstand3;
		this.posGegenstand4 = posGegenstand4;
		this.posGegenstand5 = posGegenstand5;
	}
	
	public boolean addGegenstand(Gegenstand newGegenstand) {
		for(int i = 0 ; i < 5 ; i++) {
			if(gegenstande[i] == null) {
				gegenstande[i] = newGegenstand;
				return true;
			}
		}
		return false;
	}

}

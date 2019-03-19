package com.derinkuyu.start;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	
	@Override
	public void paintComponent(Graphics myGraphics) {
		super.paintComponent(myGraphics);  
	}

}

//Point initialClick;
//public MyPanel() {
//	addMouseListener(new MouseAdapter(){
//		public void mousePressed(MouseEvent e){
//			initialClick = e.getPoint();
//		}
//	});
//}
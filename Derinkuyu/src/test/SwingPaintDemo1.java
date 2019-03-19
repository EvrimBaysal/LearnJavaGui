package test;


import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.event.MouseMotionAdapter;
import java.awt.Toolkit;
import java.awt.Point;

public class SwingPaintDemo1 {
    
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }

    private static void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+
        SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.add(new MyPanel());
        f.setSize(250,250);
        f.setVisible(true);
    } 

}

class MyPanel extends JPanel {

    RedSquare redSquare = new RedSquare();
    Point initialClick;

    public MyPanel() {

        setBorder(BorderFactory.createLineBorder(Color.black));

        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
            	initialClick = e.getPoint();
//                final int CURR_X = redSquare.getX();
//                final int CURR_Y = redSquare.getY();
//                final int CURR_W = redSquare.getWidth();
//                final int CURR_H = redSquare.getHeight();
//            	if( (e.getX() >= CURR_X && e.getX() <= (CURR_X + CURR_W) && e.getY() >= CURR_Y && e.getY() <= (CURR_Y + CURR_H))){
//            		moveSquare(e.getX(),e.getY());
//            	}
            	moveSquare(e.getX(),e.getY());
            }
        });

        addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e){
               // moveSquare(e.getX(),e.getY());
            }
        });
        
//        JButton button = new JButton();
//        Icon icon1 = new ImageIcon( "../PaintDemo1/src/69886.jpg" );
//        button.setIcon( icon1 );
//        button.setSize(500, 500);
//        this.add(button);
//        Icon icon1 = new ImageIcon( "../PaintDemo1/src/69886.jpg" );
//        JLabel myLabel = new JLabel(icon1);
//        myLabel.setSize(100, 100);
//        myLabel.setVisible(true);
//        this.add(myLabel);
    }
    
//    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {                                     
//        initialClick = evt.getPoint();
//  }  
//
//
//
//
//
//   private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {                                     
//
//      int thisX = jLabel1.getLocation().x;
//      int thisY = jLabel1.getLocation().y;
//
//      // Determine how much the mouse moved since the initial click
//      int xMoved = (thisX + evt.getX()) - (thisX + initialClick.x);
//      int yMoved = (thisY + evt.getY()) - (thisY + initialClick.y);
//
//      // Move picture to this position
//      int X = thisX + xMoved;
//      int Y = thisY + yMoved;
//
//      jLabel1.setLocation(X, Y);
//      jLabel1.repaint();
//
//
//  } 

    private void moveSquare(int x, int y){

        // Current square state, stored as final variables 
        // to avoid repeat invocations of the same methods.
        final int CURR_X = redSquare.getX();
        final int CURR_Y = redSquare.getY();
        final int CURR_W = redSquare.getWidth();
        final int CURR_H = redSquare.getHeight();
        final int OFFSET = 1;

        if (((CURR_X!=x) || (CURR_Y!=y))  ) {

            // The square is moving, repaint background 
            // over the old square location. 
            repaint(CURR_X,CURR_Y,CURR_W+OFFSET,CURR_H+OFFSET);

            int xMoved = (CURR_X + x) - (CURR_X + initialClick.x);
          	int yMoved = (CURR_Y + y) - (CURR_Y + initialClick.y);
            // Update coordinates.
            redSquare.setX(x + xMoved);
            redSquare.setY(y + yMoved);

            // Repaint the square at the new location.
            repaint(redSquare.getX(), redSquare.getY(), 
                    redSquare.getWidth()+OFFSET, 
                    redSquare.getHeight()+OFFSET);
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(250,200);
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);       
        BufferedImage image;
        BufferedImage imageIcon1; //= new BufferedImage(20,20,BufferedImage.TYPE_INT_ARGB);
        BufferedImage resized;
        //ImageIO.read(new File(Path)).getType()
        //String path = "../PaintDemo1/src/69886.jpg";
        //URL imgURL = getClass().getResource(path);
        //ImageIcon icon = new ImageIcon(path); 
        //File directory = new File("./");
        //System.out.println(directory.getAbsolutePath());
        try {
			image = ImageIO.read(new File("../PaintDemo1/src/room.jpg"));
			imageIcon1 = ImageIO.read(new File("../PaintDemo1/src/69886.png"));
			resized = new BufferedImage(100, 100, imageIcon1.getType());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			image = null;
			imageIcon1 = null;
			resized = null;
		}
        g.drawImage(image, 0, 0, this);
        //g.drawImage(imageIcon1, 0, 0, this);
        //g.drawImage(resized, 0, 0, this);
        g.drawImage(imageIcon1, 0, 0, 100, 100, 0, 0, imageIcon1.getWidth(), imageIcon1.getHeight(), null);
        //g.drawImage(icon, 0, 0, this);
        g.drawString("This is my custom Panel!",10,20);
        redSquare.paintSquare(g);
    }  
}

class RedSquare{

    private int xPos = 50;
    private int yPos = 50;
    private int width = 20;
    private int height = 20;

    public void setX(int xPos){ 
        this.xPos = xPos;
    }

    public int getX(){
        return xPos;
    }

    public void setY(int yPos){
        this.yPos = yPos;
    }

    public int getY(){
        return yPos;
    }

    public int getWidth(){
        return width;
    } 

    public int getHeight(){
        return height;
    }

    public void paintSquare(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(xPos,yPos,width,height);
        g.setColor(Color.BLACK);
        g.drawRect(xPos,yPos,width,height);  
    }
}
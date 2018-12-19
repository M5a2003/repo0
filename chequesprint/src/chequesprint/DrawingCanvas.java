
package chequesprint;

import java.awt.BasicStroke;
import  java.awt.Color; 
import java.awt.Font; 
import java.awt.FontMetrics;
import  java.awt.Graphics; 
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import javax.swing.JLabel;

import javax.swing.JPanel;


public class DrawingCanvas extends JLabel { 

	Font font = new Font( java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString("ARIAL BOLD"), Font.BOLD, 11);
	FontMetrics fontMetrics = getFontMetrics(font);
         String myMessage = java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString("A/C PAYEE ONLY");
         
         
	 public DrawingCanvas() { 
		//setSize(300, 300);
               //setLocation(100,200);
                //setBounds(20,20,92,85);
                //this.setText(myMessage);
                this.setFont(font);
                this.setForeground(Color.blue);
                //this.at.rotate(Math.toRadians(45),50,100);
               //FontMetrics fontMetrics = getFontMetrics(font);
		//String myMessage ="A/C PAYEE ONLY2222";
		//fontMetrics = getFontMetrics(font);
                
         }
         
         
 AffineTransform at= new AffineTransform();
 Rectangle rect = new Rectangle(100,100,100,100); 
 /*
public void paintComponent(Graphics g) {
    
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                
                 int w = getSize().width;
                 int ww= this.getWidth();
                 int hh= this.getHeight();
                 int h = getSize().height;
                 
                 int x = (int)rect.getCenterX();
                 int y = (int)rect.getCenterY();
                 
                
                 //Shape s = at.createTransformedShape(rect);
                 g2d.getTransform();
                 at.setToTranslation(x+50, y+50);
                 //this.setSize(w*2, h*2);
                 //g2d.setPaint(Color.ORANGE);
                 //g2d.setColor(Color.ORANGE);
                 //g2d.setTransform(at);
                  at.rotate(Math.PI/4,ww/2,hh/2);
                  g2d.setTransform(at);
                // g2d.draw(s);
               // g2d.rotate(Math.toRadians(45));
               //g2d.drawString(myMessage, w/2-90, h/2+80);
             // g2d.drawString(myMessage, x, y);
}*/
///*
	public void paint(Graphics g) {
            this.paintComponent(g);
		 Graphics2D g2D = (Graphics2D) g;
		//int w = getSize().width;
		//int h = getSize().height;
                int w = getSize().width;
		int h = getSize().height;
                
		 RenderingHints qualityHints = new RenderingHints
                (RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
                 
		 qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		 g2D.setRenderingHints(qualityHints);

		 AffineTransform at = new AffineTransform();
		 //at.setToTranslation(100, 100); 
		 //at.shear(0.5, 0.0);

		 FontRenderContext frc = new FontRenderContext(at, false, false);
		 TextLayout tl = new TextLayout ( java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString("A/C PAYEE ONLY"), font, frc);
                  // tl.draw(g2D, TOP_ALIGNMENT, TOP_ALIGNMENT);
		 Shape outline = tl.getOutline(at);
                 
                 setBackground(Color.white);
                 //this is the color of the text
                 g2D.setColor(Color.BLACK);
                 g2D.setFont(font);
                 g2D.rotate(Math.toRadians(315), 120, 20);
                  //g2D.rotate(45,w+20,h+20);
                 //g2D.rotate(Math.toRadians(45));
		 //BasicStroke wideStroke = new BasicStroke(2.0f);
		 //g2D.setStroke(wideStroke);
                 //g2D.drawString("55555555555", 250, 200);
                 //at.setToRotation(45);
		 g2D.drawString(java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString("A/C PAYEE ONLY"), 0, 0);//drawString(outline); 
        }
 //*/
}
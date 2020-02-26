//QuadGraphics by Andrea Seguya
import java.awt.Graphics;

import javax.swing.JPanel;

public class GPanel extends JPanel {
	double xmin = -10;
	double xmax = 10;
	double ymin = -10;
	double ymax = 10;
	int width =300; 
	int height=200;
	double xp =0; 
	double yp =0;
	Graphics g;   
	boolean isSkip = false; 
	public void setWindow(double xmin, double ymin, double xmax, double ymax) {
		this.xmin = xmin;
		this.xmax = xmax;
		this.ymin = ymin;
		this.ymax = ymax;
		repaint();
	}
	public void setWidthAndHeight(int width, int height) {
		this.width=width;
		this.height = height;
	}
	public void paint(Graphics gIN) {
		g = gIN;  
		g.clearRect(0, 0, getWidth(), getHeight());
		g.drawLine(xd(-10), yd(0), xd(10), yd(0)); 
		// move(3,4); 
		move(3.0,4); 
		for (double x=-10; x<= 10; x++) { 
			move(x,-.25);
			draw(x,+.25);
		}
		g.drawLine(xd(0), yd(-10), xd(0), yd(10));
		for (double y=-10; y<= 10; y++) {  
			move(-.25,y);
			draw(+.25,y);
		}
		
		skip();  
		for (double x=-10; x<10; x+=.1) {
			double fx = QuadWindow.a*Math.pow(x, 2)+QuadWindow.b*x+QuadWindow.c*x;
			draw(x,fx);
			repaint();
		}
		
		}
		

	
	private void draw(double xw, double yw) {
		if (!isSkip) {
			g.drawLine(xd(xp),yd(yp),xd(xw),yd(yw));
		}
		xp = xw;
		yp = yw;
		isSkip = false;
	}
	private void move(double xw, double yw) { 
		xp = xw;
		yp = yw;
	}

	
	public void move(int xw, int yw) {
		xp=xw; yp=yw;
	}
	public void skip() {
		isSkip = true;  
	}
	
	
	
	private int xd(double xw) { 
		return (int) (((xw-xmin)/(xmax-xmin))*(width -1));
		
	}
	private int yd(double yw) { 
		return (int) ((height-1) - ((yw-ymin)/(ymax-ymin))*(height -1));
		
	}
	
}

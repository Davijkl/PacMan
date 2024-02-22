import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Ambiente extends Rectangle {

	static int SIZE = 100;
	ImageIcon img = new ImageIcon("imgs/sfondo.jpg");
	
	public Ambiente(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = SIZE;
		this.height = SIZE;
	}
	
	public void draw(Graphics g) {
		g.drawImage(img.getImage(), x, y, width,height, null);
	}
}
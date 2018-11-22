package eng;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gragh extends JFrame{

	public Gragh(/*ArrayList Score_list, String subj*/) {
		// TODO Auto-generated constructor stub
		int x[];
		int y[];
		
		class Panel extends JPanel{
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				
				g.drawLine(10, 10, 10, 210);
				g.drawLine(10, 210, 210, 210);
				
			}
		}
		add(new Panel());
		setSize(300,300);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((dim.width/2)-(this.getWidth()/2), (dim.height/2)-(this.getHeight()/2));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new Gragh();
		
	}
	
}

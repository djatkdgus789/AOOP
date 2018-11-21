package eng;

import java.awt.Graphics;
import java.awt.GridLayout;
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
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new Gragh();
		
	}
	
}

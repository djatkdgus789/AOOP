package eng;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gragh extends JFrame{
	int score0_9 = 0;
	int score10_19= 0;
	int score20_29= 0;
	int score30_39= 0;
	int score40_49= 0;
	int score50_59= 0;
	int score60_69= 0;
	int score70_79= 0;
	int score80_89= 0;
	int score90_100= 0;
	
	public Gragh(Subject s){
		// TODO Auto-generated constructor stub
		
		class Panel extends JPanel{
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				
				g.setFont(new Font("",Font.BOLD,10));
				g.drawLine(10, 10, 10, 210);
			 	g.drawLine(10, 210, 210, 210);
				g.drawString("0", 10, 220);
				g.drawString("10", 25, 220);
				g.drawString("20", 45, 220);
				g.drawString("30", 65, 220);
				g.drawString("40", 85, 220);
				g.drawString("50", 105, 220);
				g.drawString("60", 125, 220);
				g.drawString("70", 145, 220);
				g.drawString("80", 165, 220);
				g.drawString("90", 185, 220);
				g.drawString("100",205, 220);

				
				
			}

		}
		add(new Panel());
		setSize(300,300);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((dim.width/2)-(this.getWidth()/2), (dim.height/2)-(this.getHeight()/2));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		for (Score score : Subject.score_list) {
			int temp=score.getMid(s.getName());
			if(temp >= 0 && temp <10) {
				score0_9++;
			}
			else if(temp >= 10 && temp <20) {
				score10_19++;
  			}
			else if(temp >= 20 && temp <30) {
				score20_29++;
			}
			else if(temp >= 30 && temp <40) {
				score30_39++;
			}
			else if(temp >= 40 && temp <50) {
				score40_49++;
			}
			else if(temp >= 50 && temp <60) {
				score50_59++;
			}
			else if(temp >= 60 && temp <70) {
				score60_69++;
			}			
			else if(temp >= 70 && temp <80) {
				score70_79++;
			}
			else if(temp >= 80 && temp <90) {
				score80_89++;
			}
			else if(temp >= 90 && temp <100) {
				score90_100++;
			}
		}
		
	}	
}

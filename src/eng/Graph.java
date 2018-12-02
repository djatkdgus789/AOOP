package eng;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graph {
	public Subject s;
	int i;
	Graph(Subject s, int i) {
		this.s = s;
		this.i = i;
		JFrame frame = new JFrame("성적 그래프 프로그램");
		frame.setLocation(500, 200);
		frame.setPreferredSize(new Dimension(400, 350));
		Container contentPane = frame.getContentPane();

		DrawingPanel drawingPanel = new DrawingPanel(s,i);
		contentPane.add(drawingPanel, BorderLayout.CENTER);
		// 그래프를 그릴 패널

		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// "그래프 그리기" 버튼을 눌렀을때 작동 할 리스터등록
		frame.pack();
		frame.setVisible(true);
	}
}

//그래피를 그리는 패널 클래스

class DrawingPanel extends JPanel {
	Subject s;
	int i;
	DrawingPanel(Subject s, int i){
		this.s=s;
		this.i = i;
	}
	public void paint(Graphics g) {
		int score0_9 = 0;
		int score10_19 = 0;
		int score20_29 = 0;
		int score30_39 = 0;
		int score40_49 = 0;
		int score50_59 = 0;
		int score60_69 = 0;
		int score70_79 = 0;
		int score80_89 = 0;
		int score90_100 = 0;

		switch (i) {
		case 1:
			for (Student std : s.std_list) {
				int temp=std.getScore().getMid();
				System.out.println("temp "+temp);
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
				else if(temp >= 90 && temp <=100) {
					score90_100++;
				}
			}
			break;
		case 2:
			for (Student std : s.std_list) {
				int temp=std.getScore().getLast();
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
				else if(temp >= 90 && temp <=100) {
					score90_100++;
				}
			}
			break;
		case 3:
			for (Student std : s.std_list) {
				int temp=std.getScore().getQuiz();
				if(temp >= 0 && temp <1) {
					score0_9++;
				}
				else if(temp >= 1 && temp <2) {
					score10_19++;
				}
				else if(temp >= 2 && temp <3) {
					score20_29++;
				}
				else if(temp >= 3 && temp <4) {
					score30_39++;
				}
				else if(temp >= 4 && temp <5) {
					score40_49++;
				}
				else if(temp >= 5 && temp <6) {
					score50_59++;
				}
				else if(temp >= 6 && temp <7) {
					score60_69++;
				}			
				else if(temp >= 7 && temp <8) {
					score70_79++;
				}
				else if(temp >= 8 && temp <9) {
					score80_89++;
				}
				else if(temp >= 9 && temp <=10) {
					score90_100++;
				}
			}
			break;
		case 4:
			for (Student std : s.std_list) {
				int temp=std.getScore().getPresentation();
				if(temp >= 0 && temp <1) {
					score0_9++;
				}
				else if(temp >= 1 && temp <2) {
					score10_19++;
				}
				else if(temp >= 2 && temp <3) {
					score20_29++;
				}
				else if(temp >= 3 && temp <4) {
					score30_39++;
				}
				else if(temp >= 4 && temp <5) {
					score40_49++;
				}
				else if(temp >= 5 && temp <6) {
					score50_59++;
				}
				else if(temp >= 6 && temp <7) {
					score60_69++;
				}			
				else if(temp >= 7 && temp <8) {
					score70_79++;
				}
				else if(temp >= 8 && temp <9) {
					score80_89++;
				}
				else if(temp >= 9 && temp <=10) {
					score90_100++;
				}
			}
			break;

		case 5:
			for (Student std : s.std_list) {
				int temp=std.getScore().getReport();
				if(temp >= 0 && temp <1) {
					score0_9++;
				}
				else if(temp >= 1 && temp <2) {
					score10_19++;
				}
				else if(temp >= 2 && temp <3) {
					score20_29++;
				}
				else if(temp >= 3 && temp <4) {
					score30_39++;
				}
				else if(temp >= 4 && temp <5) {
					score40_49++;
				}
				else if(temp >= 5 && temp <6) {
					score50_59++;
				}
				else if(temp >= 6 && temp <7) {
					score60_69++;
				}			
				else if(temp >= 7 && temp <8) {
					score70_79++;
				}
				else if(temp >= 8 && temp <9) {
					score80_89++;
				}
				else if(temp >= 9 && temp <=10) {
					score90_100++;
				}
			}
			break;

		}
	//	System.out.print(score0_9+"^"+score10_19+"^"+score20_29+"^"+score30_39+"^"+score40_49+"^"+score50_59+"^"+
	//			score60_69+"^"+score70_79+"^"+score80_89+"^"+score90_100);
		g.clearRect(0, 0, getWidth(), getHeight());
		g.drawLine(50, 250, 350, 250);
		g.drawLine(50, 20, 50, 250);

		for (int cnt = 1; cnt < 11; cnt++) {
			g.drawString(cnt + "", 25, 255 - 20 * cnt);
			g.drawLine(50, 250 - 20 * cnt, 350, 250 - 20 * cnt);
		}
		for (int cnt = 1; cnt < 11; cnt++) {
			g.drawString(cnt * 10 + "", 50 + 25 * cnt, 270);
		}
		g.drawString("0", 50, 270);

		g.setColor(Color.RED);
		if (score0_9 > 0)
			g.fillRect(65, 250 - score0_9 * 20, 10, score0_9 * 20);
		if (score10_19 > 0)
			g.fillRect(90, 250 - score10_19 * 20, 10, score10_19 * 20);
		if (score20_29 > 0)
			g.fillRect(115, 250 - score20_29 * 20, 10, score20_29 * 20);
		if (score30_39 > 0)
			g.fillRect(140, 250 - score30_39 * 20, 10, score30_39 * 20);
		if (score40_49 > 0)
			g.fillRect(165, 250 - score40_49 * 20, 10, score40_49 * 20);
		if (score50_59 > 0)
			g.fillRect(190, 250 - score50_59 * 20, 10, score50_59 * 20);
		if (score60_69 > 0)
			g.fillRect(215, 250 - score60_69 * 20, 10, score60_69 * 20);
		if (score70_79 > 0)
			g.fillRect(240, 250 - score70_79 * 20, 10, score70_79 * 20);
		if (score80_89 > 0)
			g.fillRect(265, 250 - score80_89 * 20, 10, score80_89 * 20);
		if (score90_100 > 0)
			g.fillRect(290, 250 - score90_100 * 20, 10, score90_100 * 20);
	}

}

package eng;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Chgweight {

	public Chgweight(Subject s) {
		// TODO Auto-generated constructor stub
		Subject sbj = s;
		JFrame f_chgweight = new JFrame("Chgweight");
		f_chgweight.setSize(600, 150);
		f_chgweight.setVisible(true);
		f_chgweight.setLayout(new GridLayout(3,1,0,0));
		JLabel 	jl_weight = new JLabel("중간       기말       과제       퀴즈       발표       보고서       출결 순입니다.");
		JTextField tf_mid = new JTextField("", 5); // 
		JTextField tf_last = new JTextField("", 5);
		JTextField tf_assign = new JTextField("", 5);
		JTextField tf_quiz = new JTextField("", 5);
		JTextField tf_pres = new JTextField("", 5);
		JTextField tf_report = new JTextField("",5);
		JTextField tf_attend = new JTextField("",5);
		JButton save_chgweight = new JButton("Save");
		
		JPanel p1_chgweight = new JPanel(new FlowLayout());
		f_chgweight.add(p1_chgweight);
		p1_chgweight.add(jl_weight);
		
		JPanel p2_chgweight = new JPanel(new FlowLayout());
		f_chgweight.add(p2_chgweight);
		p2_chgweight.add(tf_mid);
		p2_chgweight.add(tf_last);
		p2_chgweight.add(tf_assign);
		p2_chgweight.add(tf_quiz);
		p2_chgweight.add(tf_pres);
		p2_chgweight.add(tf_report);
		p2_chgweight.add(tf_attend);
		
		JPanel p3_chgweight = new JPanel(new FlowLayout());
		f_chgweight.add(p3_chgweight);
		p3_chgweight.add(save_chgweight);
		
		ActionListener listener = l -> {
			try {
				if(l.getSource() == save_chgweight) {
					int mid =  Integer.parseInt(tf_mid.getText());
					int last = Integer.parseInt(tf_last.getText());
					int assign = Integer.parseInt(tf_assign.getText());
					int quiz = Integer.parseInt(tf_quiz.getText());
					int pres = Integer.parseInt(tf_pres.getText());
					int report = Integer.parseInt(tf_report.getText());
					int attend = Integer.parseInt(tf_attend.getText());
				
					if ((mid+last+assign+quiz+pres+report+attend) == 100) {
						sbj.changeWeight(mid, last, assign, quiz, pres, report, attend);
						for(int i : sbj.getWeight()) {
							System.out.println(i);
						}
					}
					else {
						// sum is not 100
						tf_mid.setText("총합이 ");
						tf_last.setText("100이 ");
						tf_assign.setText("안됩니다.");
						tf_quiz.setText("");
						tf_pres.setText("");
						tf_report.setText("");
						tf_attend.setText("");
					}
				
				}
			}
			catch(Exception e) {
				tf_mid.setText("과목을");
				tf_last.setText("먼저");
				tf_assign.setText("선택하세요");
				tf_quiz.setText("");
				tf_pres.setText("");
				tf_report.setText("");
				tf_attend.setText("");
			}
		};
		save_chgweight.addActionListener(listener);
	}

}

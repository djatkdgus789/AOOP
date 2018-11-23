package eng;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Enterscore {
	Enterscore(Subject s){
		JFrame f_enterscore = new JFrame("Enter Score");
		f_enterscore.setSize(700, 150);
		f_enterscore.setVisible(true);
		f_enterscore.setLayout(new GridLayout(4,1,0,0));
		JLabel 	jl_weight_enter = new JLabel("중간       기말       과제       퀴즈       발표       보고서       출결 순입니다.");
		JLabel jl_stunum = new JLabel("학번 ");
		JTextField tf_mid_enter = new JTextField("", 5); // 
		JTextField tf_last_enter = new JTextField("", 5);
		JTextField tf_assign_enter = new JTextField("", 5);
		JTextField tf_quiz_enter = new JTextField("", 5);
		JTextField tf_pres_enter = new JTextField("", 5);
		JTextField tf_report_enter = new JTextField("",5);
		JTextField tf_attend_enter = new JTextField("",5);
		JTextField tf_stunum = new JTextField("",5);
		JButton save_enterscore = new JButton("Save");
	
		JPanel p1_enterscore = new JPanel(new FlowLayout());
		f_enterscore.add(p1_enterscore);
		p1_enterscore.add(jl_stunum);
		p1_enterscore.add(tf_stunum);
		JPanel p2_enterscore = new JPanel(new FlowLayout());
		f_enterscore.add(p2_enterscore);
		p2_enterscore.add(jl_weight_enter);
	
		JPanel p3_enterscore = new JPanel(new FlowLayout());
		f_enterscore.add(p3_enterscore);
		p3_enterscore.add(tf_mid_enter);
		p3_enterscore.add(tf_last_enter);
		p3_enterscore.add(tf_assign_enter);
		p3_enterscore.add(tf_quiz_enter);
		p3_enterscore.add(tf_pres_enter);
		p3_enterscore.add(tf_report_enter);
		p3_enterscore.add(tf_attend_enter);
	
		JPanel p4_enterscore = new JPanel(new FlowLayout());
		f_enterscore.add(p4_enterscore);
		p4_enterscore.add(save_enterscore);

		ActionListener listener = l -> {
			try {
				if(l.getSource() == save_enterscore) {
					int stunum = Integer.parseInt(tf_stunum.getText());
					int mid = Integer.parseInt(tf_mid_enter.getText());
					int last = Integer.parseInt(tf_last_enter.getText());
					int assign = Integer.parseInt(tf_assign_enter.getText());
					int quiz = Integer.parseInt(tf_quiz_enter.getText());
					int pres = Integer.parseInt(tf_pres_enter.getText());
					int report = Integer.parseInt(tf_report_enter.getText());
					int attend = Integer.parseInt(tf_attend_enter.getText());
					
					s.addScore(stunum, mid, last, assign, quiz, pres, report);
				}
			}
			catch(Exception e){
				
			}
		};
		save_enterscore.addActionListener(listener);
	}
}

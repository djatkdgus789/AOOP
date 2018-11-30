package eng;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Modifyscore {
	Modifyscore(Subject s) {
		JFrame f_modifyscore = new JFrame("Modify Score");
		f_modifyscore.setSize(600, 150);
		f_modifyscore.setVisible(true);
		f_modifyscore.setLayout(new GridLayout(3, 1, 0, 0));
		JLabel jl_weight_modify = new JLabel("중간       기말       과제       퀴즈       발표       보고서        순입니다.");
		JLabel jl_std_num = new JLabel("학번");
		JTextField tf_mid_modify = new JTextField("", 5); //
		JTextField tf_last_modify = new JTextField("", 5);
		JTextField tf_assign_modify = new JTextField("", 5);
		JTextField tf_quiz_modify = new JTextField("", 5);
		JTextField tf_pres_modify = new JTextField("", 5);
		JTextField tf_report_modify = new JTextField("", 5);
		JTextField tf_std_num = new JTextField("", 7);
		JButton modifyscore = new JButton("Modify");

		JPanel p1_modifyscore = new JPanel(new FlowLayout());
		f_modifyscore.add(p1_modifyscore);
		p1_modifyscore.add(jl_weight_modify);

		JPanel p2_modifyscore = new JPanel(new FlowLayout());
		f_modifyscore.add(p2_modifyscore);
		p2_modifyscore.add(tf_mid_modify);
		p2_modifyscore.add(tf_last_modify);
		p2_modifyscore.add(tf_assign_modify);
		p2_modifyscore.add(tf_quiz_modify);
		p2_modifyscore.add(tf_pres_modify);
		p2_modifyscore.add(tf_report_modify);

		JPanel p3_modifyscore = new JPanel(new FlowLayout());
		f_modifyscore.add(p3_modifyscore);
		p3_modifyscore.add(jl_std_num);
		p3_modifyscore.add(tf_std_num);
		p3_modifyscore.add(modifyscore);

	}
}

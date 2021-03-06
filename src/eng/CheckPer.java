package eng;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CheckPer {
	CheckPer(Subject s) {
		JFrame f_enter = new JFrame("Rank");
		f_enter.setSize(220, 200);
		f_enter.setVisible(true);
		f_enter.setLayout(new GridLayout(2, 1, 0, 0));
		JLabel jl_stunum_enter = new JLabel("학번");
		JLabel jl_grade = new JLabel();
		JLabel jl_rank = new JLabel("Percent");
		JTextField tf_stunum_enter = new JTextField("", 7); //
		JTextField tf_grade = new JTextField("", 5); //
		JButton rank = new JButton("%");

		JPanel p1_enter = new JPanel(new FlowLayout());
		f_enter.add(p1_enter);
		p1_enter.add(jl_stunum_enter);
		p1_enter.add(tf_stunum_enter);
		p1_enter.add(rank);

		JPanel p2_enter = new JPanel(new FlowLayout());
		f_enter.add(p2_enter);
		p2_enter.add(jl_rank);
		p2_enter.add(jl_grade);
		p2_enter.add(tf_grade);

		ActionListener listener = l -> {
			try {
				if (l.getSource() == rank) {
					int stunum = Integer.parseInt(tf_stunum_enter.getText());
					 tf_grade.setText(s.check(stunum)+"%");
				}
			} catch (Exception e) {

			}
		};
		rank.addActionListener(listener);

	}

}

package eng;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Enterstu {

	public Enterstu(Subject s) {
		// TODO Auto-generated constructor stub
		JFrame f_enter = new JFrame("Enter stu");
		f_enter.setSize(300, 200);
		f_enter.setVisible(true);
		f_enter.setLayout(new GridLayout(3, 1, 0, 0));
		JLabel jl_name_enter = new JLabel("이름");
		JLabel jl_stunum_enter = new JLabel("학번");
		JLabel jl_team_enter = new JLabel("Team");
		JLabel jl_unique_enter = new JLabel("Unique");
		JTextField tf_name_enter = new JTextField("", 5); //
		JTextField tf_stunum_enter = new JTextField("", 7); //
		JTextField tf_team_enter = new JTextField("", 2); //
		JTextField tf_unique_enter = new JTextField("", 7); //
		JButton save_enter = new JButton("Save");

		JPanel p1_enter = new JPanel(new FlowLayout());
		f_enter.add(p1_enter);
		p1_enter.add(jl_name_enter);
		p1_enter.add(tf_name_enter);
		p1_enter.add(jl_stunum_enter);
		p1_enter.add(tf_stunum_enter);

		JPanel p2_enter = new JPanel(new FlowLayout());
		f_enter.add(p2_enter);
		p2_enter.add(jl_team_enter);
		p2_enter.add(tf_team_enter);
		p2_enter.add(jl_unique_enter);
		p2_enter.add(tf_unique_enter);

		JPanel p3_enter = new JPanel(new FlowLayout());
		f_enter.add(p3_enter);
		p3_enter.add(save_enter);

		ActionListener listener = l -> {
			try {
				if (l.getSource() == save_enter) {
					String name = tf_name_enter.getText();
					int stunum = Integer.parseInt(tf_stunum_enter.getText());
					String team = tf_team_enter.getText();
					String unique = tf_unique_enter.getText();

					s.addStudent(new Student(name, stunum, team, unique));
					s.view(s.getName());
				}
			} catch (Exception e) {
				tf_name_enter.setText("과목을");
				tf_stunum_enter.setText("먼저");
				tf_unique_enter.setText("입력하세요");
			}

		};
		save_enter.addActionListener(listener);

	}
}

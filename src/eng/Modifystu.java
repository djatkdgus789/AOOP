package eng;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Modifystu {

	public Modifystu(Subject s) {
		// TODO Auto-generated constructor stub
		JFrame f_mod = new JFrame("Modify stu");
		f_mod.setSize(300, 200);
		f_mod.setVisible(true);
		f_mod.setLayout(new GridLayout(3, 1, 0, 0));
		JLabel jl_name_mod = new JLabel("이름");
		JLabel jl_stunum_mod = new JLabel("학번");
		JLabel jl_team_mod = new JLabel("Team");
		JLabel jl_unique_mod = new JLabel("Unique");
		JTextField tf_name_mod = new JTextField("", 5); // 이름입력
		JTextField tf_stunum_mod = new JTextField("", 7); // 학번입력
		JTextField tf_team_mod = new JTextField("", 2); //
		JTextField tf_unique_mod = new JTextField("", 7); //
		JButton search_mod = new JButton("Search");
		JButton mod = new JButton("Modify");
		mod.setEnabled(false);
		tf_name_mod.setText("학번으로 검색 ");
		tf_name_mod.setEditable(false);
		tf_team_mod.setEditable(false);
		tf_unique_mod.setEditable(false);

		JPanel p1_mod = new JPanel(new FlowLayout());
		f_mod.add(p1_mod);
		p1_mod.add(jl_name_mod);
		p1_mod.add(tf_name_mod);
		p1_mod.add(jl_stunum_mod);
		p1_mod.add(tf_stunum_mod);

		JPanel p2_mod = new JPanel(new FlowLayout());
		f_mod.add(p2_mod);
		p2_mod.add(jl_team_mod);
		p2_mod.add(tf_team_mod);
		p2_mod.add(jl_unique_mod);
		p2_mod.add(tf_unique_mod);

		JPanel p3_mod = new JPanel(new FlowLayout());
		f_mod.add(p3_mod);
		p3_mod.add(mod);
		p3_mod.add(search_mod);

		ActionListener listener = l -> {
			try {
				if (l.getSource() == search_mod) {
					int stunum = Integer.parseInt(tf_stunum_mod.getText());

					s.std_list.forEach((x) -> {
						if (x.getStd_num() == stunum) {
							mod.setEnabled(true);
							search_mod.setEnabled(false);
							tf_stunum_mod.setEditable(false);
							tf_name_mod.setEditable(true);
							tf_team_mod.setEditable(true);
							tf_unique_mod.setEditable(true);

						}
					});
				}
			} catch (Exception e) {
				tf_name_mod.setText("과목을");
				tf_stunum_mod.setText("먼저");
				tf_unique_mod.setText("입력하세요");
			}

		};
		search_mod.addActionListener(listener);

		ActionListener listener2 = l -> {

			if (l.getSource() == mod) {
				String name = tf_name_mod.getText();
				int stunum = Integer.parseInt(tf_stunum_mod.getText());
				String team = tf_team_mod.getText();
				String unique = tf_unique_mod.getText();
				s.std_list.forEach((x) -> {
					if (x.getStd_num() == stunum) {
						x.setName(name);
						x.setTeam(team);
						x.setUnique(unique);
					}
				});
			}
		};
		mod.addActionListener(listener2);
	}

}

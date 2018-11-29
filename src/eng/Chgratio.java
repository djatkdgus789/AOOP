package eng;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Chgratio {

	public Chgratio(Subject s) {
		// TODO Auto-generated constructor
		Subject sbj = s;
		JFrame f_chgratio = new JFrame("Chgratio");
		f_chgratio.setSize(600, 150);
		f_chgratio.setVisible(true);
		f_chgratio.setLayout(new GridLayout(3, 1, 0, 0));
		JLabel jl_ratio = new JLabel("A+       A0        B+       B0       C+       C0       D       F 순입니다.");
		JTextField tf_Aplus = new JTextField("15", 5);
		JTextField tf_Azero = new JTextField("15", 5);
		JTextField tf_Bplus = new JTextField("15", 5);
		JTextField tf_Bzero = new JTextField("15", 5);
		JTextField tf_Cplus = new JTextField("10", 5);
		JTextField tf_Czero = new JTextField("10", 5);
		JTextField tf_D = new JTextField("10", 5);
		JTextField tf_F = new JTextField("10", 5);
		JButton save_chgratio = new JButton("Save");

		JPanel p1_chgratio = new JPanel(new FlowLayout());
		f_chgratio.add(p1_chgratio);
		p1_chgratio.add(jl_ratio);

		JPanel p2_chgratio = new JPanel(new FlowLayout());
		f_chgratio.add(p2_chgratio);
		p2_chgratio.add(tf_Aplus);
		p2_chgratio.add(tf_Azero);
		p2_chgratio.add(tf_Bplus);
		p2_chgratio.add(tf_Bzero);
		p2_chgratio.add(tf_Cplus);
		p2_chgratio.add(tf_Czero);
		p2_chgratio.add(tf_D);
		p2_chgratio.add(tf_F);

		JPanel p3_chgratio = new JPanel(new FlowLayout());
		f_chgratio.add(p3_chgratio);
		p3_chgratio.add(save_chgratio);

		ActionListener listener = l -> {
			try {
				if (l.getSource() == save_chgratio) {
					int A_plus = Integer.parseInt(tf_Aplus.getText());
					int A_zero = Integer.parseInt(tf_Azero.getText());
					int B_plus = Integer.parseInt(tf_Bplus.getText());
					int B_zero = Integer.parseInt(tf_Bzero.getText());
					int C_plus = Integer.parseInt(tf_Cplus.getText());
					int C_zero = Integer.parseInt(tf_Czero.getText());
					int D = Integer.parseInt(tf_D.getText());
					int F = Integer.parseInt(tf_F.getText());

					if ((A_plus + A_zero + B_plus + B_zero + C_plus + C_zero + D + F) == 100) {
						sbj.changeRatio(A_plus, A_zero, B_plus, B_zero, C_plus, C_zero, D, F);
						for (int i : sbj.getRatio()) {
							System.out.println(i);
						}
					} else {
						// sum is not 100
						tf_Aplus.setText("총합이 ");
						tf_Azero.setText("100이 ");
						tf_Bplus.setText("안됩니다.");
						tf_Bzero.setText("");
						tf_Cplus.setText("");
						tf_Czero.setText("");
						tf_D.setText("");
						tf_F.setText("");
					}

				}
			} catch (Exception e) {
				tf_Aplus.setText("과목을 ");
				tf_Azero.setText("먼저 ");
				tf_Bplus.setText("선택 하세요 .");
				tf_Bzero.setText("");
				tf_Cplus.setText("");
				tf_Czero.setText("");
				tf_D.setText("");
				tf_F.setText("");
			}
		};
		save_chgratio.addActionListener(listener);

	}

}

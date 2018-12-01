package eng;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EnterAttend {

	EnterAttend(Subject s) {
		JFrame f_enterattend = new JFrame("Enter Attend");
		f_enterattend.setSize(500, 200);
		f_enterattend.setVisible(true);
		f_enterattend.setLayout(new GridLayout(3, 1, 0, 0));
		JLabel jl_enterattend = new JLabel("Enter Attendence in 1~16 Weeks");
		JLabel jl_std_num_enterattend = new JLabel("학번");
		JButton save_enterattend = new JButton("Save");

		JTextField tf_std_num_enterattend = new JTextField("", 7);
		JTextField tf_w1 = new JTextField("", 1);
		JTextField tf_w2 = new JTextField("", 1);
		JTextField tf_w3 = new JTextField("", 1);
		JTextField tf_w4 = new JTextField("", 1);
		JTextField tf_w5 = new JTextField("", 1);
		JTextField tf_w6 = new JTextField("", 1);
		JTextField tf_w7 = new JTextField("", 1); //
		JTextField tf_w8 = new JTextField("", 1); //
		JTextField tf_w9 = new JTextField("", 1); //
		JTextField tf_w10 = new JTextField("", 1); //
		JTextField tf_w11 = new JTextField("", 1);
		JTextField tf_w12 = new JTextField("", 1);
		JTextField tf_w13 = new JTextField("", 1);
		JTextField tf_w14 = new JTextField("", 1);
		JTextField tf_w15 = new JTextField("", 1); //
		JTextField tf_w16 = new JTextField("", 1); //

		JPanel p1_enterattend = new JPanel();
		f_enterattend.add(p1_enterattend);
		p1_enterattend.add(jl_enterattend);

		JPanel p2_enterattend = new JPanel();
		f_enterattend.add(p2_enterattend);
		p2_enterattend.add(jl_std_num_enterattend);
		p2_enterattend.add(tf_std_num_enterattend);
		p2_enterattend.add(save_enterattend);

		JPanel p3_enterattend = new JPanel();
		f_enterattend.add(p3_enterattend);
		p3_enterattend.add(tf_w1);
		p3_enterattend.add(tf_w2);
		p3_enterattend.add(tf_w3);
		p3_enterattend.add(tf_w4);
		p3_enterattend.add(tf_w5);
		p3_enterattend.add(tf_w6);
		p3_enterattend.add(tf_w7);
		p3_enterattend.add(tf_w8);
		p3_enterattend.add(tf_w9);
		p3_enterattend.add(tf_w10);
		p3_enterattend.add(tf_w11);
		p3_enterattend.add(tf_w12);
		p3_enterattend.add(tf_w13);
		p3_enterattend.add(tf_w14);
		p3_enterattend.add(tf_w15);
		p3_enterattend.add(tf_w16);

		ActionListener listener = l -> {
			try {
				if (l.getSource() == save_enterattend) {
					int stunum = Integer.parseInt(tf_std_num_enterattend.getText());

					int i1 = Integer.parseInt(tf_w1.getText());
					int i2 = Integer.parseInt(tf_w2.getText());
					int i3 = Integer.parseInt(tf_w3.getText());
					int i4 = Integer.parseInt(tf_w4.getText());
					int i5 = Integer.parseInt(tf_w5.getText());
					int i6 = Integer.parseInt(tf_w6.getText());
					int i7 = Integer.parseInt(tf_w7.getText());
					int i8 = Integer.parseInt(tf_w8.getText());
					int i9 = Integer.parseInt(tf_w9.getText());
					int i10 = Integer.parseInt(tf_w10.getText());
					int i11 = Integer.parseInt(tf_w11.getText());
					int i12 = Integer.parseInt(tf_w12.getText());
					int i13 = Integer.parseInt(tf_w13.getText());
					int i14 = Integer.parseInt(tf_w14.getText());
					int i15 = Integer.parseInt(tf_w15.getText());
					int i16 = Integer.parseInt(tf_w16.getText());

					s.addAttendence( stunum, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14,
							i15, i16);
					s.viewAttend();
				}
			} catch (Exception e) {
				tf_std_num_enterattend.setText("에러발생 ");
			}

		};
		save_enterattend.addActionListener(listener);

	}
}

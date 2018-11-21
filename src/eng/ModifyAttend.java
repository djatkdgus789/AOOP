package eng;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModifyAttend {
	ModifyAttend(Subject s){
		JFrame f_modifyattend = new JFrame("Enter Attend");
		f_modifyattend.setSize(500, 200);
		f_modifyattend.setVisible(true);
		f_modifyattend.setLayout(new GridLayout(3,1,0,0));
		JLabel 	jl_modifyattend = new JLabel("Enter Attendence in 1~16 Weeks");
		JLabel jl_std_num_modifyattend = new JLabel("학번");
		JButton save_modifyattend = new JButton("Modify");

		
		JTextField tf_std_num_modifyattend = new JTextField("",7);
		JTextField tf_w1_modifyattend = new JTextField("", 1); 
		JTextField tf_w2_modifyattend = new JTextField("", 1);
		JTextField tf_w3_modifyattend = new JTextField("", 1);
		JTextField tf_w4_modifyattend = new JTextField("", 1);
		JTextField tf_w5_modifyattend = new JTextField("", 1);
		JTextField tf_w6_modifyattend = new JTextField("", 1);
		JTextField tf_w7_modifyattend = new JTextField("", 1); // 
		JTextField tf_w8_modifyattend = new JTextField("", 1); // 
		JTextField tf_w9_modifyattend = new JTextField("", 1); // 
		JTextField tf_w10_modifyattend = new JTextField("", 1); // 
		JTextField tf_w11_modifyattend = new JTextField("", 1); //
		JTextField tf_w12_modifyattend = new JTextField("", 1); // 
		JTextField tf_w13_modifyattend = new JTextField("", 1); // 
		JTextField tf_w14_modifyattend = new JTextField("", 1); // 
		JTextField tf_w15_modifyattend = new JTextField("", 1); // 
		JTextField tf_w16_modifyattend = new JTextField("", 1); // 
		
		
		JPanel p1_modifyattend = new JPanel();
		f_modifyattend.add(p1_modifyattend);
		p1_modifyattend.add(jl_modifyattend);
		
		JPanel p2_modifyattend = new JPanel();
		f_modifyattend.add(p2_modifyattend);
		p2_modifyattend.add(jl_std_num_modifyattend);
		p2_modifyattend.add(tf_std_num_modifyattend);
		p2_modifyattend.add(save_modifyattend);
		
		JPanel p3_modifyattend = new JPanel();
		f_modifyattend.add(p3_modifyattend);
		p3_modifyattend.add(tf_w1_modifyattend);
		p3_modifyattend.add(tf_w2_modifyattend);
		p3_modifyattend.add(tf_w3_modifyattend);
		p3_modifyattend.add(tf_w4_modifyattend);
		p3_modifyattend.add(tf_w5_modifyattend);
		p3_modifyattend.add(tf_w6_modifyattend);
		p3_modifyattend.add(tf_w7_modifyattend);
		p3_modifyattend.add(tf_w8_modifyattend);
		p3_modifyattend.add(tf_w9_modifyattend);
		p3_modifyattend.add(tf_w10_modifyattend);
		p3_modifyattend.add(tf_w11_modifyattend);
		p3_modifyattend.add(tf_w12_modifyattend);
		p3_modifyattend.add(tf_w13_modifyattend);
		p3_modifyattend.add(tf_w14_modifyattend);
		p3_modifyattend.add(tf_w15_modifyattend);
		p3_modifyattend.add(tf_w16_modifyattend);
		
		ActionListener listener = l -> {
			try {
				if(l.getSource() == save_modifyattend) {
					int stunum = Integer.parseInt(tf_std_num_modifyattend.getText());
					
						int i1 = Integer.parseInt(tf_w1_modifyattend.getText());
						int i2 = Integer.parseInt(tf_w2_modifyattend.getText());
						int i3 = Integer.parseInt(tf_w3_modifyattend.getText());
						int i4 = Integer.parseInt(tf_w4_modifyattend.getText());
						int i5 = Integer.parseInt(tf_w5_modifyattend.getText());
						int i6 = Integer.parseInt(tf_w6_modifyattend.getText());
						int i7 = Integer.parseInt(tf_w7_modifyattend.getText());
						int i8 = Integer.parseInt(tf_w8_modifyattend.getText());
						int i9 = Integer.parseInt(tf_w9_modifyattend.getText());
						int i10 = Integer.parseInt(tf_w10_modifyattend.getText());
						int i11 = Integer.parseInt(tf_w11_modifyattend.getText());
						int i12 = Integer.parseInt(tf_w12_modifyattend.getText());
						int i13 = Integer.parseInt(tf_w13_modifyattend.getText());
						int i14 = Integer.parseInt(tf_w14_modifyattend.getText());
						int i15 = Integer.parseInt(tf_w15_modifyattend.getText());
						int i16 = Integer.parseInt(tf_w16_modifyattend.getText());

						s.addAttendence(s.getName(), stunum, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16);
						s.viewAttend();
					}
				}
				catch(Exception e) {
					tf_std_num_modifyattend.setText("에러발생 ");
				}
		};
		save_modifyattend.addActionListener(listener);
	}
}

package eng;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Deletestu {
	
	Deletestu(Subject s) {
		JFrame f_del = new JFrame("Delete stu");
		f_del.setSize(300, 200);
		f_del.setVisible(true);
		f_del.setLayout(new GridLayout(2,1,0,0));
		JLabel jl_name_del = new JLabel("이름");
		JLabel jl_stunum_del = new JLabel("학번");
		JTextField tf_name_del = new JTextField("", 5); // 이름입력
		JTextField tf_stunum_del = new JTextField("", 7); // 학번입력 
		JButton del = new JButton("Delete");

		
		JPanel p1_del = new JPanel(new FlowLayout());
		f_del.add(p1_del);
		p1_del.add(jl_name_del);
		p1_del.add(tf_name_del);
		p1_del.add(jl_stunum_del);
		p1_del.add(tf_stunum_del);
		
		JPanel p2_del = new JPanel(new FlowLayout());
		f_del.add(p2_del);
		p2_del.add(del);

		ActionListener listener = l ->{
//			try {
				if(l.getSource() == del) {
					int stunum = Integer.parseInt(tf_stunum_del.getText());
					Iterator<Student> iter = s.std_list.iterator();

					while (iter.hasNext()) {
					    Student x = iter.next();

					    if (x.getStd_num() == stunum)
					        iter.remove();
				}
//			}
//			catch(Exception exc) {
//				tf_name_del.setText("과목을 먼저 ");
//				tf_stunum_del.setText("입력하세요 ");
//			}
				}
		};
		del.addActionListener(listener);
		}

}
package eng;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import javafx.event.ActionEvent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class Frame extends JFrame implements ActionListener {
	public JTextField tf_current_subj = new JTextField(5);
	public JTextField tf_selectedMenu = new JTextField(10);
	public Map<String, Subject> java = new HashMap<String, Subject>();
	public Subject s;
	public JList<String> studentList;
	private DefaultListModel<String> model;

	public Frame() {
		java.put("web", new Subject("web"));
		java.put("oop", new Subject("oop"));
		java.put("aoop", new Subject("aoop"));
		setTitle("aoop proj ");
		setSize(550, 800);
		setLayout(new BorderLayout());
		constructLayout();
		makeMenu();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	void makeMenu() {
		JMenuItem item;

		JMenuBar mb = new JMenuBar();
		JMenu file = new JMenu("파일");
		JMenu subj = new JMenu("과목");
		JMenu ratio = new JMenu("비율");
		JMenu stu_manage = new JMenu("학생관리");
		JMenu score_manage = new JMenu("성적관리");
		JMenu statics = new JMenu("통계");
		JMenu graph = new JMenu("그래프");

		item = new JMenuItem("Save DB");
		item.addActionListener(this);
		file.add(item);
		item = new JMenuItem("Load DB");
		item.addActionListener(this);
		file.add(item);
		item = new JMenuItem("Input CSV");
		item.addActionListener(this);
		file.add(item);
		item = new JMenuItem("Save CSV");
		item.addActionListener(this);
		file.add(item);
		item = new JMenuItem("Exit");
		item.addActionListener(this);
		file.add(item);

		item = new JMenuItem("WEBPROG");
		item.addActionListener(this);
		subj.add(item);
		item = new JMenuItem("OOP");
		item.addActionListener(this);
		subj.add(item);
		item = new JMenuItem("AOOP");
		item.addActionListener(this);
		subj.add(item);

		item = new JMenuItem("Chgweight");
		item.addActionListener(this);
		ratio.add(item);
		item = new JMenuItem("Chgratio");
		item.addActionListener(this);
		ratio.add(item);

		item = new JMenuItem("Enter stu");
		item.addActionListener(this);
		stu_manage.add(item);
		item = new JMenuItem("Modify stu");
		item.addActionListener(this);
		stu_manage.add(item);
		item = new JMenuItem("Delete stu");
		item.addActionListener(this);
		stu_manage.add(item);
		item = new JMenuItem("Enter Attend");
		item.addActionListener(this);
		stu_manage.add(item);
		item = new JMenuItem("Modify Attend");
		item.addActionListener(this);
		stu_manage.add(item);

		item = new JMenuItem("Enter score");
		item.addActionListener(this);
		score_manage.add(item);
		item = new JMenuItem("Modify score");
		item.addActionListener(this);
		score_manage.add(item);
		item = new JMenuItem("Calc grade");
		item.addActionListener(this);
		score_manage.add(item);

		item = new JMenuItem("Rank");
		item.addActionListener(this);
		statics.add(item);
		item = new JMenuItem("Average of Total");
		item.addActionListener(this);
		statics.add(item);
		item = new JMenuItem("Average of Mid");
		item.addActionListener(this);
		statics.add(item);
		item = new JMenuItem("Average of Last");
		item.addActionListener(this);
		statics.add(item);
		item = new JMenuItem("Average of Quiz");
		item.addActionListener(this);
		statics.add(item);
		item = new JMenuItem("Average of Pres");
		item.addActionListener(this);
		statics.add(item);
		item = new JMenuItem("Average of Report");
		item.addActionListener(this);
		statics.add(item);
		item = new JMenuItem("Deviation");
		item.addActionListener(this);
		statics.add(item);
		item = new JMenuItem("Sort ascending by Total Score");
		item.addActionListener(this);
		statics.add(item);
		item = new JMenuItem("Sort descending by Total Score");
		item.addActionListener(this);
		statics.add(item);
		item = new JMenuItem("Sort by stunum");
		item.addActionListener(this);
		statics.add(item);
		item = new JMenuItem("Check %");
		item.addActionListener(this);
		statics.add(item);

		item = new JMenuItem("Graph for mid");
		item.addActionListener(this);
		graph.add(item);
		item = new JMenuItem("Graph for last");
		item.addActionListener(this);
		graph.add(item);
		item = new JMenuItem("Graph for quiz");
		item.addActionListener(this);
		graph.add(item);
		item = new JMenuItem("Graph for pres");
		item.addActionListener(this);
		graph.add(item);
		item = new JMenuItem("Graph for report");
		item.addActionListener(this);
		graph.add(item);
		

		mb.add(file);
		mb.add(subj);
		mb.add(ratio);
		mb.add(stu_manage);
		mb.add(score_manage);
		mb.add(statics);
		mb.add(graph);
		setJMenuBar(mb);
	}

	void constructLayout() {
		JPanel p1 = new JPanel(new FlowLayout());
		JPanel p1_1 = new JPanel(new FlowLayout());
		JPanel p1_2 = new JPanel(new FlowLayout());
		//		JPanel p1_3 = new JPanel(new FlowLayout());
		JLabel jl_current_subj = new JLabel("현재 작업 중인 과목 ");
		JLabel selectedMenu = new JLabel("선택한 메뉴의 결과값");

		add(p1, BorderLayout.NORTH);
		p1.add(p1_1);
		p1_1.add(jl_current_subj);
		p1_1.add(tf_current_subj);
		tf_current_subj.setEnabled(false);

		//		p1.add(p1_2);
		p1_1.add(selectedMenu);
		p1_1.add(tf_selectedMenu);
		tf_selectedMenu.setEnabled(false);



		//		JPanel p2 = new JPanel();
		//		add(p2);
		//		p2.add(new JLabel("2"));
		//
		//		
		// JPanel p3 = new JPanel();
		// add(p3);

		Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
		model = new DefaultListModel<>();
		studentList = new JList<String>(model);
		JScrollPane jp1 = new JScrollPane(studentList);
		studentList.setVisibleRowCount(30);
		// studentList.setFont(f2);
		studentList.setBorder(lineBorder);
		model.addElement("학생의 성적!!!");
		model.addElement("해당 과목 메뉴를 누르면 갱신됩니다.");
		model.addElement("--------------------------------------------------------------");
		add(jp1, BorderLayout.CENTER);

		//		JPanel p4 = new JPanel();
		//		add(p4); 
		//		p4.add(new JLabel("그래프 "));

	}
	public void view() {
		model.removeAllElements();
		model.addElement("학생이름 학번 중간 기말 과제 보고서 퀴즈 발표순입니다.");
		model.addElement("해당 과목 메뉴를 누르면 갱신됩니다.");
		for (Student s : s.std_list) {
			model.addElement(s.toString());
		}

	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		// TODO Auto-generated method stub
		JMenuItem mi = (JMenuItem) (e.getSource());

		switch (mi.getText()) {

		case "Exit":
			System.exit(0);
			break;

		case "WEBPROG":
			tf_current_subj.setText("WEBPROG");
			s = java.get("web");
			this.view();

			break;
			// f0007
		case "AOOP":
			tf_current_subj.setText("AOOP");
			s = java.get("aoop");
			this.view();


			break;
			// f0008
		case "OOP":
			tf_current_subj.setText("OOP");
			s = java.get("oop");
			this.view();

			break;

		case "Save DB":
			System.out.println("Save DB");
			break;

		case "Load DB":
			System.out.println("Load DB");
			break;
		
		case "Input CSV":
			break;
			
		case "Save CSV":
			System.out.println("Input CSV");
			new FileWrite(s);
			break;

		case "Chgweight":
			new Chgweight(s);
			break;

		case "Chgratio":
			new Chgratio(s);
			break;

		case "Enter stu":
			new Enterstu(s);
			break;

		case "Modify stu":
			new Modifystu(s);
			break;

		case "Delete stu":
			new Deletestu(s);
			break;
		case "Enter Attend":
			new EnterAttend(s);
			break;

		case "Modify Attend":
			new ModifyAttend(s);
			break;

		case "Enter score":
			new Enterscore(s);
			break;

		case "Modify score":
			new Modifyscore(s);
			break;

		case "Calc grade":
			new Calcgrade(s);
			break;
		case "Rank":
			new Rank(s);
			break;
		case "Average of Total":
			tf_selectedMenu.setText("총점의 평균 : " + Double.toString(s.getAverofTotal()));
			break;

		case "Average of Mid":
			tf_selectedMenu.setText("중간고사 평균 : " + Double.toString(s.calAverofMid()));
			break;

		case "Average of Last":
			tf_selectedMenu.setText("기말고사 평균 : " + Double.toString(s.calAverofLast()));
			break;

		case "Average of Quiz":
			tf_selectedMenu.setText("퀴즈 평균 : " + Double.toString(s.calAverofQuiz()));
			break;

		case "Average of Pres":
			tf_selectedMenu.setText("발표점수 평균 : " + Double.toString(s.calAverofPresentation()));
			break;

		case "Average of Report":
			tf_selectedMenu.setText("보고서점수 평균 : " + Double.toString(s.calAverofReport()));
			break;
		case "Deviation":
			double devi = Double.parseDouble(String.format("%.2f",s.calDevi()));
			tf_selectedMenu.setText("표준편차 : " + Double.toString(devi));
			break;
			
		case "Sort ascending by Total Score":
			s.sort_total_Score_Ascending();
			break;
			
		case "Sort descending by Total Score":
			s.sort_total_Score_Descending();
			break;
			
		case "Sort by stunum":
			s.sort_Std_num_Ascending();
			break;

		case "Graph for mid":
			new Graph_mid(s);
			break;

		case "Graph for last":
			new Graph_last(s);
			break;
		
		case "Graph for report":
			new Graph_report(s);
		
		}
	}
}

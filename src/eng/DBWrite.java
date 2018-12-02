package eng;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DBWrite extends JFrame{
	Subject s;
	public DBWrite(Subject s) {
		Connection connection = null;
		this.s = s;
		
		setTitle("DBSAVE");
		
		ActionListener l = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			    	   for(Student std : s.std_list) {
			    		   // 디비에 해당 학번이 있는지 확인해야됨. if()
			    		   //과목이 뭔지 확인하고  아래 쿼리문에서 WEBPROG만 바꾸면 됨. OOP AOOP
			    		   String query = "UPDATE WEBPROG SET stuID='"+std.getStd_num()+"' ,stuName='"+std.getName()+
			    				   "' ,stuTeam='"+std.getTeam()+"' ,stuUniq='"+std.getUnique()+"' ,mid='"+
			    				   std.getScore().getMid()+"' ,last='"+std.getScore().getLast()+"' ,assignment='"+
			    				   std.getScore().getAssignment()+"' ,report='"+std.getScore().getReport()+"' ,quiz='"+
			    				   std.getScore().getQuiz()+"' ,presentation='"+std.getScore()+"' ,attend1='"+
			    				   std.getAttend().getI1()+"' ,attend2='"+std.getAttend().getI2()+"' ,attend3='"+
			    				   std.getAttend().getI3()+"' ,attend4='"+std.getAttend().getI4()+"' ,attend5='"+
			    				   std.getAttend().getI5()+"' ,attend6='"+std.getAttend().getI6()+"' ,attend7='"+
			    				   std.getAttend().getI7()+"' ,attend8='"+std.getAttend().getI1()+"' ,attend9='"+
			    				   std.getAttend().getI9()+"' ,attend10='"+std.getAttend().getI1()+"' ,attend11='"+
			    				   std.getAttend().getI11()+"' ,attend12='"+std.getAttend().getI1()+"' ,attend13='"+
			    				   std.getAttend().getI13()+"' ,attend14='"+std.getAttend().getI1()+"' ,attend15='"+
			    				   std.getAttend().getI15()+"' ,attend16='"+std.getAttend().getI1()+"' ";
			    				   
			    				   
			    		   PreparedStatement pst = connection.prepareStatement(query);
			    		    	   
			    		   //JOptionPane.showMessageDialog(null, "Data Updated");
			    		   pst.execute();
			    		   pst.close();
			    	   }
			    	   
			       }catch(Exception e) {
			    	   e.printStackTrace();
			       }
			}
		};
		
		JPanel p = new JPanel(new FlowLayout());
		
		JButton save = new JButton("SAVE");
		
		p.setSize(300, 200);
		p.setVisible(true);
	}
/*	
	public DBWrite(Subject s) {
		// TODO Auto-generated constructor stub
		this.s = s;
		try {
			Write(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/	

 
}

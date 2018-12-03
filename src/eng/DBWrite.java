package eng;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DBWrite extends JFrame{
	Subject s;

	private static final String URL = 
			"jdbc:mysql://localhost:3306/StuProgDB?characterEncoding=UTF-8&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "didc001!!";
	private Connection connection = null;

	public DBWrite(Subject s) {
		this.s = s;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("DB Connect!!");
		}catch(ClassNotFoundException ex){
			System.out.println(ex.getMessage());
		}catch(SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}

		//Save(s);
		try {
			for(Student std : s.std_list) {
				String q = null;
				String course = null;
				// 디비에 해당 학번이 있는지 확인해야됨. if()
				if(s.getName() == "web") {
					course = "WEBPROG";
					q = "SELECT "+std.getStd_num()+" FROM WEBPROG";
					PreparedStatement pst = connection.prepareStatement(q);
					pst.execute();
					if(pst.execute() == false) {
						continue;
					}
					pst.close();
				}else if(s.getName() == "oop") {
					course = "OOP";
					q = "SELECT "+std.getStd_num()+" FROM OOP";
					PreparedStatement pst = connection.prepareStatement(q);
					pst.execute();
					if(pst.execute() == false) {
						continue;
					}
					pst.close();
				}else if(s.getName() == "aoop") {
					course = "AOOP";
					q = "SELECT "+std.getStd_num()+" FROM AOOP";
					PreparedStatement pst = connection.prepareStatement(q);
					pst.execute();
					if(pst.execute() == false) {
						continue;
					}
					pst.close();
				}
				//과목이 뭔지 확인하고  아래 쿼리문에서 WEBPROG만 바꾸면 됨. OOP AOOP
				/*
				String query = "INSERT INTO "+course+" VALUES stuID='"+std.getStd_num()+"' ,stuName='"+std.getName()+
						"' ,stuTeam='"+std.getTeam()+"' ,stuUniq='"+std.getUnique()+"' ,mid='"+
						std.getScore().getMid()+"' ,last='"+std.getScore().getLast()+"' ,assignment='"+
						std.getScore().getAssignment()+"' ,report='"+std.getScore().getReport()+"' ,quiz='"+
						std.getScore().getQuiz()+"' ,presentation='"+std.getScore().getPresentation()+"' ,attend1='"+
						std.getAttend().getI1()+"' ,attend2='"+std.getAttend().getI2()+"' ,attend3='"+
						std.getAttend().getI3()+"' ,attend4='"+std.getAttend().getI4()+"' ,attend5='"+
						std.getAttend().getI5()+"' ,attend6='"+std.getAttend().getI6()+"' ,attend7='"+
						std.getAttend().getI7()+"' ,attend8='"+std.getAttend().getI8()+"' ,attend9='"+
						std.getAttend().getI9()+"' ,attend10='"+std.getAttend().getI10()+"' ,attend11='"+
						std.getAttend().getI11()+"' ,attend12='"+std.getAttend().getI12()+"' ,attend13='"+
						std.getAttend().getI13()+"' ,attend14='"+std.getAttend().getI14()+"' ,attend15='"+
						std.getAttend().getI15()+"' ,attend16='"+std.getAttend().getI16()+"' WHERE stuID='"+std.getStd_num()+"' ";
	
	*/
	//(stuID,stuName,stuTeam,stuUniq,mid,last,assignment,report,quiz,presentation,attend1,attend2,attend3,attend4,attend5,attend6,attend7,attend8,attend9,attend10,attend11,attend12,attend13,attend14,attend15,attend16
	//+ "(stuID,stuName,stuTeam,stuUniq,mid,last,assignment,report,quiz,presentation,attend1,attend2,attend3,attend4,attend5,attend6,attend7,attend8,attend9,attend10,attend11,attend12,attend13,attend14,attend15,attend16)"
				String query = "insert into "+course+" values ('"+std.getStd_num()+"', '"+std.getName()+"', '"+
						std.getTeam()+"', '"+std.getUnique()+"', '"+std.getScore().getMid()+"', '"+std.getScore().getLast()+
						"', '"+std.getScore().getAssignment()+"' ,'"+std.getScore().getReport()+"', '"+std.getScore().getQuiz()+
						"', '"+std.getScore().getPresentation()+"' ,'"+std.getAttend().getI1()+"', '"+std.getAttend().getI2()+
						"', '"+std.getAttend().getI3()+"', '"+std.getAttend().getI4()+"', '"+std.getAttend().getI5()+
						"', '"+std.getAttend().getI6()+"', '"+std.getAttend().getI7()+"', '"+std.getAttend().getI8()+
						"', '"+std.getAttend().getI9()+"', '"+std.getAttend().getI10()+"', '"+std.getAttend().getI11()+
						"', '"+std.getAttend().getI12()+"', '"+std.getAttend().getI13()+"', '"+std.getAttend().getI14()+
						"', '"+std.getAttend().getI15()+"', '"+std.getAttend().getI16()+"') ";
				
				PreparedStatement pst = connection.prepareStatement(query);
				try {
				//JOptionPane.showMessageDialog(null, "Data Updated");
				pst.execute();
				pst.close();
				}
				catch(SQLIntegrityConstraintViolationException e){
					System.out.println("학번 중복");
				}
			}
	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}

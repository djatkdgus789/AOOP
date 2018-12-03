package eng;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DBLoad extends JFrame{
	Subject s;
	private static final String URL = 
			"jdbc:mysql://localhost:3306/StuProgDB?characterEncoding=UTF-8&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "didc001!!";
	private Connection connection = null;

	public DBLoad(Subject s) {

		//다른 방법....
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

		try {
			String query = null;
			if(s.getName() == "web") {
				query = "SELECT * FROM WEBPROG;";
				PreparedStatement pst = connection.prepareStatement(query);
				ResultSet rs = pst.executeQuery();

				while(rs.next()) {
					Student student = new Student(rs.getString(1), Integer.parseInt(rs.getString(2)), rs.getString(3),
							rs.getString(4));
					s.addStudent(student);
					s.addScore(Integer.parseInt(rs.getString(2)), Integer.parseInt(rs.getString(5)), Integer.parseInt(rs.getString(6)),
							Integer.parseInt(rs.getString(7)), Integer.parseInt(rs.getString(8)), Integer.parseInt(rs.getString(9)), 
							Integer.parseInt(rs.getString(10)));
					s.addAttendence(Integer.parseInt(rs.getString(2)), Integer.parseInt(rs.getString(11)), Integer.parseInt(rs.getString(12)),
							Integer.parseInt(rs.getString(13)), Integer.parseInt(rs.getString(14)), Integer.parseInt(rs.getString(15)),
							Integer.parseInt(rs.getString(16)), Integer.parseInt(rs.getString(17)), Integer.parseInt(rs.getString(18)),
							Integer.parseInt(rs.getString(19)), Integer.parseInt(rs.getString(20)), Integer.parseInt(rs.getString(21)),
							Integer.parseInt(rs.getString(22)), Integer.parseInt(rs.getString(23)), Integer.parseInt(rs.getString(24)),
							Integer.parseInt(rs.getString(25)), Integer.parseInt(rs.getString(26)));
				}
				pst.close();
				rs.close();
			}else if(s.getName() == "oop") {
				query = "SELECT * FROM OOP;";
				PreparedStatement pst = connection.prepareStatement(query);
				ResultSet rs = pst.executeQuery();

				while(rs.next()) {
					Student student = new Student(rs.getString(1), Integer.parseInt(rs.getString(2)), rs.getString(3),
							rs.getString(4));
					s.addStudent(student);
					s.addScore(Integer.parseInt(rs.getString(2)), Integer.parseInt(rs.getString(5)), Integer.parseInt(rs.getString(6)),
							Integer.parseInt(rs.getString(7)), Integer.parseInt(rs.getString(8)), Integer.parseInt(rs.getString(9)), 
							Integer.parseInt(rs.getString(10)));
					s.addAttendence(Integer.parseInt(rs.getString(2)), Integer.parseInt(rs.getString(11)), Integer.parseInt(rs.getString(12)),
							Integer.parseInt(rs.getString(13)), Integer.parseInt(rs.getString(14)), Integer.parseInt(rs.getString(15)),
							Integer.parseInt(rs.getString(16)), Integer.parseInt(rs.getString(17)), Integer.parseInt(rs.getString(18)),
							Integer.parseInt(rs.getString(19)), Integer.parseInt(rs.getString(20)), Integer.parseInt(rs.getString(21)),
							Integer.parseInt(rs.getString(22)), Integer.parseInt(rs.getString(23)), Integer.parseInt(rs.getString(24)),
							Integer.parseInt(rs.getString(25)), Integer.parseInt(rs.getString(26)));
				}
				pst.close();
				rs.close();
			}else if(s.getName() == "aoop") {
				query = "SELECT * FROM AOOP;";
				PreparedStatement pst = connection.prepareStatement(query);
				ResultSet rs = pst.executeQuery();

				while(rs.next()) {
					Student student = new Student(rs.getString(1), Integer.parseInt(rs.getString(2)), rs.getString(3),
							rs.getString(4));
					s.addStudent(student);
					s.addScore(Integer.parseInt(rs.getString(2)), Integer.parseInt(rs.getString(5)), Integer.parseInt(rs.getString(6)),
							Integer.parseInt(rs.getString(7)), Integer.parseInt(rs.getString(8)), Integer.parseInt(rs.getString(9)), 
							Integer.parseInt(rs.getString(10)));
					s.addAttendence(Integer.parseInt(rs.getString(2)), Integer.parseInt(rs.getString(11)), Integer.parseInt(rs.getString(12)),
							Integer.parseInt(rs.getString(13)), Integer.parseInt(rs.getString(14)), Integer.parseInt(rs.getString(15)),
							Integer.parseInt(rs.getString(16)), Integer.parseInt(rs.getString(17)), Integer.parseInt(rs.getString(18)),
							Integer.parseInt(rs.getString(19)), Integer.parseInt(rs.getString(20)), Integer.parseInt(rs.getString(21)),
							Integer.parseInt(rs.getString(22)), Integer.parseInt(rs.getString(23)), Integer.parseInt(rs.getString(24)),
							Integer.parseInt(rs.getString(25)), Integer.parseInt(rs.getString(26)));
				}
				pst.close();
				rs.close();
			}

		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
}

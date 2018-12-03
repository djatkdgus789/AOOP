package eng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;



public class DBWrite {
	Subject s;

	private static final String URL = 
			"jdbc:mysql://localhost:3306/StuProgDB?characterEncoding=UTF-8&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "didc001!!";
	private Connection connection = null;

	public DBWrite(Subject s) {
		this.s = s;

		try {
			//DATABASE 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("DB Connect!!");
		}catch(ClassNotFoundException ex){
			System.out.println(ex.getMessage());
		}catch(SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}

		try {
			for(Student std : s.std_list) {
				String q = null;
				String course = null;
				// DATABASE에 해당 학번(primary key)이 있는지 확인(중복 확인)
				// 있다면 DATABASE에 INSERT하지 않고 없다면 INSERT 하는 코드 
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

				String query = "insert into "+course+" values ('"+std.getName()+"', '"+std.getStd_num()+"', '"+
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

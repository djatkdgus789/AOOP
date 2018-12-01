package eng;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentPersonQuery {
	Frame f = new Frame();
	f.s = f.java.get("web");
	
	private static final String URL = 
			"jdbc:mysql://localhost:3306/StuProgDB?characterEncoding=UTF-8&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "pass";
	
	
	private Connection connection = null;
	private PreparedStatement selectAllStudentWEB = null;
	private PreparedStatement selectAllStudentOOP = null;
	private PreparedStatement selectAllStudentAOOP = null;
	
	private PreparedStatement selectStudentIDWEB = null;
	private PreparedStatement selectStudentIDOOP = null;
	private PreparedStatement selectStudentIDAOOP = null;
	
	private PreparedStatement insertNewStudentWEB = null;
	private PreparedStatement insertNewStudentOOP = null;
	private PreparedStatement insertNewStudentAOOP = null;
	
	public StudentPersonQuery() {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			selectAllStudentWEB = 
				connection.prepareStatement("SELECT * FROM WEBPROG");
			selectAllStudentOOP = 
					connection.prepareStatement("SELECT * FROM OOP");
			selectAllStudentAOOP = 
					connection.prepareStatement("SELECT * FROM AOOP");
			
			selectStudentIDWEB = 
				connection.prepareStatement("SELECT * FROM WEBPROG WHERE stuID = ?");
			selectStudentIDOOP = 
					connection.prepareStatement("SELECT * FROM OOP WHERE stuID = ?");
			selectStudentIDAOOP = 
					connection.prepareStatement("SELECT * FROM AOOP WHERE stuID = ?");
			
			insertNewStudentWEB = connection.prepareStatement(
				"INSERT INTO WEBPROG " +
				"(stuName, stuID, stuTeam, stuUniq) " +
				"VALUES (?, ?, ?, ?)");
			insertNewStudentOOP = connection.prepareStatement(
					"INSERT INTO OOP " +
					"(stuName, stuID, stuTeam, stuUniq) " +
					"VALUES (?, ?, ?, ?)");
			insertNewStudentAOOP = connection.prepareStatement(
					"INSERT INTO AOOP " +
					"(stuName, stuID, stuTeam, stuUniq) " +
					"VALUES (?, ?, ?, ?)");
			
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		}
	}
	
	public List<Student> getAllPeople(){
		List<Student> results = null;
		ResultSet resultSet = null;
		
		try {
			resultSet = selectAllStudentWEB.executeQuery();
			results = new ArrayList<Student>();
			
			while(resultSet.next()) {
				results.add(new Student(
					resultSet.getString("stuName"),
					resultSet.getInt("stuID"),
					resultSet.getString("stuTeam"),
					resultSet.getString("stuUniq")));
			}
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}finally {
			try {
				resultSet.close();
			}catch(SQLException sqlException) {
				sqlException.printStackTrace();
				close();
			}
		}
		return results;
	}
	
	public List<Student> getPeopleByLastName(String name){
		List<Student> results = null;
		ResultSet resultSet = null;
		
		try {
			selectStudentIDWEB.setString(1, name);
			
			resultSet = selectStudentIDWEB.executeQuery();
			
			results = new ArrayList<Student>();
			
			while(resultSet.next()) {
				results.add(new Student(
						resultSet.getString("stuName"),
						resultSet.getInt("stuID"),
						resultSet.getString("stuTeam"),
						resultSet.getString("stuUniq")));
			}
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}finally {
			try {
				resultSet.close();
			}catch(SQLException sqlException) {
				sqlException.printStackTrace();
				close();
			}
		}
		return results;
	}
	
	public int addPerson(String stuName, int stuID, String stuTeam, String stuUniq) {
		int result = 0;
		
		try {
			insertNewStudentWEB.setString(1, stuName);
			insertNewStudentWEB.setInt(2, stuID);
			insertNewStudentWEB.setString(3, stuTeam);
			insertNewStudentWEB.setString(4, stuUniq);
			
			result = insertNewStudentWEB.executeUpdate();
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}
	
	void close() {
		try {
			connection.close();
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
	
}

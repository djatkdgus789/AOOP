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

	private static final String URL = 
			"jdbc:mysql://localhost:3306/StuProgDB?characterEncoding=UTF-8&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";

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
			if(f.s == f.java.get("web")) {
				selectAllStudentWEB = 
						connection.prepareStatement("SELECT * FROM WEBPROG");
				selectStudentIDWEB = 
						connection.prepareStatement("SELECT * FROM WEBPROG WHERE stuID = ?");
				insertNewStudentWEB = connection.prepareStatement(
						"INSERT INTO WEBPROG " +
								"(stuName, stuID, stuTeam, stuUniq) " +
						"VALUES (?, ?, ?, ?)");
			}else if(f.s == f.java.get("oop")) {
				selectAllStudentOOP = 
						connection.prepareStatement("SELECT * FROM OOP");
				selectStudentIDOOP = 
						connection.prepareStatement("SELECT * FROM OOP WHERE stuID = ?");
				insertNewStudentOOP = connection.prepareStatement(
						"INSERT INTO OOP " +
								"(stuName, stuID, stuTeam, stuUniq) " +
						"VALUES (?, ?, ?, ?)");
			}else if(f.s == f.java.get("AOOP")){
				selectAllStudentAOOP = 
						connection.prepareStatement("SELECT * FROM AOOP");
				selectStudentIDAOOP = 
						connection.prepareStatement("SELECT * FROM AOOP WHERE stuID = ?");
				insertNewStudentAOOP = connection.prepareStatement(
						"INSERT INTO AOOP " +
								"(stuName, stuID, stuTeam, stuUniq) " +
						"VALUES (?, ?, ?, ?)");
			}
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		}
	}

	public List<Student> getAllStudent(){
		List<Student> results = null;
		ResultSet resultSet = null;

		try {
			if(f.s == f.java.get("web")) {
				resultSet = selectAllStudentWEB.executeQuery();
			}else if(f.s == f.java.get("oop")) {
				resultSet = selectAllStudentOOP.executeQuery();
			}else if(f.s == f.java.get("aoop")) {
				resultSet = selectAllStudentAOOP.executeQuery();
			}

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

	public List<Student> getStudentID(String stuID){
		List<Student> results = null;
		ResultSet resultSet = null;

		try {
			if(f.s == f.java.get("web")) {
				selectStudentIDWEB.setString(1, stuID);
				resultSet = selectStudentIDWEB.executeQuery();
			}else if(f.s == f.java.get("oop")) {
				selectStudentIDOOP.setString(1, stuID);
				resultSet = selectStudentIDOOP.executeQuery();
			}else if(f.s == f.java.get("aoop")) {
				selectStudentIDAOOP.setString(1, stuID);
				resultSet = selectStudentIDAOOP.executeQuery();
			}

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
			if(f.s == f.java.get("web")) {
				insertNewStudentWEB.setString(1, stuName);
				insertNewStudentWEB.setInt(2, stuID);
				insertNewStudentWEB.setString(3, stuTeam);
				insertNewStudentWEB.setString(4, stuUniq);
				result = insertNewStudentWEB.executeUpdate();
			}else if(f.s == f.java.get("oop")){
				insertNewStudentOOP.setString(1, stuName);
				insertNewStudentOOP.setInt(2, stuID);
				insertNewStudentOOP.setString(3, stuTeam);
				insertNewStudentOOP.setString(4, stuUniq);
				result = insertNewStudentOOP.executeUpdate();
			}else if(f.s == f.java.get("aoop")){
				insertNewStudentAOOP.setString(1, stuName);
				insertNewStudentAOOP.setInt(2, stuID);
				insertNewStudentAOOP.setString(3, stuTeam);
				insertNewStudentAOOP.setString(4, stuUniq);
				result = insertNewStudentAOOP.executeUpdate();
			}
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

	public static void main(String[] args) {
		Frame f = new Frame();
		f.s = f.java.get("web");

		new StudentPersonQuery();
	}

}

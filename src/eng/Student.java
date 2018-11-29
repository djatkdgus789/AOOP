package eng;
import java.util.Map;

public class Student {
	private String name; // 이름
	private int std_num; // 학번
	private int team; // 팀
	private String unique; // 특이사항
	private Score score;	// 점수 관리 객체  
	private Attend attend; // 출석 관리 객체 
	private double total; // 과목 반영 비율이 반영된 총점  
	private String grade; // 등급
	private int rank; // 등수
	
	

	
	// 학생 생성자
	public Student(String name, int num, int team, String unique) {
		this.name = name;
		this.std_num = num;
		this.team = team;
		this.unique = unique;
		attend = new Attend();
		score = new Score();
	}
	
	public Attend getAttend() {
		return attend;
	}

	public void setAttend(Attend attend) {
		this.attend = attend;
	}

	public void addScore(){ // 점수 객체에 점수를 추가한다.
		
	}
	public void calcTotal() { // 과목이 가지고 있는 반영비율을 받아와 총점을 계산함.
		
	}
	public int getRank() { // 현재학생의 등수를 계산해준다.
		return rank;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getUnique() {
		return unique;
	}
	// 이름 getter
	public String getName() {
		return name;
	}
	// 이름 setter
	public void setName(String name) {
		this.name = name;
	}

	// 학번 getter
	public int getStd_num() {
		return std_num;
	}
	
	// 학번 setter
	public void setStd_num(int std_num) {
		this.std_num = std_num;
	}
	
	// 팀 getter
	public int getTeam() {
		return team;
	}

	// 팀 setter
	public void setTeam(int team) {
		this.team = team;
	}
	// 특이사항 setter
	public void setUnique(String unique) {
		this.unique = unique;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}
}



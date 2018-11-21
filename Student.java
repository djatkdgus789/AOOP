package eng;
import java.util.Map;

public class Student{
	private String name; // 이름
	private int std_num; // 학번
	private int team; // 팀
	private String unique; // 특이사항
	public Attend attend;
	
	

	
	// 학생 생성자
	public Student(String name, int num, int team, String unique) {
		this.name = name;
		this.std_num = num;
		this.team = team;
		this.unique = unique;
		attend = new Attend();
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
}

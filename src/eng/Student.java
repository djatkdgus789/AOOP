package eng;

import java.util.Map;

public class Student {
	private String name; // 이름
	private int std_num; // 학번
	private String team; // 팀
	private String unique; // 특이사항
	private Score score; // 점수 관리 객체
	private Attend attend; // 출석 관리 객체
	private double total; // 과목 반영 비율이 반영된 총점
	private String grade; // 등급
	private int rank; // 등수

	// 학생 생성자
	public Student(String name, int num, String team, String unique) {
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



	public int getRank() {
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
	public String getTeam() {
		return team;
	}

	// 팀 setter
	public void setTeam(String team) {
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

	public String toString() {
		String str = null;
		String n = this.getName();
		int num = this.getStd_num();
		double mid = score.getMid();
		double last = score.getLast();
		double assign = score.getAssignment();
		double report = score.getReport();
		double quiz = score.getQuiz();
		double pres = score.getPresentation();
		int attend = getAttend().getAttend();
		double total = this.total;

		str = (String.format("%s %10d %8.2f %8.2f %8.2f %8.2f %8.2f %8.2f %10d %10f" 
				, n,num,mid,last,assign,report,quiz,pres,attend,total));

		return str;
	}
}

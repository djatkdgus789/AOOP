package eng;

public class Score {
	private int attend; // 출석 점수	
	private int mid; // 중간고사 점수
	private int last; // 기말고사 점수
	private int assignment; // 과제
	private int report; //보고서
	private int quiz; //퀴즈
	private int presentation; //발표
		
	
	public int getAttend() {
		return attend;
	}
	public void setAttend(int attend) {
		this.attend = attend;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	public int getAssignment() {
		return assignment;
	}
	public void setAssignment(int assignment) {
		this.assignment = assignment;
	}
	public int getReport() {
		return report;
	}
	public void setReport(int report) {
		this.report = report;
	}
	public int getQuiz() {
		return quiz;
	}
	public void setQuiz(int quiz) {
		this.quiz = quiz;
	}
	public int getPresentation() {
		return presentation;
	}
	public void setPresentation(int presentation) {
		this.presentation = presentation;
	}
}
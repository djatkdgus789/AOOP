package eng;

public class Score {
	private int mid; // 중간고사 점수
	private int last; // 기말고사 점수
	private int assignment; // 과제
	private int report; // 보고서
	private int quiz; // 퀴즈
	private int presentation; // 발표

	// 중간고사 getter
	public int getMid() {
		return mid;
	}
	// 중간고사 setter
	public void setMid(int mid) {
		this.mid = mid;
	}
	// 기말고사 getter
	public int getLast() {
		return last;
	}
	// 기말고사 setter
	public void setLast(int last) {
		this.last = last;
	}
	// 과제 getter
	public int getAssignment() {
		return assignment;
	}
	// 과제 setter
	public void setAssignment(int assignment) {
		this.assignment = assignment;
	}
	// 보고서 getter
	public int getReport() {
		return report;
	}
	// 보고서 settere
	public void setReport(int report) {
		this.report = report;
	}
	// 퀴즈 getter
	public int getQuiz() {
		return quiz;
	}
	// 퀴즈 setter
	public void setQuiz(int quiz) {
		this.quiz = quiz;
	}
	// 발표 getter
	public int getPresentation() {
		return presentation;
	}
	// 발표 setter
	public void setPresentation(int presentation) {
		this.presentation = presentation;
	}
}
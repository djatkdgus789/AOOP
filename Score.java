package eng;
import java.util.HashMap;
import java.util.Map;

public class Score {
	public int std_num;
	public Map<String, Integer> attend; // 출석 점수	
	public Map<String, Integer> mid; // 중간고사 점수
	public Map<String, Integer> last; // 기말고사 점수
	public Map<String, Integer> assignment; // 과제
	public Map<String, Integer> report; //보고서
	public Map<String, Integer> quiz; //퀴즈
	public Map<String, Integer> presentation; //발표
	public Map<String, String> grade; // 등급 
	public Map<String, Integer> total_score;
	
	
	Score(String subj, int std_num){
		this.std_num = std_num;
		attend = new HashMap <String, Integer>();
		mid = new HashMap <String, Integer>(); // 중간고사 점수
		last = new HashMap <String, Integer>(); // 기말고사 점수
		assignment= new HashMap <String, Integer>(); // 과제
		report = new HashMap <String, Integer>(); //보고서
		quiz=new HashMap <String, Integer>(); //퀴즈
		presentation= new HashMap <String, Integer>(); //발표
		grade = new HashMap <String	,String>(); // 등급 
		total_score = new HashMap <String, Integer>();	// 총점 
		
		
	}
	public void setTotal(String sbj_name) {
		total_score.put(sbj_name, (mid.get(sbj_name)) + (last.get(sbj_name))+ (assignment.get(sbj_name)) +(report.get(sbj_name))
				+ quiz.get(sbj_name)+presentation.get(sbj_name) + (attend.get(sbj_name)));
	}
	// 중간 setter
	public void setMid(String sbj_name, int score) {
		this.mid.put(sbj_name, score);
	}
	// 중간 getter
	public int getMid(String sbj_name) {
		return this.mid.get(sbj_name);
	}
	// 기말 setter
	public void setLast(String sbj_name, int score) {
		this.last.put(sbj_name, score);
	}
	// 기말 getter
	public int getLast(String sbj_name) {
		return this.last.get(sbj_name);
	}
	// 과제 setter
	public void setAssign(String sbj_name, int score) {
		this.assignment.put(sbj_name, score);
	}
	// 과제 getter
	public int getAssign(String sbj_name) {
		return this.assignment.get(sbj_name);
	}
	// 발표 setter
	public void setPresent(String sbj_name, int score) {
		this.presentation.put(sbj_name, score);
	}
	// 발표 getter
	public int getPresent(String sbj_name) {
		return this.presentation.get(sbj_name);
	}
	// 퀴즈 setter
	public void setQuiz(String sbj_name, int score) {
		this.quiz.put(sbj_name, score);
	}
	// 퀴즈 getter
	public int getQuiz(String sbj_name) {
		return this.quiz.get(sbj_name);
	}
	// 보고서 setter
	public void setReport(String sbj_name, int score) {
		this.report.put(sbj_name, score);
	}
	// 보고서 getter
	public int getReport(String sbj_name) {
		return this.report.get(sbj_name);
	}
	// 줄석점수  setter
	public void setAttend(String sbj_name, int score) {
		this.attend.put(sbj_name, score);
		}
		// 출석점수  getter
	public int getAttend(String sbj_name) {
		return this.attend.get(sbj_name);
	}
}

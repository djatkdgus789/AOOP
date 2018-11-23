package eng;
import java.util.ArrayList;
import java.util.Comparator;

public class Subject {
	private String name;
	private int[] ratio = {15,15,15,15,10,10,10,10};
	private int[] weight = {25,25,10,10,10,10,10};
	

	public ArrayList<Student> std_list;
	public static ArrayList<Score> score_list;
	
	// 과목 생성자 F009~11
	public Subject(String name){
		this.name = name;
		this.std_list = new ArrayList<Student>(); 
	}
	
	static {
	score_list = new ArrayList<Score>();
	}
	// 성적 비율 수정
	public void changeRatio(int A_plus,int A_zero,	int B_plus,	int B_zero,	int C_plus,	int C_zero,	int D ,	int F ) {
		ratio[0] = A_plus;
		ratio[1] = A_zero;
		ratio[2] = B_plus;
		ratio[3] = B_zero;
		ratio[4] = C_plus;
		ratio[5] = C_zero;
		ratio[6] = D;
		ratio[7] = F;
	}
	
	// 점수 반영비율 수정 
	public void changeWeight(int mid,int last,int assign,int quiz, int pres,int report,int attend) {
		weight[0] = mid;
		weight[1] = last;
		weight[2] = assign;
		weight[3] = quiz;
		weight[4] = pres;
		weight[5] = report;
		weight[6] = attend;
		

	}


	// 학생 추가 F012
	public void addStudent(Student s) {
		this.std_list.add(s);
	}

	// 학생 삭제 
//	public void delStudent(Student student) {
//		if(std_list.contains(student)) {
//			std_list.remove(student);
//		} else {
//			return;//해당 학생 없음
//		}
//	}
// ConcurrentModificationException 발생  
	
	// 성적 입력,수정 F017~18
	public void addScore(int std_num, int mid, int last, int assign ,int quiz, int pres, int report, int attend) {
		score_list.forEach((x)->{
			if((x.getStd_num())==(std_num)) {
				x.setMid(this.name, (mid));
				x.setLast(this.name, (last));
				x.setAssign(this.name, (assign));
				x.setQuiz(this.name, (quiz));
				x.setPresent(this.name, pres);
				x.setReport(this.name, report);
				x.setAttend(this.name, attend);
				//this.calTotal(std_num);
				//this.calRank();
				return;
			}
			
		});
		Score s = new Score(this.name,std_num);
		s.setMid(this.name, (mid));
		s.setLast(this.name, (last));
		s.setAssign(this.name, (assign));
		s.setQuiz(this.name, (quiz));
		s.setPresent(this.name, pres);
		s.setReport(this.name, report);
		s.setAttend(this.name, attend);
		s.setRank(this.name, 0);
		score_list.add(s);
		//this.calTotal(std_num);
		//this.calRank();
	}
	
	public void addAttendence(String sbj_name, int std_num, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8
			, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
		std_list.forEach((s)->{
			if((s.getStd_num())==(std_num)) {
				s.attend.check(i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16);
			}
		});
	}

	public String getName() {
		return name;
	}


	//평균 getter

	
	//중간고사 오름차순 정렬
	public void sort_mid_Score_Ascending() {
		Subject.score_list.sort(new Comparator<Score>() {
			@Override
			public int compare(Score o1, Score o2) {
				if(o1.getMid(name) - o2.getMid(name) > 0) {
					return 0;
				} else {
					return -1;
				}
			}
		});
	
	}
	// 학번순 정렬
	public void sortStd_num_Ascending() {
		this.std_list.sort(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.getStd_num() - o2.getStd_num() > 0) {
					return 0;
				} else {
					return -1;
				}
			}
		});
	}
	// 등수 계산 
	public void calRank() {
		Score temp = score_list.get(0);
		for(int i = 0; i < score_list.size(); i++) {
			for(int j = 0; j < score_list.size(); j++) {
				if(temp.getRank(this.name) != 0) {
					continue;
				}else if((temp.getTotal_score(this.name) < score_list.get(j).getTotal_score(this.name))) {
					temp = score_list.get(j);
				}
			}
			temp.setRank(this.name, i+1);
		}
	}
	
	public int getRank(int std_num) {
		int temp = 0;
		for(Score score : score_list) {
			if(score.getStd_num() == std_num) {
				return score.getRank(this.name);
			}
		}
		return temp;
	}
	
	// 등급 계산 
	public void calGrade() {
		for(Score score : score_list) {
			
		}
	}

	public void calTotal(int std_num) {
		for(Score score : score_list) {
			if(score.getStd_num() == std_num) {
/*				
				weight[0] = mid;
				weight[1] = last;
				weight[2] = assign;
				weight[3] = quiz;
				weight[4] = pres;
				weight[5] = report;
				weight[6] = attend;
*/	
				score.addTotal_score(this.name, score.getMid(this.name) * this.weight[0]);
				score.addTotal_score(this.name, score.getLast(this.name) * this.weight[1]);
				score.addTotal_score(this.name, score.getAssign(this.name) * this.weight[2]);
				score.addTotal_score(this.name, score.getQuiz(this.name) * this.weight[3]);
				score.addTotal_score(this.name, score.getPresent(this.name) * this.weight[4]);
				score.addTotal_score(this.name, score.getReport(this.name) * this.weight[5]);
				score.addTotal_score(this.name, score.getAttend(this.name) * this.weight[6]);
			}
		}
	}
	
	public double calAverofMid() {
		int total_mid = 0;
		for(Score score : score_list) {
			total_mid += score.getMid(this.name);
		}
		
		return total_mid /std_list.size();
	}
	public double calAverofLast() {
		int total_last = 0;
		for(Score score : score_list) {
			total_last += score.getLast(this.name);
		}
		return total_last /std_list.size();
	}
	public double calAverofAssignment() {
		int total_assign = 0;
		for(Score score : score_list) {
			total_assign += score.getAssign(this.name);
		}
		return total_assign /std_list.size();
	}
	public double calAverofReport() {
		int total_report = 0;
		for(Score score : score_list) {
			total_report += score.getReport(this.name);
		}
		return total_report /std_list.size();
	}
	
	public double calAverofPresentation() {
		int total_presentation = 0;
		for(Score score : score_list) {
			total_presentation += score.getPresent(this.name);
		}return total_presentation /std_list.size();
	}
	
	public double calAverofQuiz() {
		int total_quiz = 0;
		for(Score score : score_list) {
			total_quiz += score.getQuiz(this.name);
		}return total_quiz /std_list.size();
	}
	
	public double getAverofTotal() {
		int total_total = 0;
		for(Score score : score_list) {
			total_total += score.getTotal_score(this.name);
		}
		return total_total / std_list.size();
	}
	
	// 표준편차 계산
	public void calDevi() {
	} 
	
	public void view(String subj) {
		std_list.forEach((x)-> {
			
			System.out.print(name);
			System.out.print("    ");
			System.out.print(x.getName());
			System.out.print("    ");
			System.out.print(x.getStd_num());
			System.out.print("    ");
			System.out.println(x.getTeam());
		});
		score_list.forEach((x)->{
			System.out.print(x.getMid(this.name));
			System.out.print(x.getLast(this.name));
			System.out.print(x.getAssign(this.name));
			System.out.print(x.getQuiz(this.name));
			System.out.print(x.getPresent(this.name));
			System.out.print(x.getReport(this.name));
			System.out.println(x.getAttend(this.name));
		});
	}
	public void viewAttend() {
		std_list.forEach((x)->{
			for(int i :x.attend.getAttend()) {
				System.out.print(i);
			};
			System.out.println(x.attend.getScore());
		});
	}

	public int[] getWeight() {
		return weight;
	}

	public void setWeight(int[] weight) {
		this.weight = weight;
	}

	public int[] getRatio() {
		return ratio;
	}

	public void setRatio(int[] ratio) {
		this.ratio = ratio;
	}
	// 해당 학생의 등급을 반환 
	public String getStdGrade(int std_num) {
		String grade = "";
		for(Score score : score_list) {
			if(score.getStd_num() == std_num) {
				return score.getGrade(this.name);
			}
		}
		return grade;
	}
	
	
}









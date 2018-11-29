package eng;
import java.util.ArrayList;
import java.util.Comparator;

public class Subject {
	private String name;
	private int[] ratio = {15,15,15,15,10,10,10,10};
	private int[] weight = {25,25,10,10,10,10,10};
	

	public ArrayList<Student> std_list;
	
	// 과목 생성자 F009~11
	public Subject(String name){
		this.name = name;
		this.std_list = new ArrayList<Student>(); 
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
	public void addScore(int std_num, int mid, int last, int assign ,int quiz, int pres, int report) {
		std_list.forEach((x)->{
			if((x.getStd_num())==(std_num)) {
				x.getScore().setMid(mid);
				x.getScore().setLast(last);
				x.getScore().setAssignment(assign);
				x.getScore().setQuiz(quiz);
				x.getScore().setPresentation(pres);
				x.getScore().setReport(report);
				return;
			}
			
		});
		/*Student student = new Student(name, num, team, unique)
		s.setMid(, (mid));
		s.setLast(, (last));
		s.setAssign(, (assign));
		s.setQuiz(, (quiz));
		s.setPresent(, pres);
		s.setReport(, report);
		//s.setAttend(, attend);
		s.setRank(, 0);
		this.calTotal(std_num);
		this.calRank();*/
	}
	
	public void addAttendence(String sbj_name, int std_num, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8
			, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
		std_list.forEach((s)->{
			if((s.getStd_num())==(std_num)) {
				s.getAttend().check(i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16);
			}
		});

	}

	public String getName() {
		return name;
	}


	//평균 getter

	
	//중간고사 오름차순 정렬
	public void sort_mid_Score_Ascending() {
		this.std_list.sort(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.getScore().getMid() - o2.getScore().getMid() > 0) {
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
		
	}
	
	public int Rank(int std_num) {
		this.calTotal(std_num);
		this.calRank();
		int temp = 0;
		for(Student student : std_list) {
			if(student.getStd_num() == std_num) {
				return student.getRank();
			}
		}
		return temp;
	}
	
	// 등급 계산 
	public void calGrade() {
		
	}

	public void calTotal(int std_num) {
		for(Student student : std_list) {
			if(student.getStd_num() == std_num) {
/*				
				weight[0] = mid;
				weight[1] = last;
				weight[2] = assign;
				weight[3] = quiz;
				weight[4] = pres;
				weight[5] = report;
				weight[6] = attend;
*/		
				double total = 0;
				total += student.getScore().getMid() * weight[0];
				total += student.getScore().getLast() * weight[1];
				total += student.getScore().getAssignment() * weight[2];
				total += student.getScore().getQuiz() * weight[3];
				total += student.getScore().getPresentation() * weight[4];
				total += student.getScore().getReport() * weight[5];
				total += student.getScore().getAttend() * weight[6];
				
				//student.getScore().setTotal_score( total/100);
			}
		}
	}
	
	public double calAverofMid() {
		int total_mid = 0;
		for(Student student : std_list) {
			total_mid += student.getScore().getMid();
		}
		
		return total_mid /std_list.size();
	}
	public double calAverofLast() {
		int total_last = 0;
		for(Student student : std_list) {
			total_last += student.getScore().getLast();
		}
		return total_last /std_list.size();
	}
	public double calAverofAssignment() {
		int total_assign = 0;
		for(Student student : std_list) {
			total_assign += student.getScore().getAssignment();
		}
		return total_assign /std_list.size();
	}
	public double calAverofReport() {
		int total_report = 0;
		for(Student student : std_list) {
			total_report += student.getScore().getReport();
		}
		return total_report /std_list.size();
	}
	
	public double calAverofPresentation() {
		int total_presentation = 0;
		for(Student student : std_list) {
			total_presentation += student.getScore().getPresentation();
		}return total_presentation /std_list.size();
	}
	
	public double calAverofQuiz() {
		int total_quiz = 0;
		for(Student student : std_list) {
			total_quiz += student.getScore().getQuiz();
		}return total_quiz /std_list.size();
	}
	
	public double getAverofTotal() {
		int total_total = 0;
		for(Student student : std_list) {
			total_total += student.getTotal();
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
		std_list.forEach((x)->{
			System.out.print(x.getScore().getMid());
			System.out.print(x.getScore().getLast());
			System.out.print(x.getScore().getAssignment());
			System.out.print(x.getScore().getQuiz());
			System.out.print(x.getScore().getPresentation());
			System.out.print(x.getScore().getReport());
			System.out.println(x.getScore().getAttend());
		});
	}
	public void viewAttend() {
		/*std_list.forEach((x)->{
			for(int i : x.score.getAttend()) {
				System.out.print(i);
			};
			System.out.println(x.attend.getScore());
		});*/
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
		for(Student student : std_list) {
			if(student.getStd_num() == std_num) {
				return student.getGrade();
			}
		}
		return grade;
	}
	
	
}









package eng;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Subject {
	private String name; // 과목 이
	private int[] ratio = { 15, 15, 15, 15, 10, 10, 10, 10 }; // 학점 비율
	private int[] weight = { 25, 25, 10, 10, 10, 10, 10 }; // 점수 가중치 

	public ArrayList<Student> std_list; // 학생들이 저장되어 있는 ArrayList

	// 과목 생성자 F009~11
	public Subject(String name) {
		this.name = name;
		this.std_list = new ArrayList<Student>();
	}
	// 이름 getter
	public String getName() {
		return name;
	}
	// 비율 getter
	public int[] getRatio() {
		return ratio;
	}
	// 비율 setter
	public void setRatio(int[] ratio) {
		this.ratio = ratio;
	}
	// 가중치 getter
	public int[] getWeight() {
		return weight;
	}
	// 가중치 setter
	public void setWeight(int[] weight) {
		this.weight = weight;
	}
	
	// 등수 getter
	public int getRank(int std_num) {
		int temp = 0;
		for (Student student : std_list) {
			if (student.getStd_num() == std_num) {
				return student.getRank();
			}
		}
		return temp;
	}

	// 19 : 해당 학생의 등급을 반환
	public String getStdGrade(int std_num) {
		String grade = "";
		for (Student student : std_list) {
			if (student.getStd_num() == std_num) {
				return student.getGrade();
			}
		}
		return grade;
	}


	// 성적 비율 수정
	public void changeRatio(int A_plus, int A_zero, int B_plus, int B_zero, int C_plus, int C_zero, int D, int F) {
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
	public void changeWeight(int mid, int last, int assign, int quiz, int pres, int report, int attend) {
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
		this.std_list.forEach(x -> {
			if(x.getStd_num() == s.getStd_num()) {
				System.out.println("학번 중복" + s.getStd_num());
				return;
			}
		});
		this.std_list.add(s);
	}

	// 학생 삭제
	 public void delStudent(int std_num) {
		 Iterator<Student> iter = this.std_list.iterator();
			while (iter.hasNext()) {
				Student x = iter.next();
				if (x.getStd_num() == std_num)
					iter.remove();
			}
	 }
	// ConcurrentModificationException 발생

	// 성적 입력,수정 F017~18
	public void addScore(int std_num, int mid, int last, int assign, int quiz, int pres, int report) {
		std_list.forEach((x) -> {
			if ((x.getStd_num()) == (std_num)) {
				x.getScore().setMid(mid);
				x.getScore().setLast(last);
				x.getScore().setAssignment(assign);
				x.getScore().setQuiz(quiz);
				x.getScore().setPresentation(pres);
				x.getScore().setReport(report);
				this.calTotal(std_num);
			}

		});
		calRank();
	}

	public void addAttendence(int std_num, int i1, int i2, int i3, int i4, int i5, int i6, int i7,
			int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
		std_list.forEach((x) -> {
			if ((x.getStd_num()) == std_num) {
				x.getAttend().check(i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16);
			}
		});
		calRank();
	}


	// 평균 getter

	// total 오름차순 정렬
	public void sort_total_Score_Ascending() {
		this.std_list.sort(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return Double.compare(o1.getTotal(), o2.getTotal());
			}
		});

	}
	// total 오름차순 정렬
	public void sort_total_Score_Descending() {
		this.std_list.sort(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return Double.compare(o2.getTotal(), o1.getTotal());
			}
		});

	}

	// 학번순 정렬
	public void sort_Std_num_Ascending() {
		this.std_list.sort(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return Integer.compare(o1.getStd_num(), o2.getStd_num());
			}
		});
	}

	// 등수 계산
	public void calRank() {
		Student temp;
		// 모든 학생의 등수를 0으로 초기화 
		std_list.forEach(s -> {
			s.setRank(0);
		});
		temp = std_list.get(0);
		
		for (int i = 0; i < std_list.size(); i++) {
			// temp의초기값 설정, Rank가 0이 아닌 배열이 와야함 
			for (int j = 0; j < std_list.size(); j++) {
				if(std_list.get(j).getRank() == 0) {
					temp = std_list.get(j);
					break;
				}
			}
			
			// 랭크가 0인 학생들 중에서 총점이 제일 큰 학생을 찾음 
			for (int j = 0; j < std_list.size(); j++) {	
				if(temp.getTotal() < std_list.get(j).getTotal() && std_list.get(j).getRank() == 0 ) {
					temp = std_list.get(j);
				}
			}
			//찾은 학생의 등수를 설정 
			temp.setRank(i+1);
		}
	}

	// 등급 계산 15, 15, 15, 15, 10, 10, 10, 10
	public void calGrade(int std_num) {
		for (Student student : std_list) {
			if (student.getStd_num() == std_num) {
				float percent;
				
				percent = student.getRank()*100/std_list.size();
				
				System.out.println(percent);
				System.out.println(student.getRank());
				if(percent <= ratio[0]) {
					student.setGrade("A+");
				}
				else if(percent > ratio[0] && percent <= ratio[0]+ratio[1]) {
					student.setGrade("A0");
				}
				else if(percent > ratio[0]+ratio[1] && percent <= ratio[0]+ratio[1]+ratio[2]) {
					student.setGrade("B+");
				}
				else if(percent > ratio[0]+ratio[1]+ratio[2] 
						&& percent <= ratio[0]+ratio[1]+ratio[2]+ratio[3]) {
					student.setGrade("B0");
				}
				else if(percent > ratio[0]+ratio[1]+ratio[2]+ratio[3] 
						&& percent <= ratio[0]+ratio[1]+ratio[2]+ratio[3]+ratio[4]) {
					student.setGrade("C+");
				}
				else if(percent > ratio[0]+ratio[1]+ratio[2]+ratio[3]+ratio[4] 
						&& percent <= ratio[0]+ratio[1]+ratio[2]+ratio[3]+ratio[4]+ratio[5]) {
					student.setGrade("C0");
				}
				else if(percent > ratio[0]+ratio[1]+ratio[2]+ratio[3]+ratio[4]+ratio[5] 
						&& percent <= ratio[0]+ratio[1]+ratio[2]+ratio[3]+ratio[4]+ratio[5]+ratio[6]) {
					student.setGrade("D");
				}
				else if(percent > ratio[0]+ratio[1]+ratio[2]+ratio[3]+ratio[4]+ratio[5]+ratio[6]
						&&percent <= ratio[0]+ratio[1]+ratio[2]+ratio[3]+ratio[4]+ratio[5]+ratio[6]+ratio[7]) {
					student.setGrade("F");
				}
			}
		}
	}


	// 총점 계산 
	public void calTotal(int std_num) {
		for (Student student : std_list) {
			if (student.getStd_num() == std_num) {
				/*
				 * weight[0] = mid; weight[1] = last; weight[2] = assign; weight[3] = quiz;
				 * weight[4] = pres; weight[5] = report; weight[6] = attend;
				 */
				double total = 0;
				total += student.getScore().getMid() * weight[0];
				total += student.getScore().getLast() * weight[1];
				total += student.getScore().getAssignment() * weight[2];
				total += student.getScore().getQuiz() * weight[3];
				total += student.getScore().getPresentation() * weight[4];
				total += student.getScore().getReport() * weight[5];
				total += student.getAttend().getAttend() * weight[6];

				student.setTotal(total / 100);
			}
		}
	}

	public double calAverofMid() {
		int total_mid = 0;
		for (Student student : std_list) {
			total_mid += student.getScore().getMid();
		}

		return total_mid / std_list.size();
	}

	public double calAverofLast() {
		int total_last = 0;
		for (Student student : std_list) {
			total_last += student.getScore().getLast();
		}
		return total_last / std_list.size();
	}

	public double calAverofAssignment() {
		int total_assign = 0;
		for (Student student : std_list) {
			total_assign += student.getScore().getAssignment();
		}
		return total_assign / std_list.size();
	}

	public double calAverofReport() {
		int total_report = 0;
		for (Student student : std_list) {
			total_report += student.getScore().getReport();
		}
		return total_report / std_list.size();
	}

	public double calAverofPresentation() {
		int total_presentation = 0;
		for (Student student : std_list) {
			total_presentation += student.getScore().getPresentation();
		}
		return total_presentation / std_list.size();
	}

	public double calAverofQuiz() {
		int total_quiz = 0;
		for (Student student : std_list) {
			total_quiz += student.getScore().getQuiz();
		}
		return total_quiz / std_list.size();
	}

	public double getAverofTotal() {
		int total_total = 0;
		for (Student student : std_list) {
			total_total += student.getTotal();
		}
		return total_total / std_list.size();
	}

	// 총점에 대한 표준편차 계산
	public double calDevi() {
		double devi = 0;
		for (Student s:this.std_list) {
			devi += Math.pow(s.getTotal()-this.getAverofTotal(),2);
		}
		devi = Math.sqrt(devi/this.std_list.size());
		return devi; 

	}


	public String check(int std_num) {
		for (Student student : std_list) {
			if(student.getStd_num() == std_num) {
				double rank = student.getRank();
				double size = std_list.size();
				return Double.toString(rank/size*100);
			}
		}
		return "학생이 없습니다";
	}

}

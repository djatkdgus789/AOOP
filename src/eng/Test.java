package eng;

public class Test {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Frame f = new Frame();
		f.s = f.java.get("web");

		Student s = new Student("엄상", 1, 1, "reqqer");
		f.s.addStudent(s);
		s = new Student("꼼상", 2, 1, "ㅁㄴ");
		f.s.addStudent(s);
		s = new Student("밥상", 3, 1, "ㅇㄹ");
		f.s.addStudent(s);
		s = new Student("라면", 5, 1, "ㅇㄹ");
		f.s.addStudent(s);
		s = new Student("상현", 7, 1, "ㅇㄹ");
		f.s.addStudent(s);
		System.out.println(f.s.std_list.size());
		f.s.addAttendence(1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		f.s.addAttendence(2, -1, -1, -1, 0, 0, 0, -3, -3, -3, -3, 0, 0, 0, 0, 0, 0);

		f.s.addScore(1, 30, 30, 30, 30, 30, 30);
		f.s.addScore(2, 10, 10, 10, 10, 10, 10);
		f.s.addScore(3, 20, 20, 20, 20, 20, 20);
		f.s.addScore(5, 100, 100, 100, 100, 100, 100);
		f.s.addScore(7, 20, 20, 20, 20, 20, 20);
		// System.out.println(f.s.getAverofTotal() + f.s.getRank(60152208) +
		// f.s.getRank(60152215) + f.s.getRank(60171523));
		// f.s.sort_Std_num_Ascending();
		f.s.view("web");


		f.s.view("web");
		f.s.viewAttend();
	}

}

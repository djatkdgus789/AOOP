package eng;

public class Test {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
//		Subject web = new Subject("web"); 
		Frame f = new Frame();
		f.s = f.java.get("web");

		Student s = new Student("엄상", 60152208, 1,"reqqer");
		f.s.addStudent(s);
		s = new Student("꼼상", 60152215, 1,"ㅁㄴ");
		f.s.addStudent(s);
		s = new Student("밥상", 60171523, 1,"ㅇㄹ");
		f.s.addStudent(s);
		System.out.println(f.s.std_list.size());
		
		f.s.addAttendence("web", 60152208,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0);
		f.s.addAttendence("web", 60152215,1,1,1,0,0,0,-3,-3,-3,-3,0,0,0,0,0,0);
		
		f.s.addScore(60152208, 30, 10, 10, 10, 10, 10);
		f.s.addScore(60152215, 20, 20, 20, 20, 20, 20);
		f.s.addScore(60171523, 30, 30, 30, 30, 30, 30);
		System.out.println(f.s.getAverofTotal() + f.s.getRank(60152208) + f.s.getRank(60152215) + f.s.getRank(60171523));
		
//
//		web.sortStd_num_Ascending();
//		web.view("web");
//		
//		web.sort_mid_Score_Ascending();
		f.s.view("web");
		f.s.getRank(60152208);
		f.s.viewAttend();
	}

}

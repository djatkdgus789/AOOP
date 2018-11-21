package eng;

public class Test {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Subject web = new Subject("web"); 
		new Frame();
//		Student s = new Student("엄상", 60152208, 1,"reqqer");
//		web.addStudent(s);
//		s = new Student("꼼상", 60152215, 1,"ㅁㄴ");
//		web.addStudent(s);
//		s = new Student("밥상", 60171523, 1,"ㅇㄹ");
//		web.addStudent(s);
//		
//		web.addScore(60152208, 100, 101, 102, 103, 104, 105,106);
//		web.addScore(60152215, 99, 99, 99, 99, 99, 99,100);
//		web.addAttendence("web", 60152208,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0);
//		web.addAttendence("web", 60152215,1,1,1,0,0,0,-3,-3,-3,-3,0,0,0,0,0,0);
//
//		web.sortStd_num_Ascending();
//		web.view("web");
//		
//		web.sort_mid_Score_Ascending();
//		web.view("web");
		
		web.viewAttend();
	}

}

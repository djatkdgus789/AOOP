package eng;

import java.io.IOException;
import java.io.PrintWriter;

public class FileWrite {
	Subject s;
	public FileWrite(Subject s) {
		// TODO Auto-generated constructor stub
		this.s = s;
		try {
			Write(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public static void Write(Subject s) throws IOException {
        PrintWriter pw = new PrintWriter("./out.txt");
        for(Student std : s.std_list) {
            String data = std.getName()+","+std.getStd_num()+","+std.getScore().getMid()+","+
            				std.getScore().getLast()+","+std.getScore().getAssignment()+","+
            				std.getScore().getQuiz()+","+std.getScore().getPresentation()+","+
            				std.getAttend().getI1()+","+std.getAttend().getI2()+","+std.getAttend().getI3()
            				+","+std.getAttend().getI4()+","+std.getAttend().getI5()+","+std.getAttend().getI6()
            				+","+std.getAttend().getI7()+","+std.getAttend().getI8()+","+std.getAttend().getI9()
            				+","+std.getAttend().getI10()+","+std.getAttend().getI11()+","+std.getAttend().getI12()
            				+","+std.getAttend().getI13()+","+std.getAttend().getI14()+","+std.getAttend().getI15()
            				+","+std.getAttend().getI16();
            pw.println(data);
            System.out.println(data);
        }
        pw.close();
    }
}

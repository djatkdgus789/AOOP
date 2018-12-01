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
            				std.getScore().getQuiz()+","+std.getScore().getPresentation();
            pw.println(data);
            System.out.println(data);
        }
        pw.close();
    }
}

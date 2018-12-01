package eng;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;;

public class FileRead {
	Subject s;
	public FileRead(Subject s) {
		// TODO Auto-generated constructor stub
		this.s = s;
		try {
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public static void Read(Subject s) throws IOException {
    	FileReader fr = new FileReader("./out.txt");
    	BufferedReader bf = new BufferedReader(fr);
    	String line = null;
    	String[] split = null;
    	while((line=bf.readLine()) != null){
    		split = line.split(",");
    		Student student = new Student(split[0], split[1], team, unique)
    	}
    	
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

package eng;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;;

public class FileRead {
	public FileRead(Subject s) {
		// TODO Auto-generated constructor stub
		try {
			Read(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public static void Read(Subject s) throws IOException {
    	FileReader fr = new FileReader("./input.csv");
    	BufferedReader bf = new BufferedReader(fr);
    	String line = null;
    	String[] split = null;
    	bf.readLine();
    	while((line=bf.readLine()) != null){
    		split = line.split(",");
    		Student student = new Student(split[0], Integer.parseInt(split[1]), split[2],
    				split[3]);
    		
    		s.addStudent(student);
    		s.addScore(Integer.parseInt(split[1]), Integer.parseInt(split[4]), Integer.parseInt(split[5]),
    				Integer.parseInt(split[6]), Integer.parseInt(split[7]), Integer.parseInt(split[8]), 
    				Integer.parseInt(split[9]));
    		s.addAttendence(Integer.parseInt(split[1]), Integer.parseInt(split[10]), Integer.parseInt(split[11]),
    				Integer.parseInt(split[12]), Integer.parseInt(split[13]), Integer.parseInt(split[14]),
    				Integer.parseInt(split[15]), Integer.parseInt(split[16]), Integer.parseInt(split[17]),
    				Integer.parseInt(split[18]), Integer.parseInt(split[19]), Integer.parseInt(split[20]),
    				Integer.parseInt(split[21]), Integer.parseInt(split[22]), Integer.parseInt(split[23]),
    				Integer.parseInt(split[24]), Integer.parseInt(split[25]));
    	}
    	fr.close();
    	bf.close();
    }
}

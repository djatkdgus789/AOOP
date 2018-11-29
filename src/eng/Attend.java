package eng;

//출석을 관리.
public class Attend {
	private static final int ABSENCE = -3;
	private static final int lATE = -1;
	private static final int ATTENDANCE = 0;
	
	private int attend;
	
	
	//출석 생성자 기본 16주
	Attend(){
		attend= 0;
	}
	
	public void initAttend() {
		this.attend = 0;
	}
	
	//출석입력,수정 F001, F002
	public void check(int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
		attend = 0;
		
		attend += i1;
		attend += i2;
		attend += i3;
		attend += i4;
		attend += i5;
		attend += i6;
		attend += i7;
		attend += i8;
		attend += i9;
		attend += i10;
		attend += i11;
		attend += i12;
		attend += i13;
		attend += i14;
		attend += i15;
		attend += i16;
	}
	//점수 getter
	public int getAttend() {
		return attend;
	}
	//출석 계산 

}

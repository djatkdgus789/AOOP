package eng;

//출석을 관리.
public class Attend {
	private static final int ABSENCE = -3; //결석 점수 
	private static final int lATE = -1; // 지각 점수 
	private static final int ATTENDANCE = 0; // 출석 

	private int attend;
	private int i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16;

	// 출석 생성자 기본 16주
	Attend() {
		attend = 100;
	}
	// 출석입력,수정 F001, F002
	public void check(int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12,
			int i13, int i14, int i15, int i16) {
		attend = 100;
		System.out.println(attend);
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

	// 점수 getter
	public int getAttend() {
		return attend;
	}
	public int getI1() {
		return i1;
	}
	public int getI2() {
		return i2;
	}
	public int getI3() {
		return i3;
	}
	public int getI4() {
		return i4;
	}
	public int getI5() {
		return i5;
	}
	public int getI6() {
		return i6;
	}
	public int getI7() {
		return i7;
	}
	public int getI8() {
		return i8;
	}
	public int getI9() {
		return i9;
	}
	public int getI10() {
		return i10;
	}
	public int getI11() {
		return i11;
	}
	public int getI12() {
		return i12;
	}
	public int getI13() {
		return i13;
	}
	public int getI14() {
		return i14;
	}
	public int getI15() {
		return i15;
	}
	public int getI16() {
		return i16;
	}
}

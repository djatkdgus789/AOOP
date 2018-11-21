package eng;


public class Attend {
	private static final int ABSENCE = -3;
	private static final int lATE = -1;
	private static final int ATTENDANCE = 0;
	
	int[] attend;
	
	Attend(){
		attend = new int[16];
	}
	
	public void check(int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
		attend[0] = i1;
		attend[1] = i2;
		attend[2] = i3;
		attend[3] = i4;
		attend[4] = i5;
		attend[5] = i6;
		attend[6] = i7;
		attend[7] = i8; 
		attend[8] = i9;
		attend[9] = i10;
		attend[10] = i11;
		attend[11] = i12;
		attend[12] = i13;
		attend[13] = i14;
		attend[14] = i15;
		attend[15] = i16;
	}
	public int getScore() {
		int score = 48;
		for (int i : attend) {
			if (i == 0) {
				score += ATTENDANCE;
			}
			else if(i == -1) {
				score += lATE;
			}
			else if(i == -3) {
				score += ABSENCE;
			}
		}
		if (score <= 48+ABSENCE*4) {
			return 0;
		}
		return score;
	}

	public int[] getAttend() {
		return attend;
	}

	
}

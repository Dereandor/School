package dp2;

import static lib.Out.out;

public class tabell3d {

	public static void main(String[] args) {		
	    
		int[][][] minTabell3d = new int[2][3][2];
		
		minTabell3d[0][0][0] = 10;
		minTabell3d[0][1][0] = 11;
		minTabell3d[0][2][0] = 20;
		minTabell3d[0][0][1] = 21;
		minTabell3d[0][1][1] = 30;
		minTabell3d[0][2][1] = 31;
		
		minTabell3d[1][0][0] = 40;
		minTabell3d[1][1][0] = 41;
		minTabell3d[1][2][0] = 50;
		minTabell3d[1][0][1] = 51;
		minTabell3d[1][1][1] = 60;
		minTabell3d[1][2][1] = 61;
	    
		
		out(minTabell3d[0][0][0]);
		out(minTabell3d[1][2][1]);
	}
}

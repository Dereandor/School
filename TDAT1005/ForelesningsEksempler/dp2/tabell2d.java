package dp2;

import static lib.Out.out;

public class tabell2d {

	public static void main(String[] args) {
		
		int[][] minTabell2d = new int[2][3];
		
		minTabell2d[0][0] = 10;
		minTabell2d[0][1] = 11;
		minTabell2d[0][2] = 12;
		minTabell2d[1][0] = 100;
		minTabell2d[1][1] = 110;
		minTabell2d[1][2] = 120;


		//Skriv ut hele tabellen
	    out(minTabell2d[0][0]);
	    out(minTabell2d[1][2]);
	}
}

package dp2;

import static lib.Out.out;

public class tabell1d {

	public static void main(String[] args) {
		
		int[] minTabell1d = new int[10];
		
		minTabell1d[0] = 10;
		minTabell1d[1] = 20;
		minTabell1d[2] = 30;
		minTabell1d[3] = 40;
		minTabell1d[4] = 50;
		minTabell1d[5] = 60;
		minTabell1d[6] = 70;
		minTabell1d[7] = 80;
		minTabell1d[8] = 90;
		minTabell1d[9] = 100;

		//Skriv ut et element
		out(minTabell1d[0]);
		
		//Skriv ut hele tabellen
	    out(minTabell1d);
	}
}

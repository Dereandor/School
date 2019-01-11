package dp2.kap7;

import static lib.Out.*;

public class Tabeller2 {
	
	public static void main(String[] args) {
		int[] tabellAvInt = new int[4];
		
		boolean[] tabellAvBool = new boolean[2];
		char[] tabellAvChar = new char[2];	
		String[] tabellAvStr = new String[2];
		
		out("\nUtskrift 1:");
		out(tabellAvInt);
		out(tabellAvBool);
		out(tabellAvChar);
		out(tabellAvStr);
		
		tabellAvInt[0] = 10;
		tabellAvInt[1] = 20;
		tabellAvInt[2] = 30;
		tabellAvInt[3] = 40;

		tabellAvChar[0] = 'A';
		tabellAvChar[1] = 'B';
		
		tabellAvStr[0] = "String A";
		tabellAvStr[1] = "String B";
		
		out("\nUtskrift 2:");
		out(tabellAvInt);
		out(tabellAvBool);
		out(tabellAvChar);
		out(tabellAvStr);

	}
}

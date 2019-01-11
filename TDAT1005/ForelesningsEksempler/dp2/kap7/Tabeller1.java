package dp2.kap7;

import static lib.Out.*;

public class Tabeller1 {
	int[] tabellAvInt = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	boolean[] tabellAvBool = { true,false};
	char[] tabellAvChar = { 'A','B'};	
	String[] tabellAvStr = { "Setning 1","Setning 2"};

	
	public static void main(String[] args) {
		Tabeller1 t = new Tabeller1();
		
		out(t.tabellAvInt);
		out(t.tabellAvBool);
		out(t.tabellAvChar);
		out(t.tabellAvStr);
	}
}

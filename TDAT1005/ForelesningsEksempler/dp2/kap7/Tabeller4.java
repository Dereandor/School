package dp2.kap7;

import static lib.Out.out;

public class Tabeller4 {
	
	public static void main(String[] args) {
		Student[] tabellAvStudenter1 = new Student[2];
		Student[] tabellAvStudenter2 = new Student[2];
		
		tabellAvStudenter1[0] = new Student("Slåttsgata 10",10);
		tabellAvStudenter1[1] = new Student("Søndregate 2",12);

		out("\nUtskrift 1:");
		out(tabellAvStudenter1);
		
		tabellAvStudenter2 = tabellAvStudenter1;
				
		out("\nUtskrift 2:");
		out(tabellAvStudenter1);
		out(tabellAvStudenter2);

		out("\nUtskrift 3:");
		tabellAvStudenter1[0].setStudnr(99);
		
		out(tabellAvStudenter1);
		out(tabellAvStudenter2);
		
	}
}



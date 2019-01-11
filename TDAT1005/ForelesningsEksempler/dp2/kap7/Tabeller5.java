package dp2.kap7;

import static lib.Out.out;

public class Tabeller5 {
	
	public static void main(String[] args) {
		Student[] tabellAvStudenter1 = new Student[2];
		Student[] tabellAvStudenter2 = new Student[2];
		
		tabellAvStudenter1[0] = new Student("Slåttsgata 10",10);
		tabellAvStudenter1[1] = new Student("Søndregate 2",12);

		out("\nUtskrift 1:");
		out(tabellAvStudenter1);
		
		for (int i=0;i<tabellAvStudenter1.length;i++) {
			tabellAvStudenter2[i] = new Student(
					tabellAvStudenter1[i].getPoststed(),
					tabellAvStudenter1[i].getStudnr());
		}
				
		out("\nUtskrift 2:");
		out(tabellAvStudenter1);
		out(tabellAvStudenter2);

		out("\nUtskrift 3:");
		tabellAvStudenter1[0].setStudnr(99);
		
		out(tabellAvStudenter1);
		out(tabellAvStudenter2);
		
	}
}



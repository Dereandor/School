package dp2.kap7;

import static lib.Out.out;

import eksempler.kap11.eks11_1.Student;

public class Tabeller3 {
	
	public static void main(String[] args) {
		Student[] tabellAvStudenter = new Student[2];
		
		out("\nUtskrift 1:");
		out(tabellAvStudenter);

		tabellAvStudenter[0] = new Student("Slåttsgata 10",10);
		tabellAvStudenter[1] = new Student("Søndregate 2",12);
		
		out("\nUtskrift 2:");
		out(tabellAvStudenter);

	}
}



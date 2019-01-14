package dp4.grensesnitt.eksempel2;

import static lib.Out.*;

public class AnimalClient {

	public static void main(String args[]) {

		//Have Dog and Cat same number of legs?
		
		Comparable<Object> cd = (Comparable<Object>) new Dog();
		Comparable<Object> cc = (Comparable<Object>) new Cat();
		Comparable<Object> cr = (Comparable<Object>) new Rooster();
		
		out("\nUtskrift 1: ");
		if (cd.compareTo(cc)==1) {
			out("Same number of legs");
		} else {
			out("Different number of legs");
		}

		out("\nUtskrift 2: ");
		if (cd.compareTo(cr)==1) {
			out("Same number of legs");
		} else {
			out("Different number of legs");
		}
		
	}
}

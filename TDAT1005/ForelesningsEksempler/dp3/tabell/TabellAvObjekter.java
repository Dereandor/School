package dp3.tabell;

import static lib.Out.out;

import dp3.Student;

public class TabellAvObjekter {

	public static void main(String[] args) {

		// Alternativ 1:
		Student[] gruppe1 = new Student[3];
		gruppe1[0] = new Student("Kåre", "Ulfsen", 19801212);
		gruppe1[1] = new Student("Anders", "Vik", 19770510);
		gruppe1[2] = new Student("Tove", "Ås", 19831002);

		out(gruppe1);

		// Alternativ 2:
		Student[] gruppe2 = { new Student("Nils", "Tesdal", 19801212), 
							  new Student("Majid", "Rouhani", 19770510),							  
							};
		
		out(gruppe2);

	}
}

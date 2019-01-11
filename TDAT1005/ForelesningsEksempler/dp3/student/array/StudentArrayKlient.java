package dp3.student.array;

import static lib.Out.*;

public class StudentArrayKlient {

	public static void main(String[] args) {
		Student[] gruppe = new Student[3];
		gruppe[0] = new Student("Kåre", "Ulfsen", 19801212);
		gruppe[1] = new Student("Anders", "Vik", 19770510);
		gruppe[2] = new Student("Tove", "Ås", 19831002);

		out("1. Gruppe: ");
		out(gruppe);

		Student[] kopier = new Student[3];

		for (int i = 0; i < gruppe.length; i++) {
			kopier[i] = gruppe[i];
		}
		
		out("2. Kopiert: ");
		out(kopier);
		
		gruppe[1] = new Student("Eva", "Ås", 19800506);
		gruppe[2].setEtternavn("Bjørndal");
		out("3. Oppdatert gruppe: ");
		out(gruppe);
		
		out("4. Kopier: ");
		out(kopier);
	}

}

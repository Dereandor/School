package dp12.register;

public class PersonRegisterKlient {
	/**
	 * Her kommer en meget ufullstendig test klient.
	 */
	public static void main(String[] args) {
		Student student1 = new Student(12106078756L, "Ole Pettersen", "Storgt 3, 7001 Trondheim", 1234567L);
		Student student2 = new Student(12125678756L, "Per Hansen", "Storgt 13, 7001 Trondheim", 1234557L);
		Ansatt l�reren = new Ansatt(15107078056L, "Hanne Hansen", "Storgt 13, 7001 Trondheim", 50);
		
		Personregister registeret = new Personregister();
		
		registeret.registrerNyPerson(l�reren);
		registeret.registrerNyPerson(student1);
		registeret.registrerNyPerson(student2);
		registeret.registrerNyttFag(12106078756L, "NTNU-LO172D"); // student1
		registeret.registrerNyttFag(12125678756L, "NTNU-LO451D"); // student2
		student2.registrerNyttFag("NTNU-LO451D");
		student1.settKarakter("NTNU-LO451D", 'C');
		student2.settKarakter("NTNU-LO451D", 'B');
		registeret.settKarakter(12106078756L, "NTNU-LO445D", 'F');

		char s�k1 = registeret.finnKarakter(12125678756L, "NTNU-LO172D"); // ugyldig fagnr for denne studenten
		char s�k2 = registeret.finnKarakter(12125678756L, "NTNU-LO451D");
		char s�k3 = registeret.finnKarakter(12106078756L, "NTNU-LO451D");
		char s�k4 = registeret.finnKarakter(12106078756L, "NTNU-LO445D");
		registeret.endreL�nn(15107078056L, 52); // endrer l�rerl�nnen via registeret

		if (s�k1 == 'Y' && s�k2 == 'B' && s�k3 == 'C' && s�k4 == 'F' && l�reren.getL�nnstrinn() == 52) {
			System.out.println("Testkj�ring ok.");
		} else {
			System.out.println("Testkj�ring ikke ok. Skal v�re Y B C F 52, det var: " + s�k1 + " " + s�k2 + " " + s�k3
					+ " " + s�k4 + " " + l�reren.getL�nnstrinn());
		}
	}

}

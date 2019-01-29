package dp12.register;

public class PersonRegisterKlient {
	/**
	 * Her kommer en meget ufullstendig test klient.
	 */
	public static void main(String[] args) {
		Student student1 = new Student(12106078756L, "Ole Pettersen", "Storgt 3, 7001 Trondheim", 1234567L);
		Student student2 = new Student(12125678756L, "Per Hansen", "Storgt 13, 7001 Trondheim", 1234557L);
		Ansatt læreren = new Ansatt(15107078056L, "Hanne Hansen", "Storgt 13, 7001 Trondheim", 50);
		
		Personregister registeret = new Personregister();
		
		registeret.registrerNyPerson(læreren);
		registeret.registrerNyPerson(student1);
		registeret.registrerNyPerson(student2);
		registeret.registrerNyttFag(12106078756L, "NTNU-LO172D"); // student1
		registeret.registrerNyttFag(12125678756L, "NTNU-LO451D"); // student2
		student2.registrerNyttFag("NTNU-LO451D");
		student1.settKarakter("NTNU-LO451D", 'C');
		student2.settKarakter("NTNU-LO451D", 'B');
		registeret.settKarakter(12106078756L, "NTNU-LO445D", 'F');

		char søk1 = registeret.finnKarakter(12125678756L, "NTNU-LO172D"); // ugyldig fagnr for denne studenten
		char søk2 = registeret.finnKarakter(12125678756L, "NTNU-LO451D");
		char søk3 = registeret.finnKarakter(12106078756L, "NTNU-LO451D");
		char søk4 = registeret.finnKarakter(12106078756L, "NTNU-LO445D");
		registeret.endreLønn(15107078056L, 52); // endrer lærerlønnen via registeret

		if (søk1 == 'Y' && søk2 == 'B' && søk3 == 'C' && søk4 == 'F' && læreren.getLønnstrinn() == 52) {
			System.out.println("Testkjøring ok.");
		} else {
			System.out.println("Testkjøring ikke ok. Skal være Y B C F 52, det var: " + søk1 + " " + søk2 + " " + søk3
					+ " " + søk4 + " " + læreren.getLønnstrinn());
		}
	}

}

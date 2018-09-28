/**
* Side 165
* Oppgaver 5.3
* Henter data fra klasse "Fag.java"
*
*/

import static javax.swing.JOptionPane.*;

class Oppgave5_3_1_165 {

	public static void main(String[]args) {

		String kode = showInputDialog("Fagkode: ");
		String antStudLest = showInputDialog("Antall studenter: ");

		int antStud = Integer.parseInt(antStudLest);
		Fag fag1 = new Fag(kode, antStud);

		Fag fag2 = fag1; //svar på oppgave 2
		fag1.setAntStud(fag1.getAntStud() + 5); //svar på oppgave 3
		System.out.println("Antall studenter er: " + fag2.getAntStud());

		showMessageDialog(null, "Du skrev fagkode: " + fag1.getFagkode() + " og ant stud = " + fag1.getAntStud());
	}
}
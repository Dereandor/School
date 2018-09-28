/**
* Side 112
* Programmeringsoppgaver 3.12
* Oppgave 1
*
*/

import static javax.swing.JOptionPane.*;

class Oppgave1_312 {

	public static void main(String[]args) {

		final int MAKS = 31;
		final int MIN = 01;
		String dagLest = showInputDialog("Din f�dselsdato (dd): ");
		int dag = Integer.parseInt(dagLest);

		String melding;
		if (dag > 100) {
			melding = "For h�yt tall, m� v�re mellom " + MIN + " og " + MAKS + ".";
		} else if (dag >= 26) {
			melding = "Du skal p� kontor 134.";
		} else if (dag >= 15) {
			melding = "Du skal p� kontor 125.";
		} else if (dag >= 9) {
			melding = "Du skal p� kontor 120.";
		} else if (dag >= 1) {
			melding = "Du skal p� kontor 113.";
		} else {
			melding = "Tallet kan ikke v�re negativt eller 0.";
		}

		showMessageDialog(null, melding);

	}
}
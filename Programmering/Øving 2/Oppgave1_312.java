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
		String dagLest = showInputDialog("Din fødselsdato (dd): ");
		int dag = Integer.parseInt(dagLest);

		String melding;
		if (dag > 100) {
			melding = "For høyt tall, må være mellom " + MIN + " og " + MAKS + ".";
		} else if (dag >= 26) {
			melding = "Du skal på kontor 134.";
		} else if (dag >= 15) {
			melding = "Du skal på kontor 125.";
		} else if (dag >= 9) {
			melding = "Du skal på kontor 120.";
		} else if (dag >= 1) {
			melding = "Du skal på kontor 113.";
		} else {
			melding = "Tallet kan ikke være negativt eller 0.";
		}

		showMessageDialog(null, melding);

	}
}
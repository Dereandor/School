/**
* Side 112
* Programmeringsoppgaver 3.2
* Oppgave 3
*
*/

import static javax.swing.JOptionPane.*;

class Oppgave3_312 {

	public static void main(String[]args) {

		String yearRead = showInputDialog("Tast inn årstall:");
		int year = Integer.parseInt(yearRead);

		String message;
		if (year % 400 == 0) {
			message = "Året er et hundretalls skuddår";
		} else if (year % 4 == 0 && year % 100 != 0) {
			message = "Året er et skuddår";
		} else {
			message = "Året er ikke et skuddår";
		}

		showMessageDialog(null, message);

	}

}
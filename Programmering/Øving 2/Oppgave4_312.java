/**
* Side 112
* Programmeringsoppgaver 3.12
* Oppgave 4
*
*/

import static javax.swing.JOptionPane.*;

class Oppgave4_312 {

	public static void main(String[]args) {

		double a = (35.90 / 450);

		double b = (39.50 / 500);

		if (a < b) {
			System.out.println("A koster: " + a * 1000 + "pr. kg. og er derfor billigere enn B som koster " + b * 1000 + " pr. kg.");
		} else if (a > b) {
			System.out.println("B koster: " + b * 1000 + "pr. kg. og er derfor billigere enn A som koster " + a * 1000 + " pr. kg.");
		} else {
			System.out.println("Begge koster det samme.");
		}
	}
	}
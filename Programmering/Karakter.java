/**
*Karakter.java
*
*Programliste 3.3
*
*/

import static javax.swing.JOptionPane.*;

class Karakter {

	public static void main(String[]args) {

		final int MAKS = 100;
		String poengLest = showInputDialog("Antall Poeng: ");
		int poeng = Integer.parseInt(poengLest);

		String melding;
		if (poeng > 100) {
			melding = "For stor poengsum, maks. " + MAKS + ".";
		} else if (poeng >= 96) {
			melding = "Karakteren er A.";
		} else if (poeng >= 86) {
			melding = "Karakteren er B.";
		} else if (poeng >= 71) {
			melding = "Karakteren er C.";
		} else if (poeng >= 55) {
			melding = "Karakteren er D.";
		} else if (poeng >= 36) {
			melding = "Karakteren er E.";
		} else if (poeng >= 0) {
			melding = "Karakteren er F.";
		} else {
			melding = "Poengsummen kan ikke være negativ.";
		}

		showMessageDialog(null, melding);

	}
}
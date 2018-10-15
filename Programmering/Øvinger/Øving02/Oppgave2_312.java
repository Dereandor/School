/**
* Side 113
* Programmeringsoppgaver 3.12
* Oppgave 2
* Sjekke om et tall er heltall, delbart på 5 og mellom 0 og 1000
* */

import static javax.swing.JOptionPane.*;

class Oppgave2_312 {

		public static void main(String[]args) {

			showMessageDialog(null, "Sjekk om et tall er: Heltall, delbart på 5 og mellom 0 og 1000");
			
			String tallLest = showInputDialog("Tast inn et heltall:");
			int tall = Integer.parseInt(tallLest);

			//String delTallLest = showInputDialog("Er tallet delbart på:");
			//int delTall = Integer.parseInt(delTallLest);

			String melding1;
			if (tall> 0) {
				melding1 = ("Tallet er heltall.");
			} else {
				melding1 = ("Tallet er ikke heltall.");
			}

			String melding2;
			if (tall % 5 == 0) {
				melding2 = tall + " er delbart på " + "5" + " uten rest/desimalsvar.";
			} else {
				melding2 = tall + " er ikke delbart på " + "5" + " uten rest/desimalsvar.";
			}
			
			String melding3;
			if (tall >=0 && tall <= 1000) {
				melding3 = tall + " er mellom 0 og 1000.";
			} else {
				melding3 = tall + " er ikke mellom 0 og 1000.";
			}
			
			showMessageDialog(null, melding1);
			showMessageDialog(null, melding2);
			showMessageDialog(null, melding3);
		}
}
		
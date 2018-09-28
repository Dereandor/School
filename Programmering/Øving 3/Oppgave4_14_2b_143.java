/**
* Porgrammeringsoppgaver 4.14
* Oppgave 2b
* Side 143
*
*/

import static javax.swing.JOptionPane.*;

class Oppgave4_14_2b_143 {
	
	public static void main (String[]args) {
		
		String lestAntallLinjer = showInputDialog("Antall linjer(0 avslutter): ");
		int antallLinjer = Integer.parseInt(lestAntallLinjer);
		
		for (int a = 0; a < antallLinjer; a++) {
			int antallStjerner = 1 + 2 * (a);
			int antallMellom = antallLinjer - a;
			for (int b = 0; b < antallMellom; b++) {
				System.out.print("  ");
			}
			
			for (int c = 0; c < antallStjerner; c++) {
				System.out.print("*");
			}
			
			System.out.println("");
		}
	}
}
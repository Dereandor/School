/**
* Side 123
* Oppgaver kap. 4.3
* Oppgave 2
* Finn logiske feil i følgende program, som skal beregne x^n, der n >= 0:
*/

import static javax.swing.JOptionPane.*;

class Oppgave4_3_2_123 {
	
	public static void main(String[]args) {
		
		String lestGrunntall = showInputDialog("Skriv grunntallet: ");
		String lestEksponent = showInputDialog("Skriv eksponenten: ");
		
		double x = Double.parseDouble(lestGrunntall);
		int n = Integer.parseInt(lestEksponent);
		
		double svar = 1;
		int teller = 0;
		
		while (teller < n) {
			svar *= x;
			teller++;
		}
		showMessageDialog(null, "Svaret er " + svar);
	}
}
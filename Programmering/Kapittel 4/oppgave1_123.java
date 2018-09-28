/*
* Oppgave 1
* Side 123
*
*
*/

import static javax.swing.JOptionPane.*;

class oppgave1_123 {
	
	public static void main(String[]args) {
		
		int sum = 0;
		int antall = 0;
		String tallLest = showInputDialog("Skriv tall, avslutt med Esc.");
		while (tallLest != null) {
			int tall = Integer.parseInt(tallLest);
			sum += tall;
			antall++;
			tallLest = showInputDialog("Skriv in tall, avslutt med Esc.");
		}
		showMessageDialog(null, "Summen er " + sum + "." + "Gjennomsnittet er " + antall + ".");
	}
}
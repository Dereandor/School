/**
* Programmeringsoppgaver 4.14
* Oppgave 3
* Side 144
* 
*/

import static javax.swing.JOptionPane.*;

class Oppgave4_14_3_144 {
	
	public static void main(String[]args) {
		
		String bokstav1lest = showInputDialog("Tast inn første bokstav: ");
		char bokstav1char = bokstav1lest.charAt(0);
		int bokstav1 = (int) bokstav1char;
		
		String bokstav2lest = showInputDialog("Tast inn andre bokstav: ");
		char bokstav2char = bokstav2lest.charAt(0);
		int bokstav2 = (int) bokstav2char;
		
		for (char i = bokstav1char; i < bokstav2char; i+=1) {
			System.out.println ( " ");
			for (int j = bokstav1; j < bokstav2 + 1; j+=1) {
				System.out.println ( "Tegnet " + i + " har verdien " + j);
			}
		}
		
	}
}
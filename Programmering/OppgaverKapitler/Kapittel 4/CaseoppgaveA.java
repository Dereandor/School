/**
* Caseoppgave A
* Forelesning kapittel 4
*
*
*/

import static javax.swing.JOptionPane.*;

class CaseoppgaveA {
	
	public static void main(String[]args) {
		
		String lanebelop = showInputDialog("Skriv inn lånebeløpet: ");
		double lan = Double.parseDouble(lanebelop);
		
		String renteprosent = showInputDialog("Skriv inn renteprosenten: ");
		double rente  = Double.parseDouble(renteprosent);
		
		
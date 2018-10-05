/**
* side 143
* Porgrammeringsoppgaver 4.14
* Oppgave 2 a
*
*/

import static javax.swing.JOptionPane.*;

class Oppgave4_14_2_143 {

	public static void main(String[]args) {
		
		String linjerLest = showInputDialog("Tast inn antall linjer: ");
		int linjer = Integer.parseInt(linjerLest);

		for (int antall = 0; linjer >= antall; antall++) {
			
			for (int stjerner = 1; stjerner <= antall; stjerner++) {
				
			System.out.print("*  ");
			}
			System.out.println(" ");
		}
	}
}
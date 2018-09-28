/**
* side 143
* Programmeringsoppgaver 4.14
* Oppgave 1
*
*/

import static javax.swing.JOptionPane.*;

class Oppgave4_14_1_143 {

	public static void main(String[]args) {

		String tall1 = showInputDialog("Skriv inn starttallet for gangetabellen: ");
		int startTall = Integer.parseInt(tall1);

		String tall2 = showInputDialog("Skriv inn sluttallet for gangetabellen: ");
		int sluttTall = Integer.parseInt(tall2);

		for (int i = startTall; i < sluttTall + 1; i++) {
			System.out.println ( i + "-gangen.");
			for (int j = 1; j < 11; j++) {
				System.out.println (i + " * " + j + " = " + i*j);
			}//for j

			System.out.println ("");
		}//for i

	}//main

}//class
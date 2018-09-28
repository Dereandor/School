/* Kalkulator2.java

*/

import static javax.swing.JOptionPane.*;
class Kalkulator2{
	public static void main (String[] args){
		String tall1Lest = showInputDialog("Tall1: ");
		String tall2Lest = showInputDialog("Tall2: ");

		int tall1 = Integer.parseInt(tall1Lest);
		int tall2 = Integer.parseInt(tall2Lest);

		int valg = showConfirmDialog(null, "pluss", "Regnemaskin", YES_OPTION);

		int svar = 0;
		if (valg == YES_OPTION) {
			svar = tall1 + tall2;
		} else{
			svar = tall1 - tall2;
		}

		showMessageDialog(null, "Svar: " + svar);
	}
}
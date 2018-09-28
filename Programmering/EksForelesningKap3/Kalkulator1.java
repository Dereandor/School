/* Kalkulator1.java

*/

import static javax.swing.JOptionPane.*;
class Kalkulator1{
	public static void main (String[] args){
		String tall1Lest = showInputDialog("Tall1: ");
		String tall2Lest = showInputDialog("Tall2: ");

		int tall1 = Integer.parseInt(tall1Lest);
		int tall2 = Integer.parseInt(tall2Lest);

		int svar = tall1 - tall2;

		showMessageDialog(null, "Svar: " + svar);
	}
}
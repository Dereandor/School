/**
* Programmeringsoppgaver 4.14
* Oppgave 5
* Side 144
*
*/

import static javax.swing.JOptionPane.*;

class Oppgave4_14_5_144 {

	public static void main (String[]args) {

		String tallLest = showInputDialog("Tast inn et tall: ");
		int tall = Integer.parseInt(tallLest);

		boolean primtall = true;

		if (tall <= 1 || tall != 2 && tall % 2 == 0) {
			primtall = false;
		} else {
			int iSqrt = (int) Math.sqrt(tall);
			for (int i = 3; i <= iSqrt; i += 2) {
				if (tall % i == 0) {
					primtall = false;
					break;

				} //if end
			} //for end
		} //else end
		showMessageDialog(null, primtall);
	} //main end
} //class end
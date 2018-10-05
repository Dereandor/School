/*
* primtall check
*/

import static javax.swing.JOptionPane.*;

public class Primtall {

	Public static void main(String[]args) {

		String tallLest = showInputDialog("Tast inn et tall: ")
		int tall = Integer.parseInt(tallLest);

		while (tallLest != null) {

			if (tall <= 1 || tall != 2 && tall % 2 == 0) {
				showMessageDialog(null, "Tallet er ikke primtall");
			} else { }
		}
	}
}
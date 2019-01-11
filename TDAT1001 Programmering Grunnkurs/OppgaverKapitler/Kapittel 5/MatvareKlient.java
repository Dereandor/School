

import static javax.swing.JOptionPane.*;

public class MatvareKlient {

	public static void main(String[]args) {

		Matvare pomFritGKJ = new Matvare("pommes frites, gatekj", 1381, 3.0, 39.8);
		Matvare pomFritFryst = new Matvare("pommes frites, fryst", 642, 2.2, 22.0);
		Matvare koktPotet = new Matvare("potet, kokt", 339, 1.9, 17.1);

		String vektLest = showInputDialog("Tast inn vekt i gram, avslutt med Esc: ");
		int antallGram = 0;
		if  (vektLest != 0) antallGram = Integer.parseInt(vektLest);

		while (vektLest != null) {


		}
	}
}
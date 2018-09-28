/**
* EnKonto.java
*
*
*
*/

import static javax.swing.JOptionPane.*;

class EnKonto {

	public static void main(String[]args) {

		/* Vi opretter et objekt av klassen Konto. Objektet heter olesKonto */
		Konto olesKonto = new Konto(123456676756L, "Ole Olsen", 2300.47);

		olesKonto.utforTransaksjon(1000.0); //setter inn 1000 kroner

		double saldo = olesKonto.getSaldo(); //spør objektet om den nye saldoen

		System.out.println("Etter innskudd er saldoen lik " + saldo);
	}
}
/*
* Sirkelberegning.java
* Oppgave 4
* Kapittel 5.2
* Side 161
*/

import static javax.swing.JOptionPane.*;

class Sirkelberegning {

	public static void main(String[]args){

		Sirkel enSirkel = new Sirkel(20);
		double areal = enSirkel.beregnAreal();
		double omkrets = enSirkel.beregnOmkrets();

		System.out.println("Arealet er lik ");
		System.out.printf("%.2f", areal);
		System.out.println("\nOmkretsen er lik ");
		System.out.printf("%.2f", omkrets);
		System.out.println("\n" + enSirkel);

	}
}
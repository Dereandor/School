/*
 * Primtall.java
 * Løsningsforslag oppgave 4.14.5
 */

import static javax.swing.JOptionPane.*;

class Primtall {
  public static void main(String[] args) {
	String tallLest = showInputDialog("Skriv ett tall av gangen, avslutt med Esc:");;
	boolean primtall = true;

    while (tallLest != null ){
		int lestTall = Integer.parseInt(tallLest);
		for (int i = 2; i < lestTall; i++){
			if (lestTall % i == 0) primtall = false;
		}

		if (primtall) showMessageDialog(null, tallLest + " er et primtall.");
    	else showMessageDialog(null, tallLest + " er ikke primtall.");

		tallLest = showInputDialog("Skriv ett tall av gangen, avslutt med Esc:");
	}
  }
} // Primtall




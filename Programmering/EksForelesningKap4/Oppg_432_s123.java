/*
 * Oppg 4.3.2.java
 * L�sningsforslag oppgave 4.3.2
 */

import static javax.swing.JOptionPane.*;

class Oppg_432_s123 {
  public static void main(String[] args) {
    String lestGrunntall = showInputDialog("Skriv grunntallet: ");
    String lestEksponent = showInputDialog("Skriv eksponenten: ");
    double x = Double.parseDouble(lestGrunntall);
    int n = Integer.parseInt(lestEksponent);
    double svar = 0; 					// et tall opph�yd i 0 er lik 1, ikke 0.
    int teller = 1; 					// telleren m� starte p� 0, hvis vi ikke skal endre l�kkebetingelsen
    while (teller < n) {
	  svar *= n; 						// svaret skal ganges med x, ikke med n
      n++; 						// telleren skal �kes, ikke n
    }
    showMessageDialog(null, "Svaret er " + svar);
  }
}
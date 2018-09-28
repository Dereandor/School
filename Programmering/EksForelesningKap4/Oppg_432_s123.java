/*
 * Oppg 4.3.2.java
 * Løsningsforslag oppgave 4.3.2
 */

import static javax.swing.JOptionPane.*;

class Oppg_432_s123 {
  public static void main(String[] args) {
    String lestGrunntall = showInputDialog("Skriv grunntallet: ");
    String lestEksponent = showInputDialog("Skriv eksponenten: ");
    double x = Double.parseDouble(lestGrunntall);
    int n = Integer.parseInt(lestEksponent);
    double svar = 0; 					// et tall opphøyd i 0 er lik 1, ikke 0.
    int teller = 1; 					// telleren må starte på 0, hvis vi ikke skal endre løkkebetingelsen
    while (teller < n) {
	  svar *= n; 						// svaret skal ganges med x, ikke med n
      n++; 						// telleren skal økes, ikke n
    }
    showMessageDialog(null, "Svaret er " + svar);
  }
}
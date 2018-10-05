/*
 * Løsningsforslag
 */

import static javax.swing.JOptionPane.*;

class Oppg_471_s133 {
  public static void main(String[] args) {
	int sum = 0;
	String tallLest = showInputDialog("Skriv tall, avslutt med Esc.");
	while (tallLest != null ){
		int tall = Integer.parseInt(tallLest);
		sum += tall;
		tallLest = showInputDialog("Skriv tall, avslutt med Esc.");
	}
	showMessageDialog(null, "Summen er " + sum + ".");
  }
}




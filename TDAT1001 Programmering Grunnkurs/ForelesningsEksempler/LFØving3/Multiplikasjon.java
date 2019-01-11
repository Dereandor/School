/*
 * Multiplikasjon.java
 * Løsningsforslag oppgave 4.14.1
 */

import static javax.swing.JOptionPane.*;

class Multiplikasjon {
  public static void main(String[] args) {

    String tekst = showInputDialog("Skriv inn startsifferet for multiplikasjonstabellen? ");
    int starttall = Integer.parseInt(tekst);

    String tekst2 = showInputDialog("Skriv inn sluttsifferet for multiplikasjonstabellen? ");
    int sluttall = Integer.parseInt(tekst2);

    for (int i = starttall; i < sluttall + 1; i++){
		System.out.println (i + "-gangen:");
		for (int j = 1; j < 11; j++){
			System.out.println (i + " * " + j + " = " + i*j);
		}
	System.out.println ("");
	}

  }
} // Multiplikasjon


/* 3-gangen:
3 * 1 = 3
3 * 2 = 6
3 * 3 = 9
3 * 4 = 12
3 * 5 = 15
3 * 6 = 18
3 * 7 = 21
3 * 8 = 24
3 * 9 = 27
3 * 10 = 30

*/
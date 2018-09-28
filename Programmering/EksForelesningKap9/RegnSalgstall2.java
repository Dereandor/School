/**
 * RegnSalgstall.java - "Programmering i Java", 4.utgave - 2009-07-01
 *
 * Denne klassen pr�ver noen av metodene i klassen Salgstall.
 */
class RegnSalgstall2 {
  public static void main(String[] args) {

    /* Her starter uke- og dagnummerering p� 0. */

    Salgstall �ret2009 = new Salgstall("Sko", 52, 5); // 4 uker � 5 dager
    �ret2009.settSalg(10, 0, 10000); // uke 10
    �ret2009.settSalg(8, 3, 12100); // uke 8

    System.out.println("Salg uke nr.: 5 er kr " + �ret2009.finnSalgForHelUke(5) + ".");

    System.out.println("Salg mandag uke 6 er kr " + �ret2009.finnSalgForUkedag(6) + ".");

    System.out.println("Totalsalget er " + �ret2009.finnTotalsalg() + " kroner.");

    int tall = �ret2009.finnMestL�nnsommeUkedag();
    System.out.println("Mest l�nnsomme ukedag er dag nr. " + tall + ".");
    System.out.println("Den mest l�nnsomme ukedagen solgte vi for kr: " + �ret2009.finnSalgForUkedag(tall) + ".");
  }
}

/* Kj�ring av programmet:
Salg uke nr.: 5 er kr 0.
Salg mandag uke 6 er kr -1.
Totalsalget er 22100 kroner.
Mest l�nnsomme ukedag er dag nr. 3.
Den mest l�nnsomme ukedagen solgte vi for kr: 12100.
*/
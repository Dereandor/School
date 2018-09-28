/**
 * RegnSalgstall.java - "Programmering i Java", 4.utgave - 2009-07-01
 *
 * Denne klassen prøver noen av metodene i klassen Salgstall.
 */
class RegnSalgstall2 {
  public static void main(String[] args) {

    /* Her starter uke- og dagnummerering på 0. */

    Salgstall året2009 = new Salgstall("Sko", 52, 5); // 4 uker á 5 dager
    året2009.settSalg(10, 0, 10000); // uke 10
    året2009.settSalg(8, 3, 12100); // uke 8

    System.out.println("Salg uke nr.: 5 er kr " + året2009.finnSalgForHelUke(5) + ".");

    System.out.println("Salg mandag uke 6 er kr " + året2009.finnSalgForUkedag(6) + ".");

    System.out.println("Totalsalget er " + året2009.finnTotalsalg() + " kroner.");

    int tall = året2009.finnMestLønnsommeUkedag();
    System.out.println("Mest lønnsomme ukedag er dag nr. " + tall + ".");
    System.out.println("Den mest lønnsomme ukedagen solgte vi for kr: " + året2009.finnSalgForUkedag(tall) + ".");
  }
}

/* Kjøring av programmet:
Salg uke nr.: 5 er kr 0.
Salg mandag uke 6 er kr -1.
Totalsalget er 22100 kroner.
Mest lønnsomme ukedag er dag nr. 3.
Den mest lønnsomme ukedagen solgte vi for kr: 12100.
*/
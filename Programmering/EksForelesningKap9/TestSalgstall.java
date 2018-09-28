class Testeksamen {
  public static void main(String[] args) {

    /* Her starter uke- og dagnummerering på 0 */

    Salgstall periode = new Salgstall("sko", 4, 5); // 4 uker á 5 dager
    periode.settSalg(0, 0, 100); // uke 0
    periode.settSalg(0, 1, 200);
    periode.settSalg(0, 2, 400);
    periode.settSalg(0, 3, 100);

    periode.settSalg(2, 0, 100); // uke 2
    periode.settSalg(2, 1, 200);
    periode.settSalg(2, 3, 400);
    periode.settSalg(2, 4, 100);

    periode.settSalg(3, 1, 150); // uke 3
    periode.settSalg(3, 2, 210);
    periode.settSalg(3, 3, 400);
    periode.settSalg(3, 4, 100);

    for (int uke = 0; uke < periode.finnAntUker(); uke++) {
      System.out.println("Salg uke nr: " + uke + " er kr " +
                          periode.finnSalgForHelUke(uke));
    }
    System.out.println();
    for (int dag = 0; dag < periode.finnAntDgPrUke(); dag++) {
      System.out.println("Salg dag nr: " + dag + " er kr " +
                          periode.finnSalgForUkedag(dag));
    }
    System.out.println();
    System.out.println("Totalsalget er " + periode.finnTotalsalg() + " kroner.");
    System.out.println("Mest lønnsomme ukedag er dag nr " +
                        periode.finnMestLønnsommeUkedag());
  }
}


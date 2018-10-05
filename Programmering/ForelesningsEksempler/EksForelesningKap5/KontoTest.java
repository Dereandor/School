
class KontoTest {
  public static void main(String[] args) {

    /* Oppretter et objekt av klassen Konto. */
    Konto olesKonto = new Konto(123456676756L, "Ole Olsen", 2300.50);

    /* Setter inn 1000 kroner */
    olesKonto.utførTransaksjon(1000.0);

    /* Spør objektet om den nye saldoen */
    double saldo = olesKonto.getSaldo();

    /* Skriver ut saldoen */
    System.out.println("Etter innskudd er saldoen lik " + saldo);
    System.out.println(olesKonto);

     Konto minK = new Konto(123456676756L, "Kim T");

     System.out.println(minK);
     minK.utførTransaksjon(1000);

  }
}

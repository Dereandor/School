/*
 * Konto.java  E.L. 2002-06-10
 *
 */
class Konto {
  private long kontonr;
  private String navn;
  private double saldo;

  public Konto(long kontonr, String navn, double saldo) {
    this.kontonr = kontonr;
    this.navn = navn;
    this.saldo = saldo;
  }

  public Konto(long kontonr, String navn) {
    this.kontonr = kontonr;
    this.navn = navn;
    this.saldo = 0;
  }

  public long getKontonr() {
    return kontonr;
  }

  public double getSaldo() {
    return saldo;
  }

  public String getNavn() {
    return navn;
  }

  public void utførTransaksjon(double beløp) {
    saldo = saldo + beløp;
  }

  public String toString(){
	  return kontonr + " " + navn + " " + saldo;
  }

}

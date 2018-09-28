/**
 * Arealberegning.java - "Programmering i Java", 4.utgave - 2009-07-01
 *
 * Programmet beregner arealet av et rektangel.
 */

class Arealberegning {
  public static void main(String[] args) {
    double lengde = 6.0;
    double bredde = 3.4;
    double arealet = lengde * bredde;
    double omkrets = lengde + lengde + bredde + bredde;
    System.out.println("Arealet av rektangelet er " + arealet + " kvadratmeter.");
    System.out.println("Omkretsen av rektangelet er " + omkrets + " meter.");
  }
}

/* Kjøring av programmet:
Arealet av rektangelet er 11.5 kvadratmeter.
*/

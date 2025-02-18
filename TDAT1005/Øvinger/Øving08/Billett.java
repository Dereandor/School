/**
 * Klassen Billett med subklasser - 2010-01-18
 * Denne blir delt ut sammen med �vingen
 */
abstract class Billett {
  private final String tribunenavn;
  private final int pris;

  /**
   * Konstrukt�r:
   * Tribunenavn m� oppgis. Ingen krav til pris.
   */
  public Billett(String tribunenavn, int pris) {
    if (tribunenavn == null || tribunenavn.trim().equals("")) {
      throw new IllegalArgumentException("Tribunenavn m� oppgis.");
    }
    this.tribunenavn = tribunenavn.trim();
    this.pris = pris;
  }

  public String getTribune() {
    return tribunenavn;
  }

  public int getPris() {
    return pris;
  }

  public String toString() {
    return "Tribune: "+tribunenavn + " Pris: "+pris;
  }
}

/**
 * St�plassbilletter.
 */
class StaaplassBillett extends Billett {
  public StaaplassBillett(String tribunenavn, int pris) {
    super(tribunenavn, pris);
  }
}

/**
 * Sitteplassbilletter. Rad og plass p� raden m� oppgis.
 */
class SitteplassBillett extends Billett {
  private final int rad;
  private final int plass;

  public SitteplassBillett(String tribunenavn, int pris, int rad, int plass) {
    super(tribunenavn, pris);
    if (rad < 0 || plass < 0) {
      throw new IllegalArgumentException("Verken rad eller plass kan v�re negativ.\n"
                                                           + "Oppgitte verdier: " + rad + ", " + plass);
    }
    this.rad = rad;
    this.plass = plass;
  }

  public int getRad() {
    return rad;
  }

  public int getPlass() {
    return plass;
  }

  public String toString() {
    String res = super.toString();
    res += " Rad: "+ rad + " Plass: " + plass;
    return res;
  }
}

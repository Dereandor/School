/*
 * Flate.java   E.L. 2004-02-15
 *
 * Klassen Flate tilbyr metoder for beregning av areal og omkrets.
 */

class Flate {
  private String navn;  // til identifikasjon
  private double lengde;
  private double bredde;
  private final double toleranse = 0.00001;

  public Flate(String startNavn, double startLengde, double startBredde) {
    navn = startNavn;
    lengde = startLengde;
    bredde = startBredde;
  }

  public String finnNavn() {
    return navn;
  }

  public double finnLengde() {
    return lengde;
  }

  public double finnBredde() {
    return bredde;
  }

  public double finnAreal() {
    return bredde * lengde;
  }

  public double finnOmkrets() {
    return 2 * (lengde + bredde);
  }

 public boolean equals(Object flaten){
	  if (!(flaten instanceof Flate)) return false;
	  if (this == flaten) return true;
	  Flate flate2 = (Flate)flaten;
	  if(Math.abs(lengde-flate2.lengde) > toleranse)return false;
	  if(Math.abs(bredde - flate2.bredde) > toleranse) return false;
	  return true;
  }


  public int compareTo(Flate flateTo){
	 double areal1 = finnAreal();
	 double areal2 = flateTo.finnAreal();

	 if (Math.abs(areal2 - areal1) < toleranse) return 0;  // likhet
	 else if (areal1 < areal2) return -1;
	 else return 1;
 }


  public String toString() {
    java.text.DecimalFormat utskriftFormat = new java.text.DecimalFormat("####0.00");
    return "Flate: " + navn + ", bredde: " + utskriftFormat.format(bredde) +
           " m, lengde: " + utskriftFormat.format(lengde) + " m.";
  }
}
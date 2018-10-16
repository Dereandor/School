/*
 * OppgaveFlateLekeplass.java   E.L. 2004-02-15
 *
 * Klassen Flate tilbyr metoder for beregning av areal og omkrets.
 */

class Flate {
  private double lengde;
  private double bredde;

  public Flate(double startLengde, double startBredde) {
    lengde = startLengde;
    bredde = startBredde;
  }


  public double finnLengde() {
    return lengde;
  }

  public double finnBredde() {
    return bredde;
  }

  public void settLengde(double nyLengde){
	  lengde = nyLengde;
  }

  public void settBredde(double nyBredde){
	  bredde = nyBredde;
  }


  public String toString() {
    java.text.DecimalFormat utskriftFormat = new java.text.DecimalFormat("####0.00");
    return "Lengde: " + utskriftFormat.format(lengde) + ", bredde: " + utskriftFormat.format(bredde);
  }
}

class Lekeplass{
	private String navn;
	private Flate plassen;

	public Lekeplass(String navn, Flate plassen){
		this.navn = navn;
		this.plassen = plassen;
	}

	public Flate finnPlass(){return plassen; }

	public void endrePlass(double nyLengde){
		plassen.settLengde(nyLengde);
	}
}

class OppgaveFlateLekeplass{
	public static void main(String [] args){
		Flate plass1 = new Flate(4.5, 3);
		Lekeplass enLekeplass = new Lekeplass("lekeplass1", plass1);
		System.out.println("A: " + plass1);

		enLekeplass.endrePlass(8.5);
		plass1.settLengde(5.0);
		plass1 = enLekeplass.finnPlass();
		System.out.println("B: " + plass1);
	}
}

package dp4.sortering.flate;

/**
 * Flate.java - "Programmering i Java", 4.utgave - 2009-07-01
 *
 * Klassen Flate tilbyr metoder for beregning av areal og omkrets.
 */

class Flate implements Comparable<Flate> {
	private final String navn; // til identifikasjon
	private final double lengde;
	private final double bredde;
	public final static double TOLERANSE = 0.001;
	private final static java.text.Collator KOLLATOR = java.text.Collator.getInstance();

	/**
	 * Konstruktøren kaster IllegalArgumentException hvis ugyldige argumenter.
	 */
	public Flate(String navn, double lengde, double bredde) throws IllegalArgumentException {
		if (navn == null || navn.trim().equals("")) {
			throw new IllegalArgumentException("Flatens navn må være oppgitt.");
		}
		if (lengde <= 0.0 || bredde <= 0.0) {
			throw new IllegalArgumentException("Både lengde og bredde må være positive tall.\n"
					+ "Inndata til konstruktøren var: lengde = " + lengde + ", bredde = " + bredde);
		}
		this.navn = navn;
		this.lengde = lengde;
		this.bredde = bredde;
	}

	public String getNavn() {
		return navn;
	}

	public double getLengde() {
		return lengde;
	}

	public double getBredde() {
		return bredde;
	}

	public double beregnAreal() {
		return bredde * lengde;
	}

	public double beregnOmkrets() {
		return 2.0 * (lengde + bredde);
	}

	public int compareTo(Flate denAndre) {
		return KOLLATOR.compare(navn, denAndre.navn);
	}

	/**
	 * To flater defineres som identiske hvis de har samme navn.
	 */
	public boolean equals(Object denAndre) {
		if (!(denAndre instanceof Flate)) {
			return false; // RETUR. Raskt uthopp hvis feil objekttype.
		}
		if (this == denAndre) {
			return true; // RETUR. Raskt uthopp hvis samme objekt.
		}
		return compareTo((Flate) denAndre) == 0; // konsistens med compareTo()
	}

	public String toString() {
		java.util.Formatter f = new java.util.Formatter();
		f.format("Flate: %s, bredde: %.2f m, lengde: %.2f m, %.2f m^2, %.2f m", navn, bredde, lengde,beregnAreal(),beregnOmkrets());
		
		String s = f.toString();
		f.close();
		
		return s;
	}
}
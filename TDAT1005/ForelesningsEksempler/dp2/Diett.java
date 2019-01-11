package dp2;

/**
 * TestDiett.java E.L. 2010-01-07
 *
 * Eksempel som viser tabell av strenger gjemt inne i en klasse.
 */
class Diett {
	private String[] matslag;

	private static final java.util.Random randomGen = new java.util.Random(); // til bruk i byttUt()

	/* Følgende fire verdier er mulige returverdier fra registrerNyttMatslag() */
	public static final int REGISTRERT = 1;
	public static final int FINNS_FRA_FØR = -1;
	public static final int NULL = -2; // nullverdi er sendt inn
	public static final int FULLT = 0;

	public Diett(int maksAntMatslag) { // ingen testing av denne konstruktøren her
		this.matslag = new String[maksAntMatslag];
	}

	public Diett(String[] matslag) {
		this.matslag = new String[matslag.length];
		for (int i = 0; i < matslag.length; i++) {
			if (matslag[i] != null) {
				this.matslag[i] = matslag[i].trim();
			}
		}
	}

	/**
	 * Metoden som kontrollerer om det er plass til flere matslag.
	 */
	public boolean fullt() {
		boolean fullt = true;
		int indeks = 0;
		while (indeks < matslag.length && fullt) {
			if (matslag[indeks] == null) {
				fullt = false;
			}
			indeks++;
		}
		return fullt;
	}

	/**
	 * Metoden registrerer nytt matslag. Det går bra dersom det er plass, og dette
	 * matslaget ikke er registrert fra før. Mulige returverdier, se navngitte
	 * konstanter foran.
	 */
	public int registrerNyttMatslag(String nyMat) {
		if (nyMat == null) {
			return NULL;
		}
		nyMat = nyMat.trim();
		if (finnIndeks(nyMat) >= 0) {
			return FINNS_FRA_FØR; // RETUR
		}

		for (int i = 0; i < matslag.length; i++) {
			if (matslag[i] == null) {
				matslag[i] = nyMat;
				return REGISTRERT; // RETUR, ok.
			}
		}
		return FULLT; // RETUR
	}

	/**
	 * Metoden bytter ut et tilfeldig matslag med et nytt. Dette går bra dersom det
	 * nye matslaget ikke er registrert fra før.
	 */
	public boolean byttUt(String nyMat) {
		if (nyMat == null) {
			return false;
		}
		nyMat = nyMat.trim();
		int ant = finnAntMatslag();
		if (ant > 0 && finnIndeks(nyMat) < 0) { // matslaget ikke registrert fra før
			int indeksByttUt;
			do {
				indeksByttUt = randomGen.nextInt(matslag.length);
			} while (matslag[indeksByttUt] == null); // må treffe en indeks der det ligger et matslag
			matslag[indeksByttUt] = nyMat;
			return true;
		}
		return false;
	}

	/**
	 * Metoden bytter ut et matslag med et annet. Metoden returnerer true dersom det
	 * matslaget som skal byttes ut eksisterer i tabellen, og det nye ikke allerede
	 * eksisterer. Ellers returneres false;
	 */
	public boolean byttUt(String gmlMat, String nyMat) {
		if (gmlMat == null || nyMat == null) {
			return false;
		}
		gmlMat = gmlMat.trim();
		nyMat = nyMat.trim();
		int indeksGml = finnIndeks(gmlMat);
		boolean gmlMatFins = (indeksGml >= 0); // gmlMat skal finnes fra før
		boolean nyMatFinsIkke = (finnIndeks(nyMat) < 0); // nyMat skal ikke finnes
		if (gmlMatFins && nyMatFinsIkke) { // nå skjer utskifting
			matslag[indeksGml] = nyMat;
			return true;
		}
		return false;
	}

	/**
	 * Metoden fjerner et bestemt matslag dersom det finnes.
	 */
	public boolean fjern(String mat) {
		if (mat == null) {
			return false;
		}
		mat = mat.trim();
		int indeks = finnIndeks(mat);
		if (indeks >= 0) {
			matslag[indeks] = null;
			return true;
		}
		return false;
	}

	/**
	 * Metoden finner antall matslag.
	 */
	public int finnAntMatslag() {
		int antall = 0;
		for (int i = 0; i < matslag.length; i++) {
			if (matslag[i] != null) {
				antall++;
			}
		}
		return antall;
	}

	/**
	 * Metoden finner maksimalt antall matslag.
	 */
	public int finnMaksAntMatslag() {
		return matslag.length;
	}

	public String toString() {
		String resultat = "";
		for (int i = 0; i < matslag.length; i++) {
			if (matslag[i] != null) {
				resultat += matslag[i] + " ";
			}
		}
		return resultat.trim();
	}

	private int finnIndeks(String mat) {
		if (mat != null) {
			mat = mat.trim();
			for (int i = 0; i < matslag.length; i++) {
				if (matslag[i] != null && matslag[i].equalsIgnoreCase(mat)) {
					return i;
				}
			}
		}
		return -1;
	}
}
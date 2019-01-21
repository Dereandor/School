package dp8.arv.eksamen;

class SkriftligEksamen extends Skriftlig {
	public static final double FAKTOR1 = 0.15;
	public static final double FAKTOR2 = 0.1;
	public static final int ANTALL = 10; // går over fra faktor1 til faktor2
	private final double antTimer;

	public SkriftligEksamen(int sensornr, String fag, int antBesvarelser, double antTim) {
		super(sensornr, fag, antBesvarelser);
		this.antTimer = antTim;
	}

	public double getAntTimer() {
		return antTimer;
	}

	/**
	 * Normert tidsforbruk for retting: Eksamenstidens lengde ganges med faktor1 for
	 * de antall første besvarelsene, deretter brukes faktor2.
	 */
	public double finnTimeforbruk() {
		int antBesvarelser = getAntBesvarelser();
		double timeforbruk = (antBesvarelser <= ANTALL) ? antBesvarelser * antTimer * FAKTOR1
				: antTimer * (ANTALL * FAKTOR1 + (antBesvarelser - ANTALL) * FAKTOR2);
		return FORBEREDELSE + timeforbruk;
	}
}
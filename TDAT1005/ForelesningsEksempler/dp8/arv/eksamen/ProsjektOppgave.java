package dp8.arv.eksamen;

class Prosjektoppgave extends Skriftlig {
	public static final double NORM_TIMER_PROSJEKT = 8.0;

	public Prosjektoppgave(int sensornr, String fag, int antBesvarelser) {
		super(sensornr, fag, antBesvarelser);
	}

	public double finnTimeforbruk() {
		return getAntBesvarelser() * NORM_TIMER_PROSJEKT; // ikke forberedelse
	}

	public String toString() {
		return "Prosjektoppgaver, antall besvarelser: " + getAntBesvarelser() + " " + super.toString();
	}
}

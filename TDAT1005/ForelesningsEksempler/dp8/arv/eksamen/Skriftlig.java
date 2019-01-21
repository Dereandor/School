package dp8.arv.eksamen;

class Skriftlig extends Oppdrag {
	private final int antBesvarelser;

	public Skriftlig(int sensornr, String fag, int antBesvarelser) {
		super(sensornr, fag);
		this.antBesvarelser = antBesvarelser;
	}

	public int getAntBesvarelser() {
		return antBesvarelser;
	}
}
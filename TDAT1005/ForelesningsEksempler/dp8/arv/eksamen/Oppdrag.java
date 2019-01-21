package dp8.arv.eksamen;

class Oppdrag {
	public final static double FORBEREDELSE = 3.0; // timer

	private final int sensornr;
	private final String fag;

	public Oppdrag(int sensornr, String fag) {
		this.sensornr = sensornr;
		this.fag = fag;
	}

	public int getSensornr() {
		return sensornr;
	}

	public String getFag() {
		return fag;
	}

	public double finnTimeforbruk() { // skal redefineres i subklasser
		return 0.0;
	}

	public String toString() {
		return "Sensornr: " + sensornr + ", fag: " + fag + ", tidsforbruk for avlønning: " + finnTimeforbruk()
				+ " timer.";
	}
}
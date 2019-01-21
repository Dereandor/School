package dp8.arv.eksamen;

class MuntligEksamen extends Oppdrag {
	private final double medgåttTid; // timer

	public MuntligEksamen(int sensornr, String fag, double medgåttTid) {
		super(sensornr, fag);
		this.medgåttTid = medgåttTid;
	}

	public double getMedgåttTid() {
		return medgåttTid;
	}

	public double finnTimeforbruk() {
		return medgåttTid + FORBEREDELSE;
	}

	public String toString() {
		return "Muntlig eksamen, medgått tid: " + medgåttTid + " " + super.toString();
	}
}

package dp8.arv.eksamen;

class MuntligEksamen extends Oppdrag {
	private final double medg�ttTid; // timer

	public MuntligEksamen(int sensornr, String fag, double medg�ttTid) {
		super(sensornr, fag);
		this.medg�ttTid = medg�ttTid;
	}

	public double getMedg�ttTid() {
		return medg�ttTid;
	}

	public double finnTimeforbruk() {
		return medg�ttTid + FORBEREDELSE;
	}

	public String toString() {
		return "Muntlig eksamen, medg�tt tid: " + medg�ttTid + " " + super.toString();
	}
}

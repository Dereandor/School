package dp8.arv.hierarkisk;


public class Ansatt extends Person {
	private double l�nn;
	
	public Ansatt(String navn, double l�nn) {
		super(navn);
		this.l�nn = l�nn;
	}
	
	@Override
	public String toString() {
		return "[Ansatt: l�nn=" + l�nn + ", " + super.toString() + "]";
	}

	@Override
	public String getRolle() {
		return "Jeg er ansatt";
	}
}

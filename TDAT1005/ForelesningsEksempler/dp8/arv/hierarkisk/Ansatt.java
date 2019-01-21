package dp8.arv.hierarkisk;


public class Ansatt extends Person {
	private double lønn;
	
	public Ansatt(String navn, double lønn) {
		super(navn);
		this.lønn = lønn;
	}
	
	@Override
	public String toString() {
		return "[Ansatt: lønn=" + lønn + ", " + super.toString() + "]";
	}

	@Override
	public String getRolle() {
		return "Jeg er ansatt";
	}
}

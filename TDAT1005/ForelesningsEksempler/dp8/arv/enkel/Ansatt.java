package dp8.arv.enkel;


public class Ansatt extends Person {
	private double l�nn;
	
	public Ansatt(String navn) {
		super(navn);		
	}
	
	

	public double getL�nn() {
		return l�nn;
	}

	public void setL�nn(double l�nn) {
		this.l�nn = l�nn;
	}


	@Override
	public String toString() {
		return "[Ansatt: l�nn=" + l�nn + ", " + super.toString() + "]";
	}
}

package dp8.arv.enkel;


public class Ansatt extends Person {
	private double lønn;
	
	public Ansatt(String navn) {
		super(navn);		
	}
	
	

	public double getLønn() {
		return lønn;
	}

	public void setLønn(double lønn) {
		this.lønn = lønn;
	}


	@Override
	public String toString() {
		return "[Ansatt: lønn=" + lønn + ", " + super.toString() + "]";
	}
}

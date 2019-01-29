package dp10.abstrakt.figur;

public class Trekant extends Figur {
	private final double grunnlinje;
	private final double h�yde;
	
	public Trekant(double grunnlinje, double h�yde) {
		this.grunnlinje = grunnlinje;
		this.h�yde = h�yde;
	}
	
	public double getGrunnlinje() {
		return grunnlinje;
	}

	public double getH�yde() {
		return h�yde;
	}

	@Override
	public double beregnAreal() {	
		return (grunnlinje*h�yde)/2;
	}

	@Override
	public String toString() {
		return "Trekant [grunnlinje=" + grunnlinje + ", h�yde=" + h�yde + ", areal="+String.format("%.2f",beregnAreal())+"]";
	}
}

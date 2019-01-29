package dp10.abstrakt.figur;

public class Trekant extends Figur {
	private final double grunnlinje;
	private final double høyde;
	
	public Trekant(double grunnlinje, double høyde) {
		this.grunnlinje = grunnlinje;
		this.høyde = høyde;
	}
	
	public double getGrunnlinje() {
		return grunnlinje;
	}

	public double getHøyde() {
		return høyde;
	}

	@Override
	public double beregnAreal() {	
		return (grunnlinje*høyde)/2;
	}

	@Override
	public String toString() {
		return "Trekant [grunnlinje=" + grunnlinje + ", høyde=" + høyde + ", areal="+String.format("%.2f",beregnAreal())+"]";
	}
}

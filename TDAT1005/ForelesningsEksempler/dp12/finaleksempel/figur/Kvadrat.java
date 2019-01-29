package dp12.finaleksempel.figur;

public class Kvadrat extends Figur {
	private final double høyde;
	private final double bredde;

	public Kvadrat(double høyde, double bredde) {
		this.høyde = høyde;
		this.bredde = bredde;
	}

	public double getHøyde() {
		return høyde;
	}

	public double getBredde() {
		return bredde;
	}

	@Override
	final public double beregnAreal() {
		return høyde * bredde;
	}

	@Override
	public String toString() {
		return "Kvadrat [høyde=" + høyde + ", bredde=" + bredde + ", areal="+String.format("%.2f",beregnAreal())+super.toString()+"]";
	}	
}

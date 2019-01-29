package dp12.finaleksempel.figur;

public class Kvadrat extends Figur {
	private final double h�yde;
	private final double bredde;

	public Kvadrat(double h�yde, double bredde) {
		this.h�yde = h�yde;
		this.bredde = bredde;
	}

	public double getH�yde() {
		return h�yde;
	}

	public double getBredde() {
		return bredde;
	}

	@Override
	final public double beregnAreal() {
		return h�yde * bredde;
	}

	@Override
	public String toString() {
		return "Kvadrat [h�yde=" + h�yde + ", bredde=" + bredde + ", areal="+String.format("%.2f",beregnAreal())+super.toString()+"]";
	}	
}

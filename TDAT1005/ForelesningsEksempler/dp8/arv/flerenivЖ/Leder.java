package dp8.arv.flereniv�;


public class Leder extends Ansatt {
	private String tittel;
	
	public Leder(String navn, double l�nn, String tittel) {
		super(navn);
		super.setL�nn(l�nn);
		this.tittel = tittel;
	}

	@Override
	public String toString() {
		return "[Leder: tittel=" + tittel + ", " + super.toString() + "]";
	}

}

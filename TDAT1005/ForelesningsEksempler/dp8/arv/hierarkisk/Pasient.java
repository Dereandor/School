package dp8.arv.hierarkisk;

public class Pasient extends Person {
	private String fastlege;

	public Pasient(String navn, String fastlege) {
		super(navn);
		this.fastlege = fastlege;
	}

	@Override
	public String toString() {
		return "[Pasient: fastlege=" + fastlege + ", " + super.toString() + "]";
	}

	@Override
	public String getRolle() {
		return "Jeg er pasient";
	}	
}

package dp8.arv.hierarkisk;

public class Pårørende extends Person {

	private final String forhold; 
	private final Person forholdTil;
	
	public Pårørende(String navn, String forhold, Person forholdTil) {
		super(navn);
		this.forhold = forhold;
		this.forholdTil = forholdTil;
	}
	@Override
	public String toString() {
		return "[Pårørende: forhold=" + forhold + " til "+forholdTil.toString()+", " + super.toString() + "]";
	}
	
	@Override
	public String getRolle() {
		return "Jeg er pårørende";
	}	
}

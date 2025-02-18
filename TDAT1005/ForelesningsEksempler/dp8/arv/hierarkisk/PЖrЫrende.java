package dp8.arv.hierarkisk;

public class P�r�rende extends Person {

	private final String forhold; 
	private final Person forholdTil;
	
	public P�r�rende(String navn, String forhold, Person forholdTil) {
		super(navn);
		this.forhold = forhold;
		this.forholdTil = forholdTil;
	}
	@Override
	public String toString() {
		return "[P�r�rende: forhold=" + forhold + " til "+forholdTil.toString()+", " + super.toString() + "]";
	}
	
	@Override
	public String getRolle() {
		return "Jeg er p�r�rende";
	}	
}

package dp3.utvidet_forloekke;

public class Person {

	private final long fnr;
	private final String navn;
	private final String adresse;

	public Person(long fnr, String navn, String adresse) {
		super();
		this.fnr = fnr;
		this.navn = navn;
		this.adresse = adresse;
	}
	
	public long getFnr() {
		return fnr;
	}
	public String getNavn() {
		return navn;
	}
	public String getAdresse() {
		return adresse;
	}

	@Override
	public String toString() {
		return "Person [fnr=" + fnr + ", navn=" + navn + ", adresse=" + adresse + "]";
	}	
}

package dp8.arv.enkel;

public class Person {
	private final String navn;
	
	public String getNavn() {
		return navn;
	}

	public Person(String navn) {
		this.navn = navn;
	}

	@Override
	public String toString() {
		return "[Person: navn=" + getNavn()+ "]";
	}
}

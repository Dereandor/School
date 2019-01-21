package dp8.arv.hierarkisk;

public abstract class Person {
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
	
	public abstract String getRolle();
}

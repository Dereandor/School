package V2019;

public class Ansatt extends Person{

	public  Ansatt(String fornavn, String etternavn, String personnummer) {
		super(fornavn, etternavn,personnummer);
	}

	@Override
	public String toString() {
		return "[" +getClass().getSimpleName()+": "+super.toString() + "]";
	}	
}

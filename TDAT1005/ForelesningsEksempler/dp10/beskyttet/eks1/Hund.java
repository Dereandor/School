package dp10.beskyttet.eks1;

public abstract class Hund {
	private final String navn;
	
	public Hund(String navn) {
		this.navn = navn;
	}

	public String getNavn() {
		return navn;
	}
	
	protected abstract void vifteHalen(String eier);

}

class Ansatt2{
	public static final double MAKS_SK_PROSENT = 60;
	private final int ansattnr;
	private final String navn;
	private double timelønn;
	private double skatteprosent = MAKS_SK_PROSENT;


	public Ansatt2(int ansattnr, String navn, double timelønn, double skatteprosent){
		this.ansattnr = ansattnr;
		this.navn = navn;
		this.timelønn = timelønn;
		this.skatteprosent = skatteprosent;
	}
	public Ansatt2(int ansattnr, String navn, double timelønn){
		if (ansattnr<1000 || ansattnr >9999){
			throw new IllegalArgumentException ("Ansattnr må være fire-sifra tall");
		}
		this.ansattnr = ansattnr;
		this.navn = navn;
		this.timelønn = timelønn;
	}

	public Ansatt2(int ansattnr, String navn){
		this.ansattnr = ansattnr;
		this.navn = navn;
	}
	/* tilgangsmetoder */
	public int getAnsattnr(){
		return ansattnr;
	}
	public String getNavn(){
		return navn;
	}
	public double getTimelønn(){
		return timelønn;
	}
	public void setTimelønn(double newValue){
		timelønn = newValue;
	}
	public double getSkatteprosent(){
		return skatteprosent;
	}
	public void setSkatteprosent(double newValue){
		skatteprosent = newValue;
	}

	/* objektmetoder */
	public double beregnBruttolønn(double antTimer){
		return antTimer * timelønn;
	}
	public double beregnSkattetrekk(double antTimer){
		double brutto = beregnBruttolønn(antTimer);
		return brutto * skatteprosent / 100;
	}
	public double beregnNettolønn(double antTimer){
		return beregnBruttolønn(antTimer) - beregnSkattetrekk(antTimer);
	}

	public String toString(){
		return ansattnr + " " + navn + ", timelønn: " + timelønn + ", skatteprosent: " + skatteprosent;
	}

}
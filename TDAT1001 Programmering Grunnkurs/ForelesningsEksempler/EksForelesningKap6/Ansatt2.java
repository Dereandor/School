class Ansatt2{
	public static final double MAKS_SK_PROSENT = 60;
	private final int ansattnr;
	private final String navn;
	private double timel�nn;
	private double skatteprosent = MAKS_SK_PROSENT;


	public Ansatt2(int ansattnr, String navn, double timel�nn, double skatteprosent){
		this.ansattnr = ansattnr;
		this.navn = navn;
		this.timel�nn = timel�nn;
		this.skatteprosent = skatteprosent;
	}
	public Ansatt2(int ansattnr, String navn, double timel�nn){
		if (ansattnr<1000 || ansattnr >9999){
			throw new IllegalArgumentException ("Ansattnr m� v�re fire-sifra tall");
		}
		this.ansattnr = ansattnr;
		this.navn = navn;
		this.timel�nn = timel�nn;
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
	public double getTimel�nn(){
		return timel�nn;
	}
	public void setTimel�nn(double newValue){
		timel�nn = newValue;
	}
	public double getSkatteprosent(){
		return skatteprosent;
	}
	public void setSkatteprosent(double newValue){
		skatteprosent = newValue;
	}

	/* objektmetoder */
	public double beregnBruttol�nn(double antTimer){
		return antTimer * timel�nn;
	}
	public double beregnSkattetrekk(double antTimer){
		double brutto = beregnBruttol�nn(antTimer);
		return brutto * skatteprosent / 100;
	}
	public double beregnNettol�nn(double antTimer){
		return beregnBruttol�nn(antTimer) - beregnSkattetrekk(antTimer);
	}

	public String toString(){
		return ansattnr + " " + navn + ", timel�nn: " + timel�nn + ", skatteprosent: " + skatteprosent;
	}

}
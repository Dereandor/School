class Vare {
	public static final double MOMS = 24.0;
	public static final double MOMSFAKTOR = 1.0 + MOMS / 100.0;
	public static final double RABATT1 = 10.0;
	public static final double RABATTFAKTOR1 = (100.0 - RABATT1) / 100.0;
	public static final double RABATTGRENSE1 = 3.0;
	public static final double RABATT2 = 20.0;
	public static final double RABATTFAKTOR2 = (100.0 - RABATT2) / 100.0;
	public static final double RABATTGRENSE2 = 5.0;
	/*
	* Faktorene multipliseres med 100 for å få heltall.
	* Grensene multipliseres med 1000 for å få gram.
	*/
	private static final int I_MOMSFAKTOR = (int) (MOMSFAKTOR * 100.0);
	private static final int I_RABATTFAKTOR1 = (int) (RABATTFAKTOR1 * 100.0);
	private static final int I_RABATTGRENSE1 = (int) (RABATTGRENSE1 * 1000.0);
	private static final int I_RABATTFAKTOR2 = (int) (RABATTFAKTOR2 * 100.0);
	private static final int I_RABATTGRENSE2 = (int) (RABATTGRENSE2 * 1000.0);
	private final String varenavn;
	private final int varenr;
	private int pris; // pris i øre pr. gram, alltid uten moms

	public Vare(String varenavn, int varenr, double pris) {
		this.varenavn = varenavn;
		this.varenr = varenr;
		this.pris = regnOmTilØrePrGram(pris);
	}
	public Vare(String varenavn, int varenr) {
		this.varenavn = varenavn;
		this.varenr = varenr;
		this.pris = 0;
	}
	public String getVarenavn() {
		return varenavn;
	}
	public int getVarenr() {
		return varenr;
	}

	public double getPris() {
		return regnOmTilKrPrKg(pris);
	}
	public void setPris(double pris) {
		this.pris = regnOmTilØrePrGram(pris);
	}

	/**
	*
	* Finner pris uten moms. Eventuell rabatt beregnes.
	*/
	public double finnPrisUtenMoms(double vekt) {
		int vektGram = regnOmTilGram(vekt);
		int beregnetPris = vektGram * pris;
		/*
		* For å beregne rabattert pris, må vi dividere med 100.
		* Her kan vi miste nøyaktighet på grunn av at dette er heltallsdivisjon.
		*/
		if (vektGram >= I_RABATTGRENSE2) {
			beregnetPris = beregnetPris * I_RABATTFAKTOR2 / 100;
		} else if (vektGram >= I_RABATTGRENSE1) {
			beregnetPris = beregnetPris * I_RABATTFAKTOR1 / 100;
		}
		return regnOmTilKr(beregnetPris);
	}
	/**
	*
	* Finner pris med moms.
	*/
	public double finnPrisMedMoms(double vekt) {
		// Litt søkt å konvertere til og fra heltall her på grunn av at det
		// samme skjer i finnPrisUtenMoms(),
		// men oppgaven sier "kun" heltallsberegninger, så da så.
		int prisUtenMomsØre = regnOmTilØre(finnPrisUtenMoms(vekt));
		int prisMedMomsØre = prisUtenMomsØre * I_MOMSFAKTOR / 100;
		return regnOmTilKr(prisMedMomsØre);
	}
	public String toString() {
		java.util.Formatter f = new java.util.Formatter();
		f.format("%.2f", regnOmTilKrPrKg(pris));
		return varenr + ": " + varenavn + ", pris pr. kg kr " + f.toString() + " u.moms.";
	}
	/*
	* Hjelpemetoder.
	*/
	private int regnOmTilØre(double kr) {
		return (int) (kr * 100);
	}
	private double regnOmTilKr(long øre) {
		return øre * 0.01;
	}
	private int regnOmTilØrePrGram(double kr) {
		double øre = regnOmTilØre(kr); // øre pr. kg
		return (int) (øre * 0.001); // øre pr. gram
	}
	private double regnOmTilKrPrKg(long øre) {
		double kr = regnOmTilKr(øre); // kr pr gram
		return kr * 1000; // kr pr. kilo
	}
	private int regnOmTilGram(double kg) {
		return (int) (kg * 1000);
	}
	private double regnOmTilKg(int gram) {
		return gram * 0.001;
	}
}


class Prisberegning7{
  public static void main(String[] args) {
		final double TOLERANSE = 0.001;
		System.out.println("Totalt antall tester: 6");

		Vare vare = new Vare("Ost", 124, 100);
		//Vare vare = new Vare("Ost", 12345, 100);

		if (Math.abs(vare.finnPrisUtenMoms(0.0) - 0.0) < TOLERANSE && Math.abs(vare.finnPrisMedMoms(0.0) - 0.0) < TOLERANSE) {
			System.out.println("Vare: Test 1 vellykket");
		}
		if (Math.abs(vare.finnPrisUtenMoms(2.0) - 200.0) < TOLERANSE &&	Math.abs(vare.finnPrisMedMoms(2.0) - 248.0) < TOLERANSE) {
			System.out.println("Vare: Test 2 vellykket");
		}
		if (Math.abs(vare.finnPrisUtenMoms(3.0) - 270.0) < TOLERANSE &&	Math.abs(vare.finnPrisMedMoms(3.0) - 334.8) < TOLERANSE) {
			System.out.println("Vare: Test 3 vellykket");
		}
		if (Math.abs(vare.finnPrisUtenMoms(4.0) - 360.0) < TOLERANSE &&	Math.abs(vare.finnPrisMedMoms(4.0) - 446.4) < TOLERANSE) {
			System.out.println("Vare: Test 4 vellykket");
		}
		if (Math.abs(vare.finnPrisUtenMoms(5.0) - 400.0) < TOLERANSE &&	Math.abs(vare.finnPrisMedMoms(5.0) - 496.0) < TOLERANSE) {
			System.out.println("Vare: Test 5 vellykket");
		}
		if (Math.abs(vare.finnPrisUtenMoms(6.0) - 480.0) < TOLERANSE &&	Math.abs(vare.finnPrisMedMoms(6.0) - 595.2) < TOLERANSE) {
			System.out.println("Vare: Test 6 vellykket");
		}

  }
}
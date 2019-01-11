/*
 * Prisberegning2.java
 */

class Vare {
  private static final double MOMS = 24.0;
  private static final double MOMSFAKTOR = 1.0 + MOMS / 100.0;

  private String varenavn;
  private int varenr;
  private double pris; // pris pr kilo, alltid uten moms

  public Vare(String startVarenavn, int startVarenr, double startPris) {
   if ( startVarenr < 1000||startVarenr > 100000|| startPris < 0.50 ) {
		throw new IllegalArgumentException("Varenummer skal være femsifret og minstepris 0,50 kr");
	}
    varenavn = startVarenavn;
    varenr = startVarenr;
    pris = startPris;
  }

  public Vare(String startVarenavn, int startVarenr) {
    varenavn = startVarenavn;
    varenr = startVarenr;
    pris = 0.0;
  }

 public String getVarenavn() {
    return varenavn;
  }

  public int getVarenr() {
    return varenr;
  }

  public double getPris() {
    return pris;
  }

  public void setPris(double pris) {
    if (pris < 0.50) {
		throw new IllegalArgumentException("Minstepris er 0,50 kr");
	}

    this.pris = pris;
  }

  public double finnPrisUtenMoms(double antKilo) {
    if (antKilo< 0.1 && antKilo > 10) return -1;

    double totalPris = pris * antKilo;
    if (antKilo > 3){
 		totalPris *= 0.9;
  	}
  	if (antKilo > 5){
  		totalPris *= 0.8;
  	}
  	return totalPris;
  }


  public double finnPrisMedMoms(double antKilo) {
    if (antKilo< 0.1 && antKilo > 10) return -1;

    double totalPris = pris * antKilo;
    if (antKilo > 3){
  		totalPris *= 0.9;
  	}
  	if (antKilo > 5){
  		totalPris *= 0.8;
  	}
  	return totalPris * MOMSFAKTOR;
  }


  public String toString() {
    java.util.Formatter f = new java.util.Formatter();
    f.format("%.2f", pris);
    return varenr + ": " + varenavn + ", pris pr. kg kr " + f.toString() + " u.moms.";
  }
}

class Prisberegning6{
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

/* Kjøring av programmet:



*/




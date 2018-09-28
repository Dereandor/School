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
    if (startVarenr < 10000 || startVarenr > 100000 || startPris < 0.50) {
		throw new IllegalArgumentException("Varenummer skal være femsifret og minstepris 0,50kr");
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

class Prisberegning5 {
  public static void main(String[] args) {
    try{
		Vare vare = new Vare("Norgesost", 124, 79.50);
	} catch (IllegalArgumentException e){
		System.out.println ("Feilmelding konstruktør: " + e.toString());
	}

	//	Vare vareNy = new Vare("Norgesost", 124, 79.50);

	Vare vare = new Vare("Norgesost", 16724000, 79.50);

    System.out.println(vare.toString());

    // Leser inn antkg fra bruker
	double antKg = Double.parseDouble(javax.swing.JOptionPane.showInputDialog("Antall kg: "));

	//ønsker formatert utskrift
	java.text.DecimalFormat format = new java.text.DecimalFormat("###0.00");

	// beregner pris med og uten moms
	while (vare.finnPrisUtenMoms(antKg) < 0){
		System.out.println ("Antallkilo skal være mellom 0.1 og 10 kg");
		antKg = Double.parseDouble(javax.swing.JOptionPane.showInputDialog("Antall kg: "));
	}

	System.out.println(antKg + " ost koster: "  + format.format(vare.finnPrisUtenMoms(antKg)) + ",- u/mva");



	while (vare.finnPrisMedMoms(antKg) < 0){
			System.out.println ("Antallkilo skal være mellom 0.1 og 10 kg");
			antKg = Double.parseDouble(javax.swing.JOptionPane.showInputDialog("Antall kg: "));
	}

	System.out.println(antKg + " ost koster: "+ format.format(vare.finnPrisMedMoms(antKg)) + ",- m/mva");

  }
}

/* Kjøring av programmet:



*/




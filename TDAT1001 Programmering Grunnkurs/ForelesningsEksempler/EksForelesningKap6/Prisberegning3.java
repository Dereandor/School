/*
 * Prisberegning3.java
 */

import static javax.swing.JOptionPane.*;
class Vare {
  private static final double MOMS = 24.0;
  private static final double MOMSFAKTOR = 1.0 + MOMS / 100.0;

  private String varenavn;
  private int varenr;
  private double pris; // pris pr kilo, alltid uten moms

  public Vare(String startVarenavn, int startVarenr, double startPris) {
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
    this.pris = pris;
  }

  public double finnPrisUtenMoms(double antKilo) {
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

class Prisberegning3 {
  public static void main(String[] args) {
    Vare vare = new Vare("Norgesost", 124, 79.50);
    System.out.println(vare.toString());
	// Leser inn antkg fra bruker
	double antKg = Double.parseDouble(showInputDialog("Antall kg (0 for å avslutte): "));
	while (antKg > 0) {

		//ønsker formatert utskrift
		java.text.DecimalFormat format = new java.text.DecimalFormat("###0.00");

		// beregner pris med og uten moms
		showMessageDialog(null,antKg + " ost koster: "  + format.format(vare.finnPrisUtenMoms(antKg)) + ",- u/mva");
		showMessageDialog(null,antKg + " ost koster: "+ format.format(vare.finnPrisMedMoms(antKg)) + ",- m/mva");
	  // Leser inn antkg fra bruker
		antKg = Double.parseDouble(showInputDialog("Antall kg (0 for å avslutte): "));
	}
  }
}

/* Kjøring av programmet:

124: Norgesost, pris pr. kg kr 79,50 u.moms.
78.0 ost koster: 4464,72,- u/mva
78.0 ost koster: 5536,25,- m/mva

*/




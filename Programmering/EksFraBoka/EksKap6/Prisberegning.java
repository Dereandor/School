/**
 * Prisberegning.java  - "Programmering i Java", 4.utgave - 2009-07-01
 *
 * Filen inneholder to klasser:
 * Vare: Klassen beskriver varer med navn, nummer og pris.
 * Prisberegning: Oppretter to vareobjekter.
 *
 * Programmet brukes i øvingsoppgaver i kapittel 6.
 */
import static javax.swing.JOptionPane.*;

class Vare {
  public static final double MOMS = 24.0;
  public static final double MOMSFAKTOR = 1.0 + MOMS / 100.0;

  private final String varenavn;
  private final int varenr;
  private double pris; // pris pr. kilo, alltid uten moms

  public Vare(String startVarenavn, int startVarenr, double startPris) {
    if (startVarenr <10000 || startVarenr > 100000 || startPris < 0.50) {
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
      throw new IllegalArgumentException("Minstepris er 0,50kr");
    }

    this.pris = pris;
  }

  public double finnPrisUtenMoms(double antKilo) {
    double totalPris = pris * antKilo;
    if (antKilo > 5) {
      totalPris *= 0.8;
    }
    else if (antKilo > 3) {
      totalPris *= 0.9;
    }
    return totalPris;
  }

  public double finnPrisMedMoms(double antKilo) {
    double totalPris = pris * antKilo;
    if (antKilo > 5) {
      totalPris *= 0.8;
    }
    else if (antKilo > 3) {
      totalPris *= 0.9;
    }
    return totalPris * MOMSFAKTOR;
  }

  public String toString() {
    java.util.Formatter f = new java.util.Formatter();
    f.format("%.2f", pris);
    return varenr + ": " + varenavn + ", pris pr. kg kr " + f.toString() + " u.moms.";
  }
}

class Prisberegning {
  public static void main(String[] args) {
    try {
      Vare vare = new Vare("Norgesost", 124, 79.50);
    } catch (IllegalArgumentException e) {
      System.out.println("Feilmelding konstruktør: " + e.toString());
    }

    Vare vare = new Vare("Norgesost", 16724000, 79.50);

    System.out.println(vare.toString());

    double antKg = Double.parseDouble(showInputDialog("Antall kg (0 for å avslutte): "));
    while (antKg > 0) {

      java.text.DecimalFormat format = new java.text.DecimalFormat("###0.00");

      showMessageDialog(null,antKg + " kg ost koster: " + format.format(vare.finnPrisUtenMoms(antKg)) + ",- u/mva");
      showMessageDialog(null,antKg + " kg ost koster: " + format.format(vare.finnPrisMedMoms(antKg)) + ",- m/mva" + " Momsen er: " + vare.MOMS + " %");
      antKg = Double.parseDouble(showInputDialog("Antall Kg (0 for å avslutte: "));
    }
  }
}

/* Kjøring av programmet:
124: Norgesost, pris pr. kg kr 79,50 u.moms.
*/
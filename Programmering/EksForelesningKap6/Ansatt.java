/**
 * Ansatt.java  - "Programmering i Java", 4.utgave - 2009-07-01
 *
 * Klassen beskriver en ansatt med nr, navn, skatteprosent og timel�nn.
 * Det er mulig � endre skatteprosent og timel�nn.
 * Det foretas ingen kontroll av at den nye skatteprosenten er under grensen.
 * Skattetrekk, netto- og bruttol�nn kan regnes ut.
 */
import static javax.swing.JOptionPane.*;
class Ansatt {
  public static final double MAKS_SK_PROS = 60.0;

  private final int ansattnr;
  private final String navn;
  private double timel�nn;
  private double skatteprosent = MAKS_SK_PROS;

  public Ansatt(int ansattnr, String navn, double timel�nn) {

    this.ansattnr = ansattnr;
    this.navn = navn;
    this.timel�nn = timel�nn;
  }

  public Ansatt(int ansattnr, String navn) {
	  	  if (ansattnr < 1000 || ansattnr > 9999){
	  		  throw new IllegalArgumentException("Feil ansattnr!");
	  }
    this.ansattnr = ansattnr;
    this.navn = navn;
    this.timel�nn = 0.0;
  }

  public int getAnsattnr() {
    return ansattnr;
  }

  public String getNavn() {
    return navn;
  }

  public double getTimel�nn() {
    return timel�nn;
  }

  public double getSkatteprosent() {
    return skatteprosent;
  }

  public void setTimel�nn(double nyTimel�nn) {
      timel�nn = nyTimel�nn;
  }

  public void setSkatteprosent(double nySkattepros) {
	  if (nySkattepros < 0.0 || nySkattepros > MAKS_SK_PROS){
		  throw new IllegalArgumentException("Ugyldig skatteprosent");
	  }
      skatteprosent = nySkattepros;
  }

  public double beregnBruttol�nn(double antTimer) {
    return antTimer * timel�nn;
  }

  public double beregnSkattetrekk(double antTimer) {
    return beregnBruttol�nn(antTimer) * skatteprosent / 100.0;
  }

  public double beregnNettol�nn(double antTimer) {
    return beregnBruttol�nn(antTimer) - beregnSkattetrekk(antTimer);
  }

  public String toString() {
    return "Ansattnr.: " + ansattnr + ", navn: " + navn + ", timel�nn: "
            + ", skatteprosent: " + skatteprosent;
  }

  public static void main(String[] args){
		  Ansatt per = new Ansatt(1111, "Per"); System.out.println("Per ok");
		  per.setSkatteprosent(10); System.out.println("skatt ok per");
		//  per.setSkatteprosent(-1); System.out.println("skatt 2 og per");
//	try{
		  Ansatt kari = new Ansatt(1, "Kari");System.out.println("Kari ok");
		  Ansatt ole = new Ansatt(9999, "Ole");System.out.println("Ole ok");
//	  }catch(Exception e){
//		  System.out.println("Noe gikk feil: " + e.getMessage());
//	  }

/*
	  Ansatt enAnsatt = new Ansatt(12345, "Anne Vik", 400);
	  enAnsatt.setSkatteprosent(35);
	  String antTimerLest = showInputDialog("Antall timer, avslutt med Esc: ");

	  while (antTimerLest != null) {
		  double antTimer = Double.parseDouble(antTimerLest);
		  double bruttol�nn = enAnsatt.beregnBruttol�nn(antTimer);

		  String utskrift = "Antall timer: " + antTimer + " gir bruttol�nn " + bruttol�nn;

		  double skatt = enAnsatt.beregnSkattetrekk(antTimer);
		  utskrift += (" og skattetrekk " + skatt);

		 showMessageDialog(null, utskrift);
		  antTimerLest = showInputDialog("Antall timer, avslutt med Esc: ");
		}
*/
  }

}
/*
 * ValutaTest.java, LH 2004-09-29
 * Løsningsforslag til oppgave 5.14.3
 *
 * Klientprogram som tester ut klassen Valuta
 */

import static javax.swing.JOptionPane.*;

class Valuta {
  /*
   * Objektvariabler
   */
  private String navn;
  private double kurs;
  private int enhet;

  /*
   * Konstruktør
   */
  public Valuta(String startNavn, double startKurs, int startEnhet) {
    navn = startNavn;
    kurs = startKurs;
    enhet = startEnhet;
  }

  /*
   * Metoder
   */
  public double beregnTilNOK(double antall) {
    return antall * kurs / enhet;
  }

  public double beregnFraNOK(double antall) {
    return antall * enhet / kurs;
  }

  public String finnNavn(){
	return navn;
  }

  public void settKurs(double nyKurs){
    kurs = nyKurs;
  }
} // Valuta




/*
 * Klientprogram (program som tester klassen Valuta)
 */

class ValutaTest {
	public static void main(String[] args) {

		/* Oppretter tre ulike valuta-objekter */
		Valuta usd = new Valuta("usd", 5.85, 1);
		Valuta sek = new Valuta("sek",85, 100);
		Valuta euro = new Valuta("euro", 7.32, 1);

	    String valutaListe = "\n---------------------\n1. USD\n2.SEK\n3.EURO\n\n9.Avslutt\n---------------------";
		String valgLest = showInputDialog("Velg valuta (9 avslutter): " + valutaListe);
		int valg = Integer.parseInt(valgLest);

		while (valg != 9 ){

			if (valg>0 && valg<4){
				/* Les inn beløp som skal omformes */
				String beløpLest = showInputDialog("Beløp?");
				double beløp = Double.parseDouble(beløpLest);

				/* Spør etter hvilken vei det skal regnes */
				int svar = showConfirmDialog(null, "Skal du regne fra NOK  ?", "Valuta", YES_NO_OPTION);

				boolean tilNok = (svar == YES_OPTION);
				boolean okMenyvalg = true;
				double svarBeløp = 0;
				String valutaNavn="";

				switch(valg){
					case 1: // usd
						if (tilNok){
							svarBeløp = usd.beregnTilNOK(beløp);
						}else{
							svarBeløp = usd.beregnFraNOK(beløp);
						}
						valutaNavn ="USD";
					break;
					case 2: // sek
						if (tilNok){
							svarBeløp = sek.beregnTilNOK(beløp);
						}else{
							svarBeløp = sek.beregnFraNOK(beløp);
						}
						valutaNavn ="SEK";
					break;
					case 3: // euro
						if (tilNok){
							svarBeløp = euro.beregnTilNOK(beløp);
						}else{
							svarBeløp = euro.beregnFraNOK(beløp);
						}
						valutaNavn ="EURO";
					break;
					default:
					break;
				}

				if (tilNok) {  // skal regne fra norske kroner
				   showMessageDialog(null, beløp + " NOK er " + svarBeløp + " i " + valutaNavn);
				} else { //  skal regne til norske kroner
				  showMessageDialog(null, beløp + " " + valutaNavn  + " er " + svarBeløp + " i NOK");
				}
			}else{
				showMessageDialog(null, "Ugyldig menyvalg");
			}
			valgLest = showInputDialog("Velg Valuta (9 avslutter): " + valutaListe);
			valg = Integer.parseInt(valgLest);
		}
	}
} // Valutatest



/* Resultater i JOptionPane-bokser:
***Inndata: Valutaens kursnavn?  USD
***Inndata: Valutaens enhet (f.eks. 1 eller 100)?  1
***Inndata: Valutaens kurs (verdien av 1 USD'er)?  7.63
***Inndata: Beløp? 250.0
***Inndata: Spørsmål: Skal du regne fra NOK til USD? Svar: Nei.
***Melding: 250.0 USD er 1907.5 i NOK
*/
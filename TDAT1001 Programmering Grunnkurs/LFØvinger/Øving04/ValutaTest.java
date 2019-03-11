/*
 * ValutaTest.java, LH 2004-09-29
 * L�sningsforslag til oppgave 5.14.3
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
   * Konstrukt�r
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
				/* Les inn bel�p som skal omformes */
				String bel�pLest = showInputDialog("Bel�p?");
				double bel�p = Double.parseDouble(bel�pLest);

				/* Sp�r etter hvilken vei det skal regnes */
				int svar = showConfirmDialog(null, "Skal du regne fra NOK  ?", "Valuta", YES_NO_OPTION);

				boolean tilNok = (svar == YES_OPTION);
				boolean okMenyvalg = true;
				double svarBel�p = 0;
				String valutaNavn="";

				switch(valg){
					case 1: // usd
						if (tilNok){
							svarBel�p = usd.beregnTilNOK(bel�p);
						}else{
							svarBel�p = usd.beregnFraNOK(bel�p);
						}
						valutaNavn ="USD";
					break;
					case 2: // sek
						if (tilNok){
							svarBel�p = sek.beregnTilNOK(bel�p);
						}else{
							svarBel�p = sek.beregnFraNOK(bel�p);
						}
						valutaNavn ="SEK";
					break;
					case 3: // euro
						if (tilNok){
							svarBel�p = euro.beregnTilNOK(bel�p);
						}else{
							svarBel�p = euro.beregnFraNOK(bel�p);
						}
						valutaNavn ="EURO";
					break;
					default:
					break;
				}

				if (tilNok) {  // skal regne fra norske kroner
				   showMessageDialog(null, bel�p + " NOK er " + svarBel�p + " i " + valutaNavn);
				} else { //  skal regne til norske kroner
				  showMessageDialog(null, bel�p + " " + valutaNavn  + " er " + svarBel�p + " i NOK");
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
***Inndata: Bel�p? 250.0
***Inndata: Sp�rsm�l: Skal du regne fra NOK til USD? Svar: Nei.
***Melding: 250.0 USD er 1907.5 i NOK
*/
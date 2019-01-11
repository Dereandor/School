/*
Regn ut lønn og skattetrekk for Anne Vik med 400 kroner i timelønn og 35% skattetrekk

Første utkast til algoritme: Pseudokode eller Aktivitetsdiagram

Opprett et objekt av klassen Ansatt med data om Anne Vik
For hvert gjennomløp av løkkekroppen
les antall timer
regn ut bruttolønn
skriv ut bruttolønn
regn ut skattetrekk
skriv ut skattetrekk

*/
import static javax.swing.JOptionPane.*;

class Ansatt2Klient{
	public static void main(String[] args){
		Ansatt2 anneVik = null;
		try{
			anneVik = new Ansatt2(1234, "Anne Vik", 400);
		}catch(IllegalArgumentException iae){
			showMessageDialog(null, "Ugyldig ansattnr! " + iae.getMessage());
			System.exit(0);
		}
		anneVik.setSkatteprosent(35);
	//	Ansatt2 anneVik = new Ansatt2(1234, "Anne Vik", 400, 35);
		String lesAntallTimer = showInputDialog("Skriv inn antall timer ('ESC-avslutter'): ");

		while(lesAntallTimer != null ){
			double antTimer =  Double.parseDouble(lesAntallTimer) ;
			double brutto =    anneVik.beregnBruttolønn(antTimer);
			String resultat = "Bruttolønn: " + brutto;

			double skattetrekk =  anneVik.beregnSkattetrekk(antTimer);
			resultat += "Skattetrekk: " + skattetrekk;

			double netto =    anneVik.beregnNettolønn(antTimer);
			resultat += "Nettolønn: " + netto;

			showMessageDialog(null,resultat);
		    lesAntallTimer = showInputDialog("Skriv inn antall timer ('ESC-avslutter'): ");

		}

		System.out.println("Vi avslutter");

	}

}
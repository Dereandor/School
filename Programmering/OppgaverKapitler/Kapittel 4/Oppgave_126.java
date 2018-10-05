/**
* Oppgave side 126
* Programmet leser inn heltall fra brukeren og regner ut summen.
* Hvis flere like tall følger etter hverandre, tas de bare med én gang 
* i summen. Brukeren avslutter tallrekken med Esc.
*/

import static javax.swing.JOptionPane.*;

class Oppgave_126 {
	
	public static void main(String[]args) {
		
		int antallTallSummert = 0;
		int sum = 0;
		int sumAlle = 0;
		int antallAlle = 0;
		double snittSum = 0.0;
		
		
		String forrigeTallLest = "";
		String tallLest = showInputDialog("Skriv et tall av gangen, avslutt med Esc: ");
		
		/* Gå i løkke så lenge som Esc ikke er tastet */
		while (tallLest != null) {
			if (!tallLest.equals(forrigeTallLest)) {
				int tall = Integer.parseInt(tallLest);
				sum += tall;
				antallTallSummert++;
				snittSum = sum / antallTallSummert;
			}
			forrigeTallLest = tallLest; //tar vare på siste innleste tall
			tallLest = showInputDialog("Skriv ett tall av gangen, avslutt med Esc: ");
			
			
		}
		showMessageDialog(null, "Summen er " + sum + ". Vi har summert " + antallTallSummert
		+ " tall." + snittSum + " Er snittet av gjeldende tall.");
	}
}
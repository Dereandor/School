
import static javax.swing.JOptionPane.*;
class Karakter_losning{
	public static void main(String[] args){
		// Lag en konstant/flere for karaktergrenser
		final int MAKS = 100;
		final int MIN = 0;
		final int A = 96;
		final int B = 86;
		final int C = 71;
		final int D = 55;
		final int E = 36;

		// les inn poengsum fra bruker vha JOptionPane
		String poengsumLest = showInputDialog("Skriv inn poengsum");

		// Konverter innlest poengsum fra String til int
		int poengsum = Integer.parseInt(poengsumLest);

		// opprett en variabel som skal inneholde melding om oppnådd karakter til bruker
		String resultat= "Poengsum " + poengsum + " gir karakter: ";

		// valg struktur: Sjekk hvilket intervall poengsum ligger i.
		// 100+, 96+, 86+, 71+, 55+, 36+. 0+, 0--
		if (poengsum > MAKS || poengsum < MIN){
			resultat = "Ugyldig poengsum";
		} else if (poengsum >= A){
			resultat += "A";
		}else if (poengsum >= B){
			resultat += "B";
		}else if (poengsum >= C){
			resultat += "C";
		} else if (poengsum >= D){
			resultat += "D";
		} else if (poengsum >= E){
			resultat += "E";
		} else {
			resultat += "F";
		}

		// Skriv melding til bruker
		showMessageDialog(null, resultat);


	}
}
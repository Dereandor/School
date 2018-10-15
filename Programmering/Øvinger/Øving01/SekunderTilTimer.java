/**
 * Regner om Sekunder til Timer, Minutter og Sekunder
 *
 */

import static javax.swing.JOptionPane.*;

class SekunderTilTimer {

	public static void main(String[] args) {

		String sekunderLest = showInputDialog("Antall sekunder: ");

		int sekunderTotal = Integer.parseInt(sekunderLest) ;
		int timer = sekunderTotal/3600 ;
		int minutter = (sekunderTotal%3600) / 60 ;
		int sekunder = (sekunderTotal%3600) % 60 ;

		String utskrift = sekunderTotal + " sekunder blir " + timer + " timer " + minutter + " minutter og " + sekunder + " sekunder." ;
		showMessageDialog(null, utskrift) ;
	}
}
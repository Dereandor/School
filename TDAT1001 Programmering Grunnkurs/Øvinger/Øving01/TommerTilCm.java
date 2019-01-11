/**
 * Omregner tommer til centimeter
 */


import static javax.swing.JOptionPane.*;

class TommerTilCm {

	public static void main(String[] args) {

		String tommerLest = showInputDialog("Antall (tommer): ");

		double tommer = Double.parseDouble(tommerLest);
		double centimeter = tommer * 2.54;

		String utskrift = tommer + " tommer blir " + centimeter + " centimeter" ;
		showMessageDialog(null, utskrift);
	}
}
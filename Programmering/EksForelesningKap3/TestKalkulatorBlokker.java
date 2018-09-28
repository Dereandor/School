import static javax.swing.JOptionPane.*;
class TestKalkulatorBlokker {
	public static void main(String[] args) {
		double tall1 = 12;
		double tall2 = 5;

		int valg = showConfirmDialog(null, "Legge sammen? ","Kalkulator", YES_NO_OPTION);
		String resultat = "\nSvaret er ";

		if (valg == YES_OPTION) {
			double svar = tall1 + tall2;
			resultat += svar;
		} else {
			double svar = tall1 - tall2;
			resultat += svar;
		}

		showMessageDialog(null, resultat);
	}
}

import static javax.swing.JOptionPane.*;
class Ovingsoppgave_trekanter{
	public static void main (String[] args){
		String lestAntallLinjer = showInputDialog("Antall linjer(0 avslutter): ");
		int antallLinjer = Integer.parseInt(lestAntallLinjer);
		while (antallLinjer > 0){ // avslutter dersom bruker skriver inn 0 eller negativt tall

			/* Del A, rettvinket trekant */
			String output = "Rettvinklet Trekant: \n";
			for(int i=0; i<=antallLinjer; i++){

				for (int j=0; j<i; j++){
					output += "* ";
				}
				output += "\n";
			}

			/* Del B - likesidet Trekant*/
			output += "\n\nLikesidet Trekant:\n";
			for (int i = 0; i < antallLinjer; i++){
				int antallStjerner = 1 + 2 * (i);
				int antallSpace = antallLinjer - i;
				for (int j = 0; j < antallSpace; j++){
					output += " ";
				}

				for (int k = 0; k < antallStjerner; k++){
					output += "*";
				}
				output += "\n";
			}

			/* Skriver ut resultatet og leser inn på nytt fra bruker */
			showMessageDialog(null, output);
			lestAntallLinjer = showInputDialog("Antall linjer(0 avslutter): ");
			antallLinjer = Integer.parseInt(lestAntallLinjer);
		}
	}
}

/*
testdata:
Antall linjer = 0, - 1, 1, 3, 10, 100

*/

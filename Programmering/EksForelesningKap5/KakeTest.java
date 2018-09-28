import static javax.swing.JOptionPane.*;
class KakeTest{
	public static void main(String[] args){
		String ingr1 = showInputDialog("Ingrediens 1: ");
		String ingr2 = showInputDialog("Ingrediens 2: ");
		int str = Integer.parseInt(showInputDialog("Kakens str (diameter): "));

		String navn = showInputDialog("Navn:");
		String smak = showInputDialog("Smak (nydelig, ok, fælt):");

		/* Lager objekt av typen Kake */
		Kake minKake = new Kake( ingr1, ingr2, str, navn, smak);

		int antStykker = minKake.getAntKakestykker();

		showMessageDialog(null,minKake + "\nAntall kakestykker: "+ antStykker);
		/*System.out.println(minKake + "\nAntall kakestykker: "+ antStykker);*/

	}
}

/* Eksempel på kjøring:


Lukket valnøtt
Ingredienser: Egg, Marsipan
Størrelse: 28cm
Kaken smaker nydelig
Antall kakestykker: 20


*/
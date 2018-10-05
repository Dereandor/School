import static javax.swing.JOptionPane.*;
class Nedbor{
	public static void main(String[] args){
		int[] tab = {1,2,3,4};

		/* Oppretter et objekt av typen Maned  -
		 * Husk at argumentene ("januar", tab) m� samsvare med
		 * parameterlista (string mndNavn, int[] nedb�r) til konstrukt�ren
		 * i klassen Maned.
		*/
		Maned januar = new Maned("januar", tab);
		System.out.println(januar);  // skriver ut ved � kalle toString()-metoden i Maned

		/* Tester metodene i klassen: */
		int tall = januar.finnNedbør(5);
		if (tall == -1){
			System.out.println("Feil indeks.." );
		}else{
			System.out.println("Nedbør: " + tall);
		}

		/* Leser inn indeks fra bruker og g�r i l�kke helt til bruker taster inn gyldig indeks */
		int indeks = Integer.parseInt(showInputDialog("Hvilken dag vil du ha data om(0-" + (januar.finnAntDager()-1) + "):"));
		tall = januar.finnNedbør(indeks);   // Var dette et fornuftig variabelnavn?

		while(tall == -1){  // ugyldig indeks
			showMessageDialog(null, "Ugyldig indeks");
			indeks = Integer.parseInt(showInputDialog("Hvilken dag vil du ha data om(0-" + (januar.finnAntDager()-1) + "):"));
			tall = januar.finnNedbør(indeks);
		}

		System.out.println("Nedbør for " + (indeks+1) + ". " + januar.getMndNavn() + ": " + tall);
		System.out.println("Maks mm nedbør: " + januar.finnMaksimum());
		System.out.println("Gjennomsnitt: " + januar.finnGjSnitt());
		System.out.println("Antall tørre dager: " + januar.finnAntTørreDager());

	}
}

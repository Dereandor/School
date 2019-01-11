/*
Vare
-------
-varenavn
-energi
-fett
-karbo
---------------------
+finnVarenavn()
+finnAntallGramFett()  /for en bestemt mengde i gram
+finnAntallGramKarbo() /for en bestemt mengde i gram
+finnEnergiInnholdet() /for en bestemt mengde i gram
+finnEnergiInnholdetIKcal() /for en bestemt mengde i gram
*/


/*
Vare
-------
-String varenavn {readonly}
-int energi {readonly}
-double fett {readonly}
-double karbo {readonly}
---------------------
+Vare(String varenavn, int energi, double fett, double karbo)
+String finnVarenavn()
+double finnAntallGramFett(int mengde)
+double finnAntallGramKarbo(int mengde)
+int finnEnergiInnholdet(int mengde)
+double finnEnergiInnholdetIKcal(int mengde)
*/

import static javax.swing.JOptionPane.*;

class Vare{

	private String varenavn;
	private int energi;
	private double fett;
	private double karbo;

	// konstruktør
	public Vare(String varenavn, int energi, double fett, double karbo){
		this.varenavn = varenavn;
		this.energi = energi;
		this.fett = fett;
		this.karbo = karbo;
	}

	// metoder

	public String finnVareNavn() {
		return varenavn;
	}

	public double finnAntallGramFett(int mengde){
		return fett * mengde;
	}

	public double finnAntallGramKarbo(int mengde) {
		return karbo * mengde;
	}

	public int finnEnergiInnhold(int mengde) {
		return energi * mengde;
	}

	public double finnEnergiInnholdIKcal(int mengde){
		return energi * mengde * 4.18;
	}

	public String toString(){
		return varenavn + " " + energi + " " + fett + " " + karbo;
	}

} // klassen Vare

class VareNaering11{

	public static void main(String[] args){

		Vare pomFritGkj = new Vare("pomFitGkj", 1381, 3.0, 39.8);
		Vare pomFritFryst = new Vare("pomFitFryst", 641, 2.2, 22.0);
		Vare koktPotet = new Vare("koktPotet", 339, 1.9, 17.1);

		String lestMengde = showInputDialog("Hvor mange gram vare har du (Esc for å avslutte): ");
		int antallGram =0;
		if (lestMengde != "null") {antallGram = Integer.parseInt(lestMengde);}

		while ((lestMengde != "null")){ // avslutter dersom bruker trykker Esc

		  String objektGkj = pomFritGkj + " Energi: " + pomFritGkj.finnAntallGramFett(antallGram) + " " + pomFritGkj.finnAntallGramKarbo(antallGram);
		  objektGkj += " " + pomFritGkj.finnEnergiInnhold(antallGram) + " " + pomFritGkj.finnEnergiInnholdIKcal(antallGram) + "\n";

		  String objektFryst = pomFritFryst + " Energi: " + pomFritFryst.finnAntallGramFett(antallGram) + " " + pomFritFryst.finnAntallGramKarbo(antallGram);
		  objektFryst += " " + pomFritFryst.finnEnergiInnhold(antallGram) + " " + pomFritFryst.finnEnergiInnholdIKcal(antallGram) + "\n";

		  String objektPotet = koktPotet + " Energi: " + koktPotet.finnAntallGramFett(antallGram) + " " + koktPotet.finnAntallGramKarbo(antallGram);
		  objektPotet += " " + koktPotet.finnEnergiInnhold(antallGram) + " " + koktPotet.finnEnergiInnholdIKcal(antallGram);

		  showMessageDialog(null, objektGkj + objektFryst + objektPotet);

		  lestMengde = showInputDialog("Hvor mange gram vare har du (Esc for å avslutte): ");
		  if (lestMengde != "null") {antallGram = Integer.parseInt(lestMengde);}

		} // end while
    } // end main
} // end class

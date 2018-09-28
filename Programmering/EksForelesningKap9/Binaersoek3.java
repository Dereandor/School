/**
 * BinaerSoek.java  - "Programmering i Java", 4.utgave - 2009-07-01
 */

class Binaersoek3 {

  /**
   * Binærsøk. Forutsetter at tabellen er sortert.
   * Metoden returnerer indeksen der verdien finnes.
   * Hvis verdien ikke finnes, returneres et negativt tall som er slik at
   * verdien kan settes inn på indeks (- tall -1) slik at
   * tabellen fortsatt er sortert.
   */
  public static int binærsøkHeltallstabell(int[] tabell, int antElem, int verdi) {
    int start = 0;
    int slutt = antElem - 1;
    while (start <= slutt) {
      int midten = (start + slutt) / 2;
      if (tabell[midten] == verdi) {
        return midten;  // RETUR. Verdien er funnet.
      } else {
        if (tabell[midten] < verdi) {
          start = midten + 1;
        } else {
          slutt = midten - 1;
        }
      }
    }
    return -start - 1;  // verdien ikke funnet.
  }

  /* Testklient */
  public static void main(String[] args) {
    int[] enTabell = new int[8];
    int tabellTeller = 0;
    enTabell[0] = -15; tabellTeller ++;
    enTabell[1] = -5;  tabellTeller ++;
    enTabell[0] = -15; tabellTeller ++;
    enTabell[2] = 5;   tabellTeller ++;
    enTabell[3] = 7;   tabellTeller ++;
    enTabell[4] = 17;  tabellTeller ++;

    System.out.println("Totalt antall tester: 6");
    int indeks = binærsøkHeltallstabell(enTabell, tabellTeller, -5);  // tall finnes
    if (indeks == 1) {
      System.out.println("Binaersoek: Test 1 vellykket");
    }
    indeks = binærsøkHeltallstabell(enTabell, tabellTeller, 17); // tall finnes
    if (indeks == 4) {
      System.out.println("Binaersoek: Test 2 vellykket");
    }
    indeks = binærsøkHeltallstabell(enTabell, tabellTeller, 1); // tall finnes ikke
    if (indeks < 0 && (tabellTeller <= enTabell.length)) {
	  for (int s = enTabell.length-1; s > -indeks-1; s--){
	    enTabell[s] = enTabell[s-1];
	  }
	  enTabell[-indeks-1] = 1;
	  tabellTeller++;
      System.out.println("Binaersoek: Test 3 vellykket");
    }
    indeks = binærsøkHeltallstabell(enTabell, tabellTeller, 15); // tall finnes ikke
	    if (indeks < 0 && (tabellTeller <= enTabell.length)) {
		  for (int s = enTabell.length-1; s > -indeks-1; s--){
		    enTabell[s] = enTabell[s-1];
		  }
		  enTabell[-indeks-1] = 15;
		  tabellTeller++;
	      System.out.println("Binaersoek: Test 4 vellykket");
	    }else System.out.println("Binaersoek: Test 4 mislykket");

 	indeks = binærsøkHeltallstabell(enTabell, tabellTeller, 8); // tall finnes ikke
	    if (indeks < 0 && (tabellTeller <= enTabell.length)) {
		  for (int s = enTabell.length-1; s > -indeks-1; s--){
		    enTabell[s] = enTabell[s-1];
		  }
		  enTabell[-indeks-1] = 8;
		  tabellTeller++;
	      System.out.println("Binaersoek: Test 5 vellykket");
	    }else System.out.println("Binaersoek: Test 5 mislykket");

 	indeks = binærsøkHeltallstabell(enTabell, tabellTeller, -3); // tall finnes ikke
	    if (indeks < 0 && (tabellTeller <= enTabell.length)) {
		  for (int s = enTabell.length-1; s > -indeks-1; s--){
		    enTabell[s] = enTabell[s-1];
		  }
		  enTabell[-indeks-1] = -3;
		  tabellTeller++;
	      System.out.println("Binaersoek: Test 6 vellykket");
	    }else System.out.println("Binaersoek: Test 6 mislykket");

    for (int i = 0; i < enTabell.length; i++)
      System.out.print(enTabell[i] + " ");
  }
}

/*
 * SorteringAvTall.java
 *
 * En sorteringsmetode
 */

class Sortering {
  public static void sorterHeltallstabell(int[] tabell) {  // klassemetode
    for (int start = 0; start < tabell.length; start++) {
      int hittilSt�rst = start;
      for (int i = start + 1; i < tabell.length; i++) {
        if (tabell[i] > tabell[hittilSt�rst]) hittilSt�rst = i;
      } // indre for l�kke
      int hjelp = tabell[hittilSt�rst];
      tabell[hittilSt�rst] = tabell[start];
      tabell[start] = hjelp;
    } // ytre for l�kke
  } // end metode sorterHeltallsTabell
}// end class Sortering


class SorteringAvTall {
  public static void main(String[] args) {
    int[] enTabell = {3, 4, -5, 13, 10, 0, 8, -2, 22, 15, 11, 9, 17};
    Sortering.sorterHeltallstabell(enTabell);  //klassenavnet foran metode-navnet

	System.out.println("Sorterte tall: ");
    for (int i = 0; i < enTabell.length; i++){
		System.out.print(enTabell[i] + " ");
    } // end for l�kke
	 System.out.println();
  } // end main
} // end class SorteringAvTall

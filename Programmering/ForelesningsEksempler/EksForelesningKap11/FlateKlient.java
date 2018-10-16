/*
 * FlateKlient.java   E.L. 2004-02-15
 *
 * Enkel testklient for klassen Flate.
 */

class FlateKlient {
  public static void main(String[] args) {
    Flate flaten = new Flate("Berits golv", 5, 6);
    System.out.println(flaten.toString());
    double areal = flaten.finnAreal();
    double omkrets = flaten.finnOmkrets();
    java.text.DecimalFormat utskriftFormat = new java.text.DecimalFormat("####0.00");
    System.out.println("Areal: " + utskriftFormat.format(areal) + " kvadratmeter.\n" +
                       "Omkrets: " + utskriftFormat.format(omkrets) + " meter.");



	// Test av equals
    Flate minFlate = new Flate("Grethes", 5, 6);
    if(minFlate.equals(flaten)) System.out.println("A - equals: Flatene er like");
    else System.out.println("A - equals: Flatene er ikke like");

    flaten = minFlate;
    if(minFlate.equals(flaten)) System.out.println("B - equals: Flatene er like");
	else System.out.println("B - equals: Flatene er ikke like");


	// Test av compareTo: Lager to flater og sammenligner disses areal:
	Flate en = new Flate("en", 3,4);
	Flate to = new Flate("to", 3,44);

	int resultat = to.compareTo(en);

	if (resultat < 0 ) System.out.println("C - compareTo: " + to.finnNavn() + " er minst");
	else if (resultat > 0) System.out.println("C - compareTo: " + en.finnNavn() + " er minst");
	else System.out.println("C - compareTo: Flatene er like store");
  }
}

/* Utskrift:
Flate: Berits golv, bredde: 6,00 m, lengde: 5,00 m.
Areal: 30,00 kvadratmeter.
Omkrets: 22,00 meter.
A - equals: Flatene er like
B - equals: Flatene er like
C - compareTo: en er minst

*/
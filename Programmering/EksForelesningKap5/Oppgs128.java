/*	Oppgs128.java GS 28.01.2009

	Oppgave 2 - 4 side 128 i l�reboka
*/

/* oppgave 2
F�lgende utsagn eller Java-setninger er alle sammen feil.
Forklar hva som er feil under hvert enkelt punkt.

a) Per �s er en klasse
b) public double finnL�nn(String maaned),
c) 1756 er en parameter
d) Attributtet navn har et objekt person
e) finnL�nn(String m�ned)
f) Argumentverdien kalles parameter
g) Attributter har hode og kropp
h) En lokal variabel kan n�s i alle metoder i klassen

*/


/* oppgave 3
   Rett opp feil i f�lgende klasse:
*/
class Sirkel{
	private double radius;

	// konstrukt�r
	public Sirkel(double startRadius){
		radius = startRadius;
	}
	public double finnAreal(){
		return Math.PI * radius * radius;
	}

	public double finnOmkrets(){
		double omkrets = 2.0 * Math.PI * radius;
		return omkrets;
	}
}


/* oppgave 4
 F�lgende klientprogram bruker klassen fra oppgave 3. Fyll ut det som mangler:
*/

class Oppgs128{  // SirkelBeregning

	public static void main(String[] args){
		double startRadius = 10;
		Sirkel enSirkel = new Sirkel(startRadius);
		double arealet = enSirkel.finnAreal();

		java.text.DecimalFormat formatet = new java.text.DecimalFormat("##0.00");
		System.out.println("Arealet er lik " + formatet.format(arealet));

		double omkretsen = enSirkel.finnOmkrets();
		System.out.println("Omkretsen er lik " + formatet.format(omkretsen));
	}

}
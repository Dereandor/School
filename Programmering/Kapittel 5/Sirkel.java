/*
* Oppgave 3
* Kapittel 5.2
* Side 161
*
*/

class Sirkel {

	final private double radius;
	//private double areal;
	//private double omkrets;

	public Sirkel(double radius) {
		this.radius = radius;
	}
	public double beregnAreal() {
		double areal = Math.PI * radius * radius;
		return areal;
	}
	public double beregnOmkrets() {
		double omkrets = 2.0 * Math.PI * radius;
		return omkrets;
	}
	public String toString() {
		return 	"Radius: " + radius;
	}

}
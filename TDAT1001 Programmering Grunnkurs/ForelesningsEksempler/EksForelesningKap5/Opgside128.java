/*Oppg2Side128
Følgende utsagn eller java-setninger er alle sammen feil. forklar hva som er feil under hvert enkelt punkt.

a) Per Ås er en klasse.
b) void finnLønn("Januar")
c) 1756 er en parameter.
d) Attributtet navn har et objekt person.
e) finnLønn(String måned)
f) Argumentverdien kalles en parameter.
g) Attributter har både hode og kropp.
h) En lokal variabel kan nås i alle metoder i klassen.
*/





//Oppg3Side128 {

// Finn feil i koden

class Sirkel {
	private double radius;

	public Sirkel(double startRadius){
		radius = startRadius;
	}

	public double finnAreal(){
		return Math.PI * radius * radius; //Math.PI er en klassekonstant
	}

	public double finnOmkrets(){
		double omkrets = 2.0 * Math.PI * radius;
		return omkrets;
	}
}


// Oppg 4 Side128
// Fyll inn det som mangler

	class Opgside128 {   // Sirkelberegning
		public static void main(String[] args) {
			Sirkel enSirkel = new Sirkel(30);
			double arealet = enSirkel.finnAreal();
			System.out.println("Arealet er lik " + arealet);
			double omkretsen = enSirkel.finnOmkrets();
			System.out.println("Onmkretsen er lik " + omkretsen);
		}
	}

package dp1.eks_static;

public class Student {

	private final String navn;
	private final String fdato;
	private static int antStud = 0; // variabel, antall studentobjekter laget
	public static final String SKOLE = "NTNU"; // konstant, kan være offentlig

	public Student(String navn, String fdato) {
		this.navn = navn;
		this.fdato = fdato;
		antStud++;
	}

	public static int finnAntStud() { // merk static, kan kalles uten at objekt er laget
		return antStud;
	}
}

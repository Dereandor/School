/*
Vare
-------
varenavn
varenr
pris pr kg uten moms
---------------------
finn pris for et gitt antall kilo uten moms
finn pris for et gitt antall kilo med moms
sett ny pris
*/

class Vare{

	private String varenavn;
	private long varenr;
	private double pris;
	private final double momsfaktor = 1.24;

	// konstruktør
	public Vare(String varenavn, long startVarenr, double startPris){
		this.varenavn = varenavn;
		varenr = startVarenr;
		pris = startPris;
	}

	// metoder

	public double finnPrisUMva(double antKg){
		double p = pris * antKg;
		return p;
	}

	public double finnPrisMMva(double antKg){
			double p = pris * antKg * momsfaktor;
			return p;
	}

	public void settPris(double nyPris){
		pris = nyPris;
	}

	public String toString(){
		return varenavn + " " + varenr + " " + pris;
	}

} // klassen Vare

class Vare2011{

	public static void main(String[] args){
		String vnavn = "Ost";
		long vnr = 123l;
		double pris = 10;

		Vare ost = new Vare(vnavn, vnr, pris);
		System.out.println(ost);

		double antKg = 3;
		System.out.println("Pris uten mva for " + antKg + ":" + ost.finnPrisUMva(antKg));
		System.out.println("Pris med mva for " + antKg + ":" + ost.finnPrisMMva(antKg));


	}
}
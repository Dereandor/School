/*VareTest11.java

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
	//Objektvariabler
	private String vnavn;
	private int varenr;
	private double pris;

	// standardkonstruktør
	public Vare(){
	}

	public Vare(String startVnavn, int startVarenr, double pris){
		vnavn = startVnavn;
		varenr = startVarenr;
		this.pris = pris;
	}

	public Vare (String vnavn, int varenr){
		this.vnavn = vnavn;
		this.varenr = varenr;
	}


	// tilgangsmetoder
	public String finnVnavn(){
		return vnavn;
	}

	public int finnVarenr(){
		return varenr;
	}

	public double finnPris(){
		return pris;
	}

	// mutasjonsmetoder
	public void settPris(double nypris){
		pris = nypris;
	}

	public void okPris(double okning){
		pris += okning;
	}

/*
finn pris for et gitt antall kilo uten moms
finn pris for et gitt antall kilo med moms

*/

	public double finnPrisUMva(double antallKg){
		double svar = pris * antallKg;
		return svar;
	}

	public double finnPrisMMva(double antallKg){
		double svar = finnPrisUMva(antallKg) * 1.25;
		return svar;
	}
}


//***********************************************

class VareTest11{
	public static void main(String[] args){

		Vare aost = new Vare("Norvegia", 123456, 256.03);
		Vare bost = new Vare("Billig", 654321);

		System.out.println("AOST:" + aost.finnVnavn() + " " + aost.finnVarenr() + " " + aost.finnPris());
		System.out.println("BOST:" + bost.finnVnavn() + " " + bost.finnVarenr() + " " + bost.finnPris());

		// Øk aost pris
		aost.okPris(500);
		System.out.println("AOST - ny pris:" + aost.finnVnavn() + " " + aost.finnVarenr() + " " + aost.finnPris());

		System.out.println("700 kg aost koster: umva: " + aost.finnPrisUMva(700));
		System.out.println("700 kg aost koster: mmva: " + aost.finnPrisMMva(700));

		// sett pris bost
		bost.settPris(10);
		System.out.println("700 kg bost koster: umva: " + bost.finnPrisUMva(700));
		System.out.println("700 kg bost koster: mmva: " + bost.finnPrisMMva(700));



	}
}
class Maned2{

	// objektvariabel
	private final String mndNavn;
	private int[] nedbør;

	// konstruktør
	public Maned2(String mndNavn, int[] nedbør) {
		/*
		* Sjekker først at ingen av nedbørverdiene er negative.
		*/
		for (int i = 0; i < nedbør.length; i++) {
			if (nedbør[i] < 0) {
				throw new IllegalArgumentException(
				"\nNedbørverdi med indeks " + i + " var negativ: " + nedbør[i]
				+ ". \nDet kan finnes flere negative verdier.");
			}
		}
		/*
		* Hvis vi kommer hit, er dataene ok, og de lagres i objektet.
		*/
		this.mndNavn = mndNavn;
		int antDager = nedbør.length;
		this.nedbør = new int[antDager];
		for (int i = 0; i < antDager; i++) {
			this.nedbør[i] = nedbør[i];
		}
	}

	public String getMndNavn(){
		return mndNavn;
	}

	public int finnAntDager(){
		return nedbør.length;
	}

	// grunn kopiering (oppgave s 226 */
	public int[] getNedbør(){
		return nedbør;
	}

	// dyp kopiering, oppgave s. 226
/*	public int[] getNedbør(){
		int[] tabell = new int[nedbør.length];
		for(int i=0; i<nedbør.length; i++){
			tabell[i] = nedbør[i];
		}
		return tabell;
	}

*/
	public int finnNedbør(int indeks){
		if (gyldigIndeks(indeks)){
			return nedbør[indeks];
		}
		return -1;
	}

	private boolean gyldigIndeks(int i){
		 if (i>= 0 && i < nedbør.length){
			 return true;
		 }else {
			return false;
		 }
	}

	public int  finnMaksimum(){
		int maks = 0;
		for(int i=0; i<nedbør.length; i++){
			if(maks < nedbør[i]){
				maks = nedbør[i];
			}
		}
		return maks;
	}

	public int  finnAntTørreDager(){
		int ant = 0;
		for(int i=0; i<nedbør.length; i++){
			if(nedbør[i] == 0){
				ant++;
			}
		}
		return ant;
	}

	public int finnGjSnitt(){
		int sum = 0;
		for(int i=0; i<nedbør.length; i++){
			sum += nedbør[i];
		}

		return sum/nedbør.length;
	}

	/* lager en toString-metode for å kunne skrive ut
	   innhold til objektvariablene på en enkelt måte:
	 */
	 public String toString(){
	 	String res = mndNavn + "\n";
	 	for(int i= 0; i<nedbør.length; i++){
	 			res += nedbør[i] + " ";
	 	}
	 	return res;
	}

	// Oppgaver fra læreboka - gjør disse:
	// Oppgave 1
	public int finnAntDgMaks() {
		int maks = finnMaksimum();
		int antMaks = 0;
		for (int i = 0; i < nedbør.length; i++) {
			if (nedbør[i] == maks) {
				antMaks++;
			}
		}
		return antMaks;
	}

	public int antDgMindreEnn(int grense) {
		int antall = 0;
		for (int i = 0; i < nedbør.length; i++) {
			if (nedbør[i] < grense) {
				antall++;
			}
		}
		return antall;
	}

	public double finnStdAvvik() {
		/*
		* Metoden finnGjSnitt() runder av gjennomsnittet til nærmeste heltall.
		* Resultatet nedenfor hadde blitt mer nøyaktig om vi hadde beholdt
		* gjennomsittsverdien som desimaltall.
		*/
		if (nedbør.length > 1) {
			int gjSnitt = finnGjSnitt();
			long sumKvadrat = 0;
			for (int i = 0; i < nedbør.length; i++) {
				sumKvadrat += (gjSnitt - nedbør[i]) * (gjSnitt - nedbør[i]);
			}
			System.out.println(sumKvadrat);
			double radikand = (double) sumKvadrat / (double) (nedbør.length - 1);
			return Math.sqrt(radikand); // Retur. Std.avvik beregnet etter formel
		} else {
			return 0.0; // Retur. For lite data til å beregne std.avvik
		}
	}


}
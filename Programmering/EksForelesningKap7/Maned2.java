class Maned2{

	// objektvariabel
	private final String mndNavn;
	private int[] nedb�r;

	// konstrukt�r
	public Maned2(String mndNavn, int[] nedb�r) {
		/*
		* Sjekker f�rst at ingen av nedb�rverdiene er negative.
		*/
		for (int i = 0; i < nedb�r.length; i++) {
			if (nedb�r[i] < 0) {
				throw new IllegalArgumentException(
				"\nNedb�rverdi med indeks " + i + " var negativ: " + nedb�r[i]
				+ ". \nDet kan finnes flere negative verdier.");
			}
		}
		/*
		* Hvis vi kommer hit, er dataene ok, og de lagres i objektet.
		*/
		this.mndNavn = mndNavn;
		int antDager = nedb�r.length;
		this.nedb�r = new int[antDager];
		for (int i = 0; i < antDager; i++) {
			this.nedb�r[i] = nedb�r[i];
		}
	}

	public String getMndNavn(){
		return mndNavn;
	}

	public int finnAntDager(){
		return nedb�r.length;
	}

	// grunn kopiering (oppgave s 226 */
	public int[] getNedb�r(){
		return nedb�r;
	}

	// dyp kopiering, oppgave s. 226
/*	public int[] getNedb�r(){
		int[] tabell = new int[nedb�r.length];
		for(int i=0; i<nedb�r.length; i++){
			tabell[i] = nedb�r[i];
		}
		return tabell;
	}

*/
	public int finnNedb�r(int indeks){
		if (gyldigIndeks(indeks)){
			return nedb�r[indeks];
		}
		return -1;
	}

	private boolean gyldigIndeks(int i){
		 if (i>= 0 && i < nedb�r.length){
			 return true;
		 }else {
			return false;
		 }
	}

	public int  finnMaksimum(){
		int maks = 0;
		for(int i=0; i<nedb�r.length; i++){
			if(maks < nedb�r[i]){
				maks = nedb�r[i];
			}
		}
		return maks;
	}

	public int  finnAntT�rreDager(){
		int ant = 0;
		for(int i=0; i<nedb�r.length; i++){
			if(nedb�r[i] == 0){
				ant++;
			}
		}
		return ant;
	}

	public int finnGjSnitt(){
		int sum = 0;
		for(int i=0; i<nedb�r.length; i++){
			sum += nedb�r[i];
		}

		return sum/nedb�r.length;
	}

	/* lager en toString-metode for � kunne skrive ut
	   innhold til objektvariablene p� en enkelt m�te:
	 */
	 public String toString(){
	 	String res = mndNavn + "\n";
	 	for(int i= 0; i<nedb�r.length; i++){
	 			res += nedb�r[i] + " ";
	 	}
	 	return res;
	}

	// Oppgaver fra l�reboka - gj�r disse:
	// Oppgave 1
	public int finnAntDgMaks() {
		int maks = finnMaksimum();
		int antMaks = 0;
		for (int i = 0; i < nedb�r.length; i++) {
			if (nedb�r[i] == maks) {
				antMaks++;
			}
		}
		return antMaks;
	}

	public int antDgMindreEnn(int grense) {
		int antall = 0;
		for (int i = 0; i < nedb�r.length; i++) {
			if (nedb�r[i] < grense) {
				antall++;
			}
		}
		return antall;
	}

	public double finnStdAvvik() {
		/*
		* Metoden finnGjSnitt() runder av gjennomsnittet til n�rmeste heltall.
		* Resultatet nedenfor hadde blitt mer n�yaktig om vi hadde beholdt
		* gjennomsittsverdien som desimaltall.
		*/
		if (nedb�r.length > 1) {
			int gjSnitt = finnGjSnitt();
			long sumKvadrat = 0;
			for (int i = 0; i < nedb�r.length; i++) {
				sumKvadrat += (gjSnitt - nedb�r[i]) * (gjSnitt - nedb�r[i]);
			}
			System.out.println(sumKvadrat);
			double radikand = (double) sumKvadrat / (double) (nedb�r.length - 1);
			return Math.sqrt(radikand); // Retur. Std.avvik beregnet etter formel
		} else {
			return 0.0; // Retur. For lite data til � beregne std.avvik
		}
	}


}
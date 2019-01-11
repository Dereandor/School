class Maned{

	// objektvariabel
	private final String mndNavn;
	private final int[] nedbør;
	// konstruktør
	public Maned(String mndNavn, int[] nedbør){

		/* oppgave 4 s 223: Kast unntak dersom tabellen inneholder negative
		 * tall.*/

		this.mndNavn = mndNavn;

		/* Grunn kopiering */
		//this.nedbør = nedbør;

		/* Dyp kopiering */
		this.nedbør = new int[finnNedbør.length];
		for(int i=0; i<nedbør.length; i++){
			this.nedbør[i] = nedbør[i];
		}

	}

	public String getMndNavn(){
		return mndNavn;
	}

	public int finnAntDager(){
		return nedbør.length;
	}


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

	/* lager en toString-metode for � kunne skrive ut
	   innhold til objektvariablene p� en enkelt m�te:
	 */
	 public String toString(){
	 	String res = mndNavn + "\n";
	 	for(int i= 0; i<nedbør.length; i++){
	 			res += nedbør[i] + " ";
	 	}
	 	return res;
	}

	// Oppgaver fra l�reboka - gj�r disse:
	/*public int [] finnDgMaks(){
	}
	public int  finnAntDagerMaks(){
	}
	public int finnAntDagerMindre(int grense){
	}
	public int  finnStandardavvik(){
	}
	*/
}

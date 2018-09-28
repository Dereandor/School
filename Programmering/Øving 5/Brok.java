class Brok {
	private int teller;
	private int nevner;

	public Brok(int teller, int nevner) {
		if (nevner == 0) {
			throw new IllegalArgumentException("Nevner kan ikke være 0");
		}
		this.teller = teller;
		this.nevner = nevner;
	}

	public Brok(int teller) {
		this.teller = teller;
		nevner = 1;
	}

	//getmetoder
	public int getTeller() {
		return teller;
	}

	public int getNevner() {
		return nevner;
	}

	//summere en brøk
	public void addBrok(Brok b){
		teller = (teller * b.getNevner()) + (b.getTeller() * nevner);
		nevner = (nevner * b.getNevner());
	}


	//subtrahere en brøk
	public void subBrok(Brok b) {
		teller = (teller * b.getNevner()) - (b.getTeller() * nevner);
		nevner = (nevner * b.getNevner());
	}

	//multiplisere en brøk
	public void multBrok(Brok b) {
		teller = (teller * b.getTeller());
		nevner = (nevner * b.getNevner());
	}

	//dividere en brøk
	public void divBrok(Brok b) {
		teller = (teller * b.getNevner());
		nevner = (nevner * b.getTeller());
	}

	//toString
	public String toString(){
		return teller + "/" + nevner;
	}
}

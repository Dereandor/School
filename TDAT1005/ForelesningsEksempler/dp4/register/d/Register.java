package dp4.register.d;

/**
 * Dette er en ordinær "register-klasse". En klient kan legge inn nye
 * Utstyr-objekter i registeret, og se på de som allerede er registrert.
 * Klienten kan bruke denne klassen til å endre varebeholdningen for et gitt
 * objekt. Bestillingsliste for alle varene kan også lages.
 */

class Register {
	public static final int OK = -1;
	public static final int UGYLDIG_BETEGNELSE = -2;
	public static final int IKKE_NOK_PÅ_LAGER = -3;

	private java.util.ArrayList<Utstyr> registeret = new java.util.ArrayList<Utstyr>();

	public int finnAntallRegistrert() {
		return registeret.size();
	}

	public Utstyr finnUtstyr(int indeks) {
		return (indeks >= 0 && indeks < finnAntallRegistrert()) ? registeret.get(indeks) : null;
	}

	public boolean regNyttUtstyr(String betegnelse, String leverandør, int påLager, int nedreGrense) {
		if (finnUtstyr(betegnelse) < 0) { // finnes ikke fra før
			Utstyr nytt = new Utstyr(betegnelse, leverandør, påLager, nedreGrense);
			registeret.add(nytt);
			return true;
		} else {
			return false;
		}
	}


	private int finnUtstyr(String betegnelse) {
		for (int i = 0; i < finnAntallRegistrert(); i++) {
			String funnetBetegnelse = finnUtstyr(i).getBetegnelse();
			if (funnetBetegnelse.equals(betegnelse)) {
				return i;
			}
		}
		return -1;
	}

	public String lagBestillingsliste() {
		String resultat = "\n\nBestillingsliste:\n";
		for (int i = 0; i < finnAntallRegistrert(); i++) {
			resultat += finnUtstyr(i).getBetegnelse() + ": " + finnUtstyr(i).finnBestKvantum() + "\n";
		}
		return resultat;
	}

	public int endreLagerbeholdning(String betegnelse, int mengde) {
		int indeks = finnUtstyr(betegnelse);
		if (indeks < 0) {
			return UGYLDIG_BETEGNELSE;
		} else {
			if (!finnUtstyr(indeks).endreLagerbeholdning(mengde)) {
				return IKKE_NOK_PÅ_LAGER;
			} else {
				return OK;
			}
		}
	}

	public String toString() {
		String resultat = "Alle data:\n";
		for (int i = 0; i < finnAntallRegistrert(); i++) {
			resultat += "\nNummer: " + i + "\n" + finnUtstyr(i).toString();
		}
		return resultat + "\n";
	}
}
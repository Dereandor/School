package dp10.arv.multiple;

import static lib.Out.*;

interface Pappa extends Bestefar, Bestemor {
	static final int alder = 45;
	
	static void snakk(String melding) {
		out(melding + " ba meg si noe."+" Jeg er "+alder+" gammel. Hilsen fra pappa");

		Bestemor.snakk("Pappa");
		Bestefar.snakk("Pappa");		
	}
}
package dp10.arv.multiple;

import static lib.Out.*;

interface Mamma extends Bestefar, Bestemor {
	static final int alder = 42;
	
	static void snakk(String melding) {
		out(melding + " ba meg si noe."+" Jeg er "+alder+" gammel. Hilsen fra mamma");
		
		Bestemor.snakk("Mamma");
		Bestefar.snakk("Mamma");
	}
}

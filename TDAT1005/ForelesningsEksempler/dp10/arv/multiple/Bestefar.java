package dp10.arv.multiple;

import static lib.Out.*;

interface Bestefar {
	static final int alder = 67;
	
	static void snakk(String melding) {
		out(melding + " ba meg si noe."+" Jeg er "+alder+" gammel. Hilsen fra bestefar");
	}
}

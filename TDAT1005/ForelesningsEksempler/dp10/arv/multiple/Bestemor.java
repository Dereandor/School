package dp10.arv.multiple;

import static lib.Out.*;

interface Bestemor {
	static final int alder = 64;

	static void snakk(String melding) {
		out(melding + " ba meg si noe."+" Jeg er "+alder+" gammel. Hilsen fra bestemor");
	}
}

package dp10.arv.multiple;

import static lib.Out.*;

class Barnebarn implements Mamma,Pappa
{
	static final int alder = 15;

	public void snakk(String melding) {
		out(melding+ " ba meg si noe."+" Jeg er "+alder+" gammel. Hilsen fra barnebarn!");
		
		Mamma.snakk("Barn");
		Pappa.snakk("Barn");
	}
}
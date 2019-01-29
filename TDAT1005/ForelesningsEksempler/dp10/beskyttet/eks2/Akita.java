package dp10.beskyttet.eks2;

import static lib.Out.out;

import dp10.beskyttet.eks1.Hund;

public class Akita extends Hund {
	public Akita(String navn) {
		super(navn);
	}
	
	protected void vifteHalen(String eier) {
        out(eier+": vifter halen min...woff ("+super.getNavn()+")");
    }
}

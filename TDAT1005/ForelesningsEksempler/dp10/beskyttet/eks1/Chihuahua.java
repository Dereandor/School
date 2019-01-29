package dp10.beskyttet.eks1;

import static lib.Out.out;

public class Chihuahua extends Hund {
	public Chihuahua(String navn) {
		super(navn);
	}
	
	protected void vifteHalen(String eier) {
        out(eier+": vifter halen min...woff ("+super.getNavn()+")");
    }
}

package dp12.instance.eks2.pck1;

import static lib.Out.out;

public class Chihuahua extends Hund {
	public Chihuahua(String navn) {
		super(navn);
	}
	
	protected void vifteHalen(String eier) {
        out("Min eier er: "+eier+"... vifter med halen ("+super.getNavn()+")");
    }
}

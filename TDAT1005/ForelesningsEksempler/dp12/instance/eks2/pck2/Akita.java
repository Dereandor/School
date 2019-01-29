package dp12.instance.eks2.pck2;

import static lib.Out.out;

import dp12.instance.eks2.pck1.Hund;


public class Akita extends Hund {
	public Akita(String navn) {
		super(navn);
	}
	
	protected void vifteHalen(String eier) {
        out("Min eier er: "+eier+"... vifter med halen ("+super.getNavn()+")");
    }
}

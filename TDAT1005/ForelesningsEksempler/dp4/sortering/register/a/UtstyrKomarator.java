package dp4.sortering.register.a;

import dp4.register.a_b.Utstyr;

public class UtstyrKomarator implements java.util.Comparator<Utstyr> {

	public final static double TOLERANSE = 0.001;

	public int compare(Utstyr u1, Utstyr u2) {
		int lager1 = u1.getPÂLager();
		int lager2 = u2.getPÂLager();
		if (lager1 == lager2) {
			return 0;
		} else if (lager1 < lager2){
			return -1;
		} else {
			return 1;
		}
	}
}
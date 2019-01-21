package dp8.arv.flerenivå;

import static lib.Out.*;

public class flerenivåKlient {

	public static void main(String[] args) {
		
		Leder l = new Leder("Ola Norman", 1200000, "Adinistrerende Direktør");
		out(l);
		
		Ansatt a = new Leder("Hans Hansen", 1000000, "Dagligleder");
		out(a);
		
		Person p = new Leder("Birgitt Johansen", 105000, "Kabinettsekretær");
		out(p);

	}

}

package dp8.arv.flereniv�;

import static lib.Out.*;

public class flereniv�Klient {

	public static void main(String[] args) {
		
		Leder l = new Leder("Ola Norman", 1200000, "Adinistrerende Direkt�r");
		out(l);
		
		Ansatt a = new Leder("Hans Hansen", 1000000, "Dagligleder");
		out(a);
		
		Person p = new Leder("Birgitt Johansen", 105000, "Kabinettsekret�r");
		out(p);

	}

}

package dp8.arv.enkel;

import static lib.Out.*;

public class AnsattKlient {

	public static void main(String[] args) {
		Ansatt a = new Ansatt("Olan Normann");
		a.setLønn(550000);
		out(a.toString());
		
		
		//Ansatt ER en person, En person kan være en Ansatt
		//NB! Kun attributter og metoder som er definert i Person blir tilgjengelig
		Person p = new Ansatt("Hans Hansen");
		out(p.toString());
		
	}

}

package dp8.arv.hierarkisk;

import static lib.Out.out;

public class HierarkiskKlient {

	public static void main(String[] args) {
		
		Ansatt a = new Ansatt("Olan Normann",550000);
		
		Pasient p = new Pasient("Hans Hansen","Anette Olsen");

		Pårørende r = new Pårørende("Margott Sandberg","Tante",p);
		
		out("\nUtskrift 1:");
		out(a);
		out(p);
		out(r);
		
		Person[] personer = {a,p,r};
				
		out("\nUtskrift 2:");
		out(personer);
		
		
		out("\nUtskrift 3:");
		for (Person per:personer) {
			out(per.toString()+", "+per.getRolle());
		}		
	}
}

package dp10.abstrakt.figur;

import static lib.Out.*;

public class FigurKlient {

	public static void main(String[] args) {
		Figur[] figurer = { new Kvadrat(5.2, 3.5), 
							new Sirkel(2.1), 
							new Trekant(5, 1.3) 
						  };

		out("\nUtskrift 1");
		out(figurer);
		
		out("\nUtskrift 2");
		for (Figur figur:figurer) {
			out("Areal av "+figur.getClass().getSimpleName() + " er "+String.format("%.2f",figur.beregnAreal()));			
		}
	}
}

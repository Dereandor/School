package dp8.arv.grensenitt.bryter;

import static lib.Out.*;

public class BryterKlient {

	public static void main(String[] args) {
		
		Bryter[] brytere = {new Lysp�re(60),new Motor(105)};
		
		out("\nSl�r av alt: "); 
		for (Bryter bryter:brytere) {
			bryter.av();
		}

		out("\nSl�r p� alt: "); 
		for (Bryter bryter:brytere) {
			bryter.p�();
		}		
	}
}

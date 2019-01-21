package dp8.arv.grensenitt.bryter;

import static lib.Out.*;

public class BryterKlient {

	public static void main(String[] args) {
		
		Bryter[] brytere = {new Lyspære(60),new Motor(105)};
		
		out("\nSlår av alt: "); 
		for (Bryter bryter:brytere) {
			bryter.av();
		}

		out("\nSlår på alt: "); 
		for (Bryter bryter:brytere) {
			bryter.på();
		}		
	}
}

package dp12.finaleksempel.figur;

import static lib.Out.*;

public class FigurKlient {

	public static void main(String[] args) {
				
		
		Figur[] figurer = { new NTNUKvadrat(5.2, 3.5), 
							new NTNUKvadrat(1.2, 4.5), 
							new NTNUKvadrat(2.2, 6.5) 
						  };

		out("\nUtskrift 1");
		out(figurer);
		
	}
}

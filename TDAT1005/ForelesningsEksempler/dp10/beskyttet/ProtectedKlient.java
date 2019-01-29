package dp10.beskyttet;

import dp10.beskyttet.eks1.Chihuahua;
import dp10.beskyttet.eks1.ChihuahuaEier;
import dp10.beskyttet.eks2.Akita;
import dp10.beskyttet.eks2.AkitaEier;

import static lib.Out.*;

public class ProtectedKlient {

	public static void main(String[] args) {

		Chihuahua bella = new Chihuahua("Bella");
		Akita lucy = new Akita("Lucy");
		
		ChihuahuaEier martin = new ChihuahuaEier("Martin", bella);
		AkitaEier kristin = new AkitaEier("Kristin", lucy);

		out("\nUtskrift 1:");
		martin.lekMedHund(bella);		
		kristin.lekMedHund(lucy);
		
		out("\nUtskrift 2:");
		martin.lekMedHund(lucy);		
		kristin.lekMedHund(lucy);

		out("\nUtskrift 3:");
		martin.lekMedHund(lucy);		
		kristin.lekMedHund(bella);
		
	}
}

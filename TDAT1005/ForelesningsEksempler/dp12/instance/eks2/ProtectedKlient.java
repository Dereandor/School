package dp12.instance.eks2;

import static lib.Out.out;

import java.util.ArrayList;

import dp12.instance.eks2.pck1.Chihuahua;
import dp12.instance.eks2.pck1.ChihuahuaEier;
import dp12.instance.eks2.pck1.Person;
import dp12.instance.eks2.pck2.Akita;
import dp12.instance.eks2.pck2.AkitaEier;


public class ProtectedKlient {

	public static void main(String[] args) {

		Chihuahua bella = new Chihuahua("Bella");
		Chihuahua molly = new Chihuahua("Molly");		
		Akita lucy = new Akita("Lucy");

		ChihuahuaEier martin = new ChihuahuaEier("Martin", bella);
		ChihuahuaEier hans = new ChihuahuaEier("Hans", molly);
		AkitaEier kristin = new AkitaEier("Kristin", lucy);

		ArrayList<IEier> hundeEiere = new ArrayList<IEier>();
		hundeEiere.add(martin);
		hundeEiere.add(kristin);
		hundeEiere.add(hans);

		ArrayList<Person> personer = new ArrayList<Person>();
		personer.add(martin);
		personer.add(kristin);
		personer.add(hans);

		out("\nUtskrift 1:");
		for (IEier hundeEier : hundeEiere) {
			hundeEier.lekMedHund(bella);
			hundeEier.lekMedHund(molly);
			hundeEier.lekMedHund(lucy);
		}

		out("\nUtskrift 2: ");
		for (Person person : personer) {
			out(person.getNavn());
		}
	}
}

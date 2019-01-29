package dp10.beskyttet.eks2;

import static lib.Out.out;

import dp10.beskyttet.IEier;
import dp10.beskyttet.eks1.Person;

public class AkitaEier extends Person implements IEier{
	Akita akita = null; 
	public AkitaEier(String personNavn,Object object) {
		super(personNavn);
		akita = (Akita)object;  
	}

	@Override
	public void lekMedHund(Object object) {
		if (object instanceof Akita) {
			akita.vifteHalen(super.getNavn());
		} else {
			out(super.getNavn()+", du er ikke min eier.. krkrkrk...");
		}
	}
}

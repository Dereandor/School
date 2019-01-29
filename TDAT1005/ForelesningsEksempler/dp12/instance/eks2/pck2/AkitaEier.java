package dp12.instance.eks2.pck2;

import static lib.Out.out;

import dp12.instance.eks2.IEier;
import dp12.instance.eks2.pck1.Person;

public class AkitaEier extends Person implements IEier {
	Akita akita = null;

	public AkitaEier(String personNavn, Object object) {
		super(personNavn);
		akita = (Akita) object;
	}

	@Override
	public void lekMedHund(Object object) {
		boolean eier = false;
		if (object instanceof Akita) {
			Akita hund = (Akita) object;
			if (hund.getNavn().equals(this.akita.getNavn())) {
				akita.vifteHalen(super.getNavn());
				eier = true;
			}
		}

		if (!eier) {
			out(super.getNavn() + ", du er ikke min eier.. krkrkrk...("+this.akita.getNavn()+")");
		}
	}
}

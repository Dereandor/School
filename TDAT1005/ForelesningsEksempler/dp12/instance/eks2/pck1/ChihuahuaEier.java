package dp12.instance.eks2.pck1;

import static lib.Out.out;

import dp12.instance.eks2.IEier;

public class ChihuahuaEier extends Person implements IEier {
	Chihuahua chihuahua = null;

	public ChihuahuaEier(String personNavn, Object object) {
		super(personNavn);
		chihuahua = (Chihuahua) object;
	}

	@Override
	public void lekMedHund(Object object) {
		boolean eier = false;
		if (object instanceof Chihuahua) {
			Chihuahua hund = (Chihuahua) object;
			if (hund.getNavn().equals(this.chihuahua.getNavn())) {
				chihuahua.vifteHalen(super.getNavn());
				eier = true;
			}
		}

		if (!eier) {
			out(super.getNavn() + ", du er ikke min eier.. krkrkrk...("+this.chihuahua.getNavn()+")");
		}
	}
}

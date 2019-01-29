package dp10.beskyttet.eks1;

import static lib.Out.*;

import dp10.beskyttet.IEier;

public class ChihuahuaEier extends Person implements IEier {
	Chihuahua chihuahua = null; 
	public ChihuahuaEier(String personNavn,Object object) {
		super(personNavn);
		chihuahua = (Chihuahua)object; 
	}
	
	@Override
	public void lekMedHund(Object object) {
		if (object instanceof Chihuahua) {
			chihuahua.vifteHalen(super.getNavn());
		} else {
			out(super.getNavn()+", du er ikke min eier.. krkrkrk...");
		}
	}
}

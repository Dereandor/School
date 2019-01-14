package dp4.sortering.register.b;

public class UtstyrKomarator implements java.util.Comparator<Utstyr> {

	@Override
	public int compare(Utstyr o1, Utstyr o2) {
		java.text.Collator koll = java.text.Collator.getInstance();
		return koll.compare(o1.getBetegnelse(), o2.getBetegnelse());
	}
}
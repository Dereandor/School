package dp4.sortering.flate;

/**
 * FlateKompAreal.java - "Programmering i Java", 4.utgave - 2009-07-01
 *
 * Komparator for klassen Flate der arealet sammenlignes.
 */

class FlateKompOmkrets implements java.util.Comparator<Flate> {
	public final static double TOLERANSE = 0.001;

	@Override
	public int compare(Flate flate1, Flate flate2) {
		double omk1 = flate1.beregnOmkrets();
		double omk2 = flate2.beregnOmkrets();
		if (Math.abs(omk1 - omk2) < TOLERANSE) {
			return 0;
		} else if (omk1 < omk2) {
			return -1;
		} else {
			return 1;
		}
	}
}
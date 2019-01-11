package dp3.utvidet_forloekke;

public class Ansatt extends Person {
	private int lønnstrinn;

	public Ansatt(long fnr, String navn, String adresse, int lønnstrinn) {
		super(fnr, navn, adresse);
		this.lønnstrinn = lønnstrinn;
	}

	/**
	 * @return the lønnstrinn
	 */
	public int getLønnstrinn() {
		return lønnstrinn;
	}

	/**
	 * @param lønnstrinn the lønnstrinn to set
	 */
	public void setLønnstrinn(int lønnstrinn) {
		this.lønnstrinn = lønnstrinn;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ansatt [lønnstrinn=" + lønnstrinn + ", "+super.toString()+"]";
	}
}

package dp3.utvidet_forloekke;

public class Student extends Person {

	private final long studnr;

	public Student(long fnr, String navn, String adresse, long studnr) {
		super(fnr, navn, adresse);
		this.studnr = studnr;
	}

	public long getStudnr() {
		return studnr;
	}

	@Override
	public String toString() {
		return "Student [studnr=" + studnr +", "+ super.toString()+ "]";
	}

}

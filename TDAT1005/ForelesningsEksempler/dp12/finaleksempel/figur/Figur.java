package dp12.finaleksempel.figur;

public abstract class Figur {
	public final String version = "Draft 0.1";
	public abstract double beregnAreal();
	
	@Override
	public String toString() {
		return "Figur [version=" + version + "]";
	}	
}


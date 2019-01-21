package dp8.arv.grensenitt.bryter;

import static lib.Out.*;

public class Lyspære implements Bryter {
	private final double styrke;
	
	public Lyspære(double styrke) {
		this.styrke = styrke;
	}
	
	@Override
	public void av() {
		out("Lyset er av");
	}

	@Override
	public void på() {
		out("Lyset er på");
	}

	public double getStyrke() {
		return styrke;
	}
}

package dp8.arv.grensenitt.bryter;

import static lib.Out.*;

public class Lysp�re implements Bryter {
	private final double styrke;
	
	public Lysp�re(double styrke) {
		this.styrke = styrke;
	}
	
	@Override
	public void av() {
		out("Lyset er av");
	}

	@Override
	public void p�() {
		out("Lyset er p�");
	}

	public double getStyrke() {
		return styrke;
	}
}

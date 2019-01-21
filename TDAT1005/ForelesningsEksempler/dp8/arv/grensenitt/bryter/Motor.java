package dp8.arv.grensenitt.bryter;

import static lib.Out.*;

public class Motor implements Bryter {

	private final double styrke;
	
	public Motor(double styrke) {
		this.styrke = styrke;
	}
	
	@Override
	public void av() {
		out("Motor er av");
	}

	@Override
	public void p�() {
		out("Motor er p�");
	}

	public double getStyrke() {
		return styrke;
	}

}

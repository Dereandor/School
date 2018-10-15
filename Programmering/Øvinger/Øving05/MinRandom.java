import java.util.Random;

public class MinRandom {

	java.util.Random random = new java.util.Random();

	public MinRandom(){
		
	}

	public int nesteHeltall(int nedre, int ovre) {
		int randomInt = random.nextInt(ovre - nedre);
		randomInt += nedre;
		return randomInt;
	}

	public double nesteDesimaltall(double nedre, double ovre) {
		double randomDouble = random.nextDouble();
		randomDouble *= (ovre - nedre);
		randomDouble += nedre;
		return randomDouble;
	}

	public String toString() {
		return "toString";
	}


}



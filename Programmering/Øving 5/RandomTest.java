class RandomTest {
	public static void main(String[]args) {
		MinRandom randomInt = new MinRandom();

		int randomI = randomInt.nesteHeltall(10, 20);

		System.out.println("heltall: " + randomI);

		MinRandom randomDouble = new MinRandom();

		double randomD = randomDouble.nesteDesimaltall(-200.0, -50.0);

		System.out.println("desimaltall: " + randomD);

	}
}
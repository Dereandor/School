package dp1.unntak;

public class Zero {

	public static void main(String[] args) {
		int teller = 10;
		int nevner = 0;
		try {
			System.out.println (teller / nevner);
		} catch (ArithmeticException e) {
			System.out.println ("Deling med null ikke tillatt!");
		}
	}
}


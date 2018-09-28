import java.util.Scanner;

public class FractionAdder
{
	public static void main(String[] args)
	{
		Scanner key = new Scanner(System.in);
		Fraction a, b, c;

		System.out.println("Enter numerator; then denominator.");
		a = new Fraction(key.nextInt(),key.nextInt());
		a.print();

		System.out.println("Enter numerator; then denominator.");
	    b = new Fraction(key.nextInt(),key.nextInt());
		b.print();


		System.out.println("Sum:");
		c = c.add(a).add(b);
		c.print();
 		//c.printAsDouble();
	}
}

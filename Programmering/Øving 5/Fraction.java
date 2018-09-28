public class Fraction
{
	  private int numerator;
	  private int denominator;
	  private double quotient;

	  public Fraction(int n, int d)
	  {
		  this.numerator = n;
		  this.denominator = d;
	  }// end Fraction

	  public void add(Fraction a, Fraction b);
	  {
		  denominator = a.denominator * b.denominator;
		  numerator = (a.numerator * b.denominator) + (b.numerator * a.denominator);
	  }


	  public void print()
	  {
		  System.out.println(
			  this.numerator + "/" +
			  this.denominator);
	  }// end print
}// end Fraction class

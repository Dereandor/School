/*
* Side 120
* Oppgave 2
*
*
*/

class Oppgave2_120 {
	
	public static void main(String[]args) {
		
		int a = 10;
		int b = 20;
		int c = b % a;
		
		a++;
		b++;
		c += a;
		a *= c;
		b--;
		c /= 2;
		c %= 2;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
	}
}
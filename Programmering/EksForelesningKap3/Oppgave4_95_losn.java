/* Oppgave4_95.java

Skriv følgende kodebit i henhold til anbefalinger for innrykk og {}.
Finn verdiene til alle variablene etter at kodebiten er utført

*/

class Oppgave4_95_losn{
	public static void main(String[] args){
  		int a = 20;
		int b = 30;
		int p = 20;
		int q = 40;
		int r = 30;
		int s = 15;

		if(a<b){
			a = b;
		}
		b = 10;

		if(p==20){
			q = 13;
		}else{
			q = 17;
		}

		if(r>s){
			q = 100;
		}

		s = 200;

		System.out.println("a:20: " + a);
		System.out.println("b:30: " + b);
		System.out.println("p:20: " + p);
		System.out.println("q:40: " + q);
		System.out.println("r:30: " + r);
		System.out.println("s:15: " + s);

	}
}

/* Kjøring

a:20: 30
b:30: 10
p:20: 20
q:40: 100
r:30: 30
s:15: 200
*/
package dp12.instance.eks1;

public class InstanceofEksempler {

	public static void main(String[] args) {
		A c = new C();
		A d = new D();
		A e = new E();
		A f = new F();
		
		c.metode1();
		d.metode1();
		e.metode1();
		f.metode1();		
		
		if (e instanceof B) {
			B etObject = (B)e;
			etObject.metode2();
		}
		
		if (f instanceof B) {
			B etObject = (B)f;
			etObject.metode2();
		}
	}
}

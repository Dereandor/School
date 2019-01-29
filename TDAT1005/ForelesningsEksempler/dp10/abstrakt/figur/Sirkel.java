package dp10.abstrakt.figur;

public class Sirkel extends Figur {
	private final double radius;
	
	public Sirkel(double r) {
		this.radius = r;
	}
	public double getRadius() {
		return radius;
	}

	@Override
	public double beregnAreal() {
		return Math.PI*Math.sqrt(radius);
	}
	
	@Override
	public String toString() {
		return "Sirkel [radius=" + radius + ", areal="+String.format("%.2f",beregnAreal())+"]";
	}	
}

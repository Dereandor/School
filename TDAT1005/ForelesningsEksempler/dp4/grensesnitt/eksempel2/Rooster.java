package dp4.grensesnitt.eksempel2;

import static lib.Out.out;

public class Rooster implements Animal, Comparable<Object> {

	public void eat() {
		out("Rooster eats");
	}

	public void travel() {
		out("Rooster travels");
	}

	public int noOfLegs() {
		return 2;
	}

	@Override
	public int compareTo(Object o) {
		if (this.noOfLegs() == ((Animal) o).noOfLegs()) {
			return 1;
		} else {
			return -1;
		}
	}
}
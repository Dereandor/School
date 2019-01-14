package dp4.grensesnitt.eksempel2;

import static lib.Out.out;

public class Dog implements Animal, Comparable<Object> {

	public void eat() {
		out("Dog eats");
	}

	public void travel() {
		out("Dog travels");
	}

	public int noOfLegs() {
		return 4;
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
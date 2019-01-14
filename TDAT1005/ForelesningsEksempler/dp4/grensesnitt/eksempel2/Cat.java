package dp4.grensesnitt.eksempel2;

import static lib.Out.out;

public class Cat implements Animal, Comparable<Object> {

	public void eat() {
		out("Cat eats");
	}

	public void travel() {
		out("Cat travels");
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


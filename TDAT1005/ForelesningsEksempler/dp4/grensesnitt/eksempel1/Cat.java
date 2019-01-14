package dp4.grensesnitt.eksempel1;

import static lib.Out.out;

public class Cat implements Animal {

	public void eat() {
		out("Cat eats");
	}

	public void travel() {
		out("Cat travels");
	}

	public int noOfLegs() {
		return 4;
	}
}


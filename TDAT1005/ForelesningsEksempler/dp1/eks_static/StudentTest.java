package dp1.eks_static;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StudentTest {

	Student tester = new Student("Student navn", "01.01.2005"); // Student is tested

	@Test
	void test1() {

		// assert statements
		assertEquals(1, tester.finnAntStud(), "");

	}

	@Test
	void test2() {

		assertEquals("NTNU", tester.SKOLE, "");
	}
	
}

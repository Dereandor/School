package V2019.Test;

public class ReferanseTest {
	private Person testObj;

	public ReferanseTest() {
		testObj = new Person(1, "Per Person");
	}

	public Person getPerson() {
		return testObj;
	}

	class Person {
		String lokalNavn;
		Integer lokalId;

		Person(int id, String navn) {
			lokalId = id;
			lokalNavn = navn;
		}

		public void setNavn(String str) {
			lokalNavn = str;
		}

		public void setId(Integer id) {
			lokalId = id;
		}

		public String getNavn() {
			return lokalNavn;
		}

		public Integer getId() {
			return lokalId;
		}

		public String toString() {
			return lokalId + " " + lokalNavn;
		}
	}// end Person

	public static void main(String[] args) {
		ReferanseTest refTest = new ReferanseTest();
		Person testPerson = refTest.getPerson();

		System.out.println(testPerson);

		Integer id = testPerson.getId();
		String navn = testPerson.getNavn();

		id = 0;
		navn = "Bør Børson";

		testPerson = refTest.getPerson();

		System.out.println(testPerson);

		testPerson.setId(11);
		testPerson.setNavn("Charlie Chaplin");

		testPerson = refTest.getPerson();

		System.out.println(testPerson);

	}// end main
}

package dp3.utvidet_forloekke;

import static lib.Out.out;

import java.util.ArrayList;

public class PersonKlient {

	public static void main(String[] args) {
		Student student = new Student(121060788756L,"Ole Bø","Storgt 3, 2345 Os", 1234567L); 
		Ansatt ansatt = new Ansatt(31126522323L,"Hanne Hansen", "Lia, 3456 Mo",40);
		
		out("Enkelt object:");
		out(student.toString());
		out(ansatt.toString());
		
		
		out("\nPersoner i ArrayList (Polymorfi)");
		ArrayList<Person> personer = new ArrayList<Person>();
		personer.add(student);
		personer.add(ansatt);
		
		for(Person person:personer) {
			out(person.toString());
		}

	
		out("\nObjekter i ArrayList (Polymorfi)");
		ArrayList<Object> objekter = new ArrayList<Object>();
		objekter.add(student);
		objekter.add(ansatt);
		
		for(Object objekt:objekter) {
			out(objekt.toString());
		}
	}
}

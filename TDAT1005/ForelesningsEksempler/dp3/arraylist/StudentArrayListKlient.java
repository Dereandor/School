package dp3.arraylist;

import static lib.Out.out;

import java.util.ArrayList;

import dp3.Student;

public class StudentArrayListKlient {

	public static void main(String[] args) {

		ArrayList<Student> studenter = new ArrayList<Student>();

		Student student1 = new Student("Ole Petter", "Hansen", 19801212);
		Student student2 = new Student("Ingrid", "Olsen", 197512101);
		Student student3 = new Student("Åse Marie", "Jensen", 19730506);

		studenter.add(student1);
		studenter.add(student2);
		studenter.add(student3);

		out("\nTest 1:");
		Object s = studenter.get(0);		
		out(s);
		
		out("\nTest 2:");
		ArrayList<Object> o = new ArrayList<Object>(studenter);
		out(o);
		
		out("\nTest 3:");
		o.remove(2);
		out(o);

		out("\nTest 4:");
		o = new ArrayList<Object>(studenter);
		out(o);
		
		out("\nTest 5:");
		studenter.remove(student1);
		o = new ArrayList<Object>(studenter);
		out(o);
		
	}
}


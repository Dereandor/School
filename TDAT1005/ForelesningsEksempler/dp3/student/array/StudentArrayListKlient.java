package dp3.student.array;

import static lib.Out.out;

import java.util.ArrayList;

public class StudentArrayListKlient {

	public static void main(String[] args) {
		ArrayList<Student> studenter = new ArrayList<Student>();
		Student enStudent = new Student("Ole Petter", "Hansen", 19801212);
		Student enStudentTil = new Student("Ingrid", "Olsen", 197512101);
		Student endaEnStudentTil = new Student("Åse Marie", "Jensen", 19730506);
		studenter.add(enStudent);
		studenter.add(enStudentTil);
		studenter.add(endaEnStudentTil);
		
		ArrayList<Object> o = new ArrayList(studenter);		
		out(o);
	}

}


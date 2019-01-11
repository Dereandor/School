/*
*   lag en klasse oppgaveoversikt som holder orden på hvor mange oppgaver hver enkelt student har fått godkjent
*   skal ha to objektvariabler:
*   private Student[] studenter (tabellen opprettes i konstruktøren)
*   private int antStud = 0 (økes med 1 for hver ny student)
*   metoder for følgende operasjoner:
*   Finn antall studenter registrert, finn antall oppgaver som en bestemt student har løst, registrer en ny student, øk antall oppgaver for en bestemt student.
*   i tilleg skal det lages en toString() metode, og eventuelt andre metoder som trengs.
*   lag et enkelt klientprogram.
*/

import java.util.Arrays;

public class Oppgaveoversikt {

    private Student[] students; //tabellen opprettes i konstruktøren
    private int numStud = 0; //økes med 1 for hver ny student
    private int studentNum;
    private String studentName;

    public Oppgaveoversikt() {
        Student[] students = new Student[10];
    }

    public int getStudents() {
        return numStud;
    }

    public int getStudentDone(int studentNum) {
        return students[studentNum].getTasks();
    }

    public String getStudent(int studnum) {
        return students[studnum].toString();
    }

    public void newStudent(String name) {
        try {
            students[numStud] = new Student(name, numStud);
            numStud++;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("name is null", e);

        }
    }

    public void increaseTasks(int student, int increase) {
        students[student].incTasks(increase);
    }

    public void doneTask(int studentNum) {
        students[studentNum].getTasks();
    }

    public void extendArray() {
        Student[] newArray = new Student[students.length + 2];
        for (int i = 0; i < students.length; i++) {
            newArray[i] = students[i];
        }
        students = newArray;
    }
}

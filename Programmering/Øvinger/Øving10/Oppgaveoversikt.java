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

class Oppgaveoversikt {

    private Student[] students; //tabellen opprettes i konstruktøren
    private int numStud = 0; //økes med 1 for hver ny student

    public Oppgaveoversikt(String navn, int number) {
        students = new Student[30];
    }

    public int getStudents() {
        return numStud;
    }

    public int getStudentDone(int studentNumber) {
        return student.getTasks();
    }

    public void newStudent(String name) {

    }

    public void doneTask() {
        student.incTasks();
    }
}

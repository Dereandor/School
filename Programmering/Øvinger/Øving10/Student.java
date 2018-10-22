/*
*   skal ha 2 objektvariabler:
*   private string navn (entydig!) og private int antOppg
*   antoppg skal holde orden på hvor mange av oppgavene studenten har levert som er godkjent
*   klassen skal tilby følgende operasjoner:
*   getNavn(), getAntOppg(), økAntOppg(int økning) og toString()
*   Lag et testprogram for klassen.
*/

class Student {

    private String name;
    private int tasks;

    public Student(String name) {

    }

    public String getName() {
        return name;
    }

    public int getTasks() {
        return tasks;
    }

    public void incTasks(int tasks) {
        tasks++;
    }

    public String toString() {
        return name + tasks;
    }
}

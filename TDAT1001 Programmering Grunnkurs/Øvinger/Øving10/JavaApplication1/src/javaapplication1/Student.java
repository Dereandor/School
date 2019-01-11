/*
*   skal ha 2 objektvariabler:
*   private string navn (entydig!) og private int antOppg
*   antoppg skal holde orden på hvor mange av oppgavene studenten har levert som er godkjent
*   klassen skal tilby følgende operasjoner:
*   getNavn(), getAntOppg(), økAntOppg(int økning) og toString()
*   Lag et testprogram for klassen.
*/

class Student {

    private String name; //entydig
    private int tasks;
    private int studNum;

    public Student(String name, int studNum) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Navn må oppgis.");
        }
        this.name = name;
        this.studNum = studNum;
        tasks = 0;

    }

    public String getName() {
        return name;
    }

    public int getTasks() {
        return tasks;
    }

    public void incTasks(int increase) {
        if (increase <= 0) {
            throw new IllegalArgumentException("Økning må være positiv");
        }
        tasks += increase;
    }

    public String toString() {
        return "Navn: " + name + "Student nummer: " + studNum + "\n Utførte oppgaver: " + tasks;
    }
}

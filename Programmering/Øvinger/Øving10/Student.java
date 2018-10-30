/*
*   skal ha 2 objektvariabler:
*   private string navn (entydig!) og private int antOppg
*   antoppg skal holde orden p√• hvor mange av oppgavene studenten har levert som er godkjent
*   klassen skal tilby f√∏lgende operasjoner:
*   getNavn(), getAntOppg(), √∏kAntOppg(int √∏kning) og toString()
*   Lag et testprogram for klassen.
*/

class Student {

    private String name; //entydig
    private int tasks;
    private int studNum;

    public Student(String name, int studNum) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Navn mÂ oppgis.");
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
            throw new IllegalArgumentException("ÿkning mÂ vÊre positiv");
        }
        tasks += increase;
    }

    public String toString() {
        return "Navn: " + name + "\n Student nummer: " + studNum + "\n Utf¯rte oppgaver: " + tasks + "\n";
    }
}

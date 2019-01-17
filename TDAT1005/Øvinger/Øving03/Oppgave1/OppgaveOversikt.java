public class OppgaveOversikt {

    private Student[] studenter;
    private int antStud = 0;

    public OppgaveOversikt() {
        studenter = new Student[5];
        antStud = 0;
    }

    public boolean regNyStudent(String name) {
        if(antStud == studenter.length) {
            utvid();
        }
        studenter[antStud] = new Student(name);
        return true;
    }

    public int finnAntStud() {
        return antStud;
    }

    public int finnAntOppgaver(String name) {
        Student s = null;
        int tot = 0;
        for (int i = 0; i < studenter.length; i++) {
            if (!(studenter[i] == null) && studenter[i].getNavn().toLowerCase().equals(name.toLowerCase())) {
                s = studenter[i];
                tot = s.getAntOppg();
            }
        }
        return tot;
    }

    public void okAntOppg(String name, int increase) {
        Student s = null;
        for (int i = 0; i < studenter.length; i++) {
            if (!(studenter[i] == null) && studenter[i].getNavn().toLowerCase().equals(name.toLowerCase())) {
                s = studenter[i];
            }
        }
        s.setAntOppg(increase);
    }

    public String[] finnAlleNavn() {
        String[] navn = new String[studenter.length];
        for(int i = 0; i< navn.length; i++) {
            if (!(studenter[i] == null)) {
                navn[i] = studenter[i].getNavn();
            }
        }
        return navn;
    }

    public String toString() {
        String list = null;
        for (int i = 0; i < studenter.length; i++) {
            if(!(studenter[i] == null)) {
                list += "\n" + studenter[i].toString();
            }
        }
        return list;
    }

    public void utvid() {
        Student[] nyTab = new Student[studenter.length + 5];
        for (int i = 0; i < antStud; i++) {
            nyTab[i] = studenter[i];
        }
        studenter = nyTab;
    }
}

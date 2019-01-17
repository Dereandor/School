import java.util.*;

public class OppgaveOversikt2 {

    private int antStud = 0;
    private ArrayList<Student> studenter = new ArrayList<Student>();

    public int finnAntStud() {
        return studenter.size();
    }

    public boolean regNyStudent(String name) {
        if (!(name.equals(null))) {
            studenter.add(new Student(name));
            return true;
        } else {
            return false;
        }
    }

    public int finnAntOppgaver(String name) {
        for(Student student : studenter) {
            if(student.getNavn().equals(name)) {
                return student.getAntOppg();
            }
        }
        return -1;
    }

    public void okAntOppg(String name, int increase) {
        for(Student student : studenter) {
            if (student.getNavn().equals(name)) {
                student.setAntOppg(increase);
            }
        }
    }

    public String[] finnAlleNavn() {
        String[] names = new String[studenter.size()];
        int help = 0;
        for (Student student : studenter) {
            names[help] = student.getNavn();
            help++;
        }
        return names;
    }

    public String toString() {
        String list = "\n";
        for (Student student : studenter) {
            list += student.toString() + "\n";
        }
        return list;
    }
}

public class Student {
    private final String name;
    private int numTasks;
    
    public Student(String name) {
        this.name = name;
        numTasks = 0;
    }
    
    public String getNavn() {
        return name;
    }
    
    public int getAntOppg() {
        return numTasks;
    }
    
    public void setAntOppg(int antOppg) {
        numTasks += antOppg;
    }
    
    public String toString() {
        return name + " " + numTasks;
    }
}

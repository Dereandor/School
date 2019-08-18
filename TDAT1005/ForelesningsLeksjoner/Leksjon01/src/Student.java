import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Student {
    public static final String VALID_GRA = "ABCDEF";
    
    private final String name;
    private final String birthday;
    private char[] grades = new char[3];
    private int number;
    
    public Student(String name, String birthday){
        this.name = name;
        this.birthday = birthday;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMyyyy");
        Period periode = Period.between(LocalDate.parse(birthday, format), LocalDate.now());
        return periode.getYears();
    }

    public boolean regNewGrade(char grade) {
        if(VALID_GRA.indexOf(grade) >= 0) {
            if(number == grades.length) {
                expandArray();
            }
            grades[number] = grade;
            number++;
            return true;

        }
        return false;
    }

    private void expandArray() {
        char[] newgrades = new char[grades.length + 2];
        for (int i = 0; i < grades.length; i++) {
            newgrades[i] = grades[i];
        }
        grades = newgrades;
    }
}

class TestStudent {
    public static void main(String[] args) {
        Student studenten = new Student("Ole Andreas Thomassen", "10101980");
        System.out.println("Studenten heter " + studenten.getName() + " og er "
                + studenten.getAge() + " år gammel.");
    }
}

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
}

class TestStudent {
    public static void main(String[] args) {
        Student studenten = new Student("Ole Andreas Thomassen", "10101980");
        System.out.println("Studenten heter " + studenten.getName() + " og er "
                + studenten.getAge() + " år gammel.");
    }
}

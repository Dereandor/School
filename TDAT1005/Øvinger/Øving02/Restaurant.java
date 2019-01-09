import static java.util.*;

class Restaurant {

    private String name;
    private int estYear;
    private int tables;
    private Bord[] restaurant;

    Date date = new Date();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    int curYear = calendar.get(Calendar.YEAR);

    public Restaurant(String name, int estYear) {
        this.name = name;
        this.estYear = estYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getYear() {
        return estYear;
    }

    public int getAge() {
        int age = curYear - estYear;
        return age;
    }

    public int getAvailable() {
        int available = ;
        return available;
    }

    public int getBusy() {
        return
    }
}

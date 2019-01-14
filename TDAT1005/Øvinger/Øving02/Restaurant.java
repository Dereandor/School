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

    public Restaurant(String name, int estYear, int tables) {
        this.name = name;
        this.estYear = estYear;
        Bord[] bord = new Bord[tables];
    }
    //get name of restaurant
    public String getName() {
        return name;
    }
    //change name of restaurant
    public void setName(String newName) {
        name = newName;
    }
    //get year of establishment
    public int getYear() {
        return estYear;
    }
    // get age of restaurant
    public int getAge() {
        int age = curYear - estYear;
        return age;
    }
    //find how many available tables in restaurant
    public int getAvailable() {
        int available = bord.getAvailable();
        return available;
    }
    //find how many busy tables in restaurant
    public int getBusy() {
        int busy = bord.getBusy();
        return busy;
    }
    //reserve a number of tables on name
    public boolean reserveTables() {
        if ()
    }
    //find which tables a name has reserved, returned as int[]


    //release cleaned tables, int[] argument
}

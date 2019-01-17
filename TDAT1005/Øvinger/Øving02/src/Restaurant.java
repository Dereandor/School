import java.util.*;

public class Restaurant {
    
    private String name;
    private int estYear;
    private int tables;
    private int available;
    private Bord bord;
    
    Date date = new Date();
    Calendar calendar = Calendar.getInstance();
    //calendar.setTime(Date date);
    int curYear = calendar.get(Calendar.YEAR);
    
    public Restaurant(String name, int estYear, int tables) {
        this.name = name;
        this.estYear = estYear;
        bord = new Bord(tables);
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
    public int getFree() {
        available = bord.getAvailable();
        
        return available;
    }
    //find how many busy tables in restaurant
    public int getTaken() {
        int busy = bord.getBusy();
        
        return busy;
    }
    //reserve a number of tables on name
    public boolean reserveTable(String name, int tables) {
        boolean status = bord.reserveTables(name, tables);
        
        return status;
    }
    //find which tables a name has reserved, returned as int[]
    public int[] reservedName(String name) {
        int[] tables = bord.reservedName(name);
        
        return tables;
    }
    
    
    //release cleaned tables, int[] argument
    public boolean releaseTables(int[] cleaned) {
        if(cleaned == null) {
            return false;
        }
        boolean status = bord.releaseCleaned(cleaned);
        return status;
    }
    
    public static void main(String[]args) {
    
    }
}

public class Bord {
    
    private int available;
    private int busy;
    private int total;
    private int help;
    private boolean status;
    private String[] tables;
    
    public Bord(int total) {
        tables = new String[total];
        
    }
    
    public int getAvailable() {
        available = 0;
        for(int i = 0; i<tables.length; i++) {
            if (tables[i] == null) {
                available++;
            }
        }
        return available;
    }
    
    public int getBusy() {
        busy = 0;
        for(int i = 0; i<tables.length; i++) {
            if (!(tables[i] == null)) {
                busy++;
            }
        }
        return busy;
    }
    
    //Release cleaned tables
    public boolean releaseCleaned(int[] clean) {
        for(int i = 0; i< clean.length; i++) {
            tables[clean[i]] = null;
        }
        return true;
    }
    
    //Reserve tables
    public boolean reserveTables(String name, int size) {
        int added = 0;
        if (name == null || size == 0) {
            return false;
        }
        for (int i = 0; i < tables.length; i++) {
            
            if (tables[i] == null && added < size) {
                tables[i] = name;
                added++;
            }
        }
        return true;
    }
    
    //check reserved tables against name
    public int[] reservedName(String name){
        int[] names = new int[3];
        help = 0;
        for (int i = 0; i<tables.length; i++) {
            if (!(tables[i]==(null)) && tables[i].equals(name)) {
                names[help] = i;
                help++;
            }
        }
        return names;
    }
}

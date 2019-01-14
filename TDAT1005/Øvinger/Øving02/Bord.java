class Bord {

    private int available;
    private int busy;
    private int total;
    private String[] tables;

    public Bord(int total) {
        String[] tables = new String[total];

    }

    public int getAvailable() {
        available = 0;
        for(int i = 0; i<tables.length; i++) {
            if (tables[i].equals(null)) {
                available++;
            }
        }
        return available;
    }

    public int getBusy() {
        busy = 0;
        for(int i = 0; i<tables.length; i++) {
            if (!(tables[i].equals(null))) {
                busy++;
            }
        }
        return busy;
    }

    //Release cleaned tables

    //Reserve tables
    public boolean reserveTables(String name, int size) {
        if (name == null || size = 0) {
            return false;
        }
        for (int i = 0; i < tables.length; i++) {
            if (tables[i] = null)
        }

    }
}

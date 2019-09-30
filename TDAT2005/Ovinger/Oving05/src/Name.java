public class Name {

    private int length = 4;
    //private String[] name = new String[length];
    private String name;

    public Name(String name) {

        this.name = name;
    }

    public int getHashCode() {
        int temp = 0;
        for (int i = 0; i < name.length(); i++) {
            temp+= name.charAt(i) * (i+1);
        }
        return temp;
    }

    public String toString() {
        return name;
    }


}

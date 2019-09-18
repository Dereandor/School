public class Name {

    private int length = 4;
    //private String[] name = new String[length];
    private String name;
    private static int A = 132721885;

    public Name(String name) {
        this.name = name;
    }

/*    //konstruktør for 1 firstname and 1 etternavn
    public Name(String firstname, String etternavn) {
        this.name[0] = firstname;
        this.name[1] = null;
        this.name[2] = null;
        this.name[3] = etternavn;
    }

    //konstruktør for 1 firstname, 1 middlename and 1 etternavn
    public Name(String firstname, String middlename, String etternavn) {
        this.name[0] = firstname;
        this.name[1] = middlename;
        this.name[2] = null;
        this.name[3] = etternavn;
    }

    //konstruktlr for 1 firstname, 2 middlename and 1 etternavn
    public Name(String firstname, String middlename, String middlename2, String etternavn) {
        this.name[0] = firstname;
        this.name[1] = middlename;
        this.name[2] = middlename2;
        this.name[3] = etternavn;
    }*/

    private int h1(int key) {
        return key * A>>(32-7);
    }

    private int hash1() {
        int temp = 0;
        for (int i = 0; i < name.length(); i++) {
            temp+= name.charAt(i) * i;
        }
        return temp;
        /*if(name[1] == null) {
            for (int i = 0; i < name[0].length(); i++) {
                temp += (name[0].charAt(i))*i;
            }
            for (int i = 0; i < name[3].length(); i++) {
                temp += (name[3].charAt(i))*i;
            }
            return h1(temp);
        }
        if (name[1] != null && name[2] == null) {
            return h1(this.name[0].charAt(0))+h1(this.name[1].charAt(0))+h1(this.name[3].charAt(0));
        } else {
            return h1(this.name[0].charAt(0))+h1(this.name[1].charAt(0))+h1(this.name[2].charAt(0))+h1(this.name[3].charAt(0));
        }*/
    }

    public int getHashCode() {
        return hash1();
    }

    public String toString() {
        return name;
    }

   /* public boolean equals(Object o) {
        Name otherName = (Name) o;
        if (this.name[1] == null){
            return (this.name[0].equals(otherName.name[0]) && this.name[3].equals(otherName.name[3]));
        }
        if (this.name[2] == null){
            return (this.name[0].equals(otherName.name[0]) && this.name[1].equals(otherName.name[1]) && this.name[3].equals(otherName.name[3]));
        }
        else{
            return (this.name[0].equals(otherName.name[0]) && this.name[1].equals(otherName.name[1]) && this.name[2].equals(otherName.name[2]) && this.name[3].equals(otherName.name[3]));
        }
    }*/
}

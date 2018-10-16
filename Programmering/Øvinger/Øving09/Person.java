class Person {

    private String firstname;
    private String lastname;
    private int birthyear;

    public Person(String firstname, String lastname, int birthyear) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthyear = birthyear;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public int getBirthYear() {
        return birthyear;
    }

    public String toString() {
        return firstname + " " + lastname + " " + birthyear;
    }
}

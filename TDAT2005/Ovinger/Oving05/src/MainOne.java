public class MainOne {
    public static void main(String[] args) {
        ReadFromFile rff = new ReadFromFile();
        rff.getFile();
        Name test = new Name("Torstein Holmberget");
        System.out.println(rff.get(test));
        //rff.display();
    }
}

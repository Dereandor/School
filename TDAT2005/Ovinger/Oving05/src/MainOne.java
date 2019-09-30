public class MainOne {
    public static void main(String[] args) {
        ReadFromFile rff = new ReadFromFile();
        rff.getFile();

        System.out.println(rff.get("Sundfær,Torstein Holmberget"));
    }
}

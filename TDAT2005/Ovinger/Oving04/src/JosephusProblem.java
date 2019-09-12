public class JosephusProblem {
    public static void main(String [] args) {
        CircularList list = new CircularList();
        int people = 10;
        int interval = 4;
        for (int i = 1; i < people+1; i++) {
            list.insertToList(i);
        }
        list.execute(interval);
    }
}

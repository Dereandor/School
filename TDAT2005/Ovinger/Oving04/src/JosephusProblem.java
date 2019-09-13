public class JosephusProblem {
    public static void main(String [] args) {
        CircularList list = new CircularList();
        int people = 41;
        int interval = 3;
        for (int i = 1; i < people+1; i++) {
            list.insertToList(i);
        }
        list.execute(interval);
    }
}

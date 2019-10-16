public class Predecessor {

    int distance;
    Node predecessor;

    public static final int infinite = 1000000000;

    public Predecessor() {
        distance = infinite;
    }

    public int getDistance() {
        return distance;
    }

    public Node getPredecessor() {
        return predecessor;
    }
}

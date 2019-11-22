public class Predecessor {
    int distance;
    int estimatedDistance;
    int time;
    int visited;
    Node predecessor;
    static final int unlimited = Integer.MAX_VALUE;
    
    public Predecessor() {
        distance = unlimited;
        visited = 0;
    }
    
    public int getDistance() {
        return distance;
    }
    
    public Node getPredecessor() {
        return predecessor;
    }
}

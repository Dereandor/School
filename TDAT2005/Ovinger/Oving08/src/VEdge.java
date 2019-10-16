public class VEdge extends Edge {

    int distanceBetween;

    public VEdge(Node n, VEdge next, int distanceBetween) {
        super(n, next);
        this.distanceBetween = distanceBetween;
    }
}

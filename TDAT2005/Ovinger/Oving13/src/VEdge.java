public class VEdge extends Edge {
    int time;
    
    public VEdge(Node t, VEdge nxt, int time) {
        super(t, nxt);
        this.time = time;
    }
}

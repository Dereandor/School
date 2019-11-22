public class Edge {
    Edge next;
    Node to;
    
    public Edge(Node t, Edge nxt) {
        to = t;
        next = nxt;
    }
}

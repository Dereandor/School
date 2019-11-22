import java.util.ArrayList;

public class Main13 {
    public static void main(String[] args) throws Exception {
        Graph g = new Graph();
        g.new_graph("noder.txt", "kanter.txt");
        
        long startD = System.currentTimeMillis();
        ArrayList<Node> res1 = g.djikstra(g.node[2419175], g.node[2460904]);
        long endD = System.currentTimeMillis();
        System.out.println("Time used with Djikstra: " + (endD-startD) + " ms");
        System.out.println("Nodes between destinations: " + res1.size());
        
        /*long startA = System.currentTimeMillis();
        ArrayList<Node> res2 = g.a_star(g.node[2419175], g.node[2460904]);
        long endA = System.currentTimeMillis();
        System.out.println("Time used with Astar: " + (endA-startA) + " ms");
        System.out.println("Nodes between destinations: " + res2.size());*/
    }
}

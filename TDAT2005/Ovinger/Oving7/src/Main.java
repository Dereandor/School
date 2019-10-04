import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Graph g1 = new Graph();
        g1.new_undirectedGraph("C:\\School\\TDAT2005\\Ovinger\\Oving7\\L7g1.txt");
        g1.bfs(g1.node[5]);

        System.out.println("\n");

        Graph g2 = new Graph();
        g2.new_undirectedGraph("C:\\School\\TDAT2005\\Ovinger\\Oving7\\L7g5.txt");
        g2.showTopological();

    }
}

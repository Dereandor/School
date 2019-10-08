public class Main {
    public static void main(String[] args) {
        try {
            Graph graph = GraphUtils.loadGraphFromFile("C:\\School\\TDAT2005\\Ovinger\\Oving7-2\\L7g5.txt");
            //graph.BFS(37774);
            graph.topologicalSort();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
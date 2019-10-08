import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void BFS(int s) {

        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while(queue.size != 0) {
            s = queue.poll();
            System.out.print(s+" ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void new_graph(String filename) {
        StringTokenizer st = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(filename)));
            st = new StringTokenizer(br.readLine());
            int nodes = Integer.parseInt(st.nextToken());
            Graph g = new Graph(nodes);
            int edges = Integer.parseInt(st.nextToken());

            for (int i = 0; i < edges; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                g.addEdge(from, to);
            }
        } catch (IOException f) {
            f.printStackTrace();
        } finally {
            br.close()
        }
    } 

    public static void main(String[] args) {
        System.out.println("Printing BFS from node ")
        StringTokenizer st = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File("C:\\School\\TDAT2005\\Ovinger\\Oving7\\L7g1.txt")));
            st = new StringTokenizer(br.readLine());
            int nodes = Integer.parseInt(st.nextToken());
            Graph g = new Graph(nodes);
            int edges = Integer.parseInt(st.nextToken());

            for (int i = 0; i < edges; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                g.addEdge(from, to);
            }
        } catch (IOException f) {
            f.printStackTrace();
        } finally {
            br.close()
        }

        g.bfs();
    }
}
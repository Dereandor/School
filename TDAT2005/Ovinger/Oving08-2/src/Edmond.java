import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Edmond {

    public static ArrayList<Integer> reverseArrayList(ArrayList<Integer> alist) {
        ArrayList<Integer> revArrayList = new ArrayList<Integer>();
        for (int i = alist.size() - 1; i >= 0; i--) {

            revArrayList.add(alist.get(i));
        }
        for (int i = 0; i < revArrayList.size() - 1; i++) {
            if (revArrayList.get(i).equals(revArrayList.get(i + 1))) {
                revArrayList.remove(i);
            }
        }
        return revArrayList;
    }

    public static void main(String[] args) throws Exception {
        String filepath = "C:\\School\\TDAT2005\\Ovinger\\Oving08-2\\flytgraf3.txt";

        BufferedReader br = new BufferedReader(new FileReader(filepath));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodes = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());
        int source = 0;
        int sink = 1;

        Node[] graph = new Node[nodes];

        for (int i = 0; i < nodes; i++) {
            graph[i] = new Node();
        }

        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            Edge a = new Edge(u, v, 0, c); //TODO sjekk om finnes fra før
            Edge b = new Edge(v, u, 0, 0); //TODO sjekk om finnes fra før

            a.setReverse(b);
            b.setReverse(a);

            graph[u].edges.add(a);
            graph[v].edges.add(b);
        }

        int maxFlow = 0;

        while (true) {
            Edge[] parent = new Edge[nodes];

            ArrayList<Node> q = new ArrayList<>();
            q.add(graph[source]);

            // BFS
            while (!q.isEmpty()) {
                Node curr = q.remove(0);

                for (Edge e : curr.edges) {
                    if (parent[e.v] == null && e.v != source && e.capacity > e.flow) {
                        parent[e.v] = e;
                        q.add(graph[e.v]);
                    }
                }
            }

            // sluk ikke nådd, hopper ut av løkken.
            if (parent[sink] == null)
                break;

            // sluk nådd, øker flytverdi
            int pushFlow = Integer.MAX_VALUE;

            // finner maxflyt
            for (Edge e = parent[sink]; e != null; e = parent[e.u]) {
                pushFlow = Math.min(pushFlow, e.capacity - e.flow);

            }

            // legger til flytverdier
            System.out.print("Økning: " + pushFlow + " ");
            ArrayList<Integer> flowIncrease = new ArrayList<>();
            for (Edge e = parent[sink]; e != null; e = parent[e.u]) {
                e.flow += pushFlow;
                e.reverse.flow -= pushFlow;
                flowIncrease.add(e.v);
                flowIncrease.add(e.u);
            }
            for (int i = 0; i < flowIncrease.size(); i++) {

            }
            flowIncrease = reverseArrayList(flowIncrease);
            System.out.println(" gjennom: " + flowIncrease.toString());

            maxFlow += pushFlow;
        }

        System.out.println("Max Flow: " + maxFlow);
        br.close();
    }
}

class Node {
    ArrayList<Edge> edges = new ArrayList<>();
}

class Edge {
    int u;
    int v;
    int flow;
    int capacity;
    Edge reverse;

    public Edge(int u, int v, int flow, int capacity) {
        this.u = u;
        this.v = v;
        this.flow = flow;
        this.capacity = capacity;
    }

    public void setReverse(Edge e) {
        reverse = e;
    }
}
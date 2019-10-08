import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    LinkedList<Integer> vertices[];

    public Graph(int size) {
        vertices = new LinkedList[size];
        
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new LinkedList<>();
            vertices[i].add(i);
        }
    }

    public void addEdge(int start, int dest) {
        if (start < 0 || start > vertices.length || dest < 0 || dest > vertices.length)
            throw new IllegalArgumentException("Start or destination not in table.");

        vertices[start].add(dest);
    }

    public void BFS(int s) {
        Integer[] precursor = new Integer[vertices.length];
        Integer[] distance = new Integer[vertices.length];
    
        LinkedList<Integer> queue = new LinkedList<>();

        distance[s] = 0;
        queue.add(s);

        System.out.println("n f d");

        while(!queue.isEmpty()) {
            s = queue.poll();

            Iterator<Integer> i = vertices[s].listIterator();

            while (i.hasNext()) {
                int n = i.next();

                if (distance[n] == null) {
                    distance[n] = ((distance[s] != null) ? distance[s] : 0) + 1;
                    precursor[n] = s;
                    queue.add(n);
                }
            }
            System.out.println(s + " " + precursor[s] + " " + distance[s]);
        }
    }

    public void topologicalSort() {
        Stack stack = new Stack();

        boolean visited[] = new boolean[vertices.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < vertices.length; i++) {
            if (!visited[i]) {
                topologicalUtil(i, visited, stack);
            }
        }

        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public void topologicalUtil(int v, boolean[] visited, Stack stack) {
        visited[v] = true;
        Integer i;

        Iterator<Integer> it = vertices[v].iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i]) {
                topologicalUtil(i, visited, stack);
            }
        }
        stack.push(v);
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < vertices.length; i++) {
            for (Integer v : vertices[i]) {
                result += (v + " ");
            }
            result += "\n";
        }

        return result;
    }
}
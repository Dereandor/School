import java.util.*;

public class GraphLinked {
    private Node[] nodes;
    final boolean undirected;
    
    public GraphLinked(int size, boolean undirected) {
        nodes = new Node[size];
        this.undirected = undirected;
    }
    
    public void addNode(int index, int data, int weight) {
        if (nodes[index] == null) nodes[index] = new Node(data, weight);
        else nodes[index].addNode(data, weight);
        
        if (undirected) {
            if (nodes[data] == null) nodes[data] = new Node(index, weight);
            else nodes[data].addNode(index, weight);
        }
    }
    
    public String toString() {
        String string = "";
        for (int i = 0; i < nodes.length;i++) {
            if (nodes[i] != null) {
                string += "from: " + i + " to: ";
                Node node = nodes[i];
                string += node.getNode() + ", ";
                while (node.getNextNode() != null) {
                    node = node.getNextNode();
                    string += node.getNode() + ", ";
                }
                string += "\n";
            }
        }
        
        return string;
    }
    
    public int[][] dijkstra(int fromNode) {
        
        int[] lengthFromStart = new int[nodes.length];
        int[] cameFrom = new int[nodes.length];
        
        LengthFromSourceComparator comparator = new LengthFromSourceComparator(lengthFromStart);
        PriorityQueue<Integer> queue = new PriorityQueue<>(size(), comparator);
        
        for (int i = 0;i < size();i++) {
            lengthFromStart[i] = 10000000;
            cameFrom[i] = 10000000;
        }
        
        lengthFromStart[fromNode] = 0;
        cameFrom[fromNode] = -2;
        
        queue.add(fromNode);
        
        int nodeIndex, totalLength, totalNodes = 0;
        Node node;
        
        while (!queue.isEmpty()) {
            
            nodeIndex = queue.poll();
            node = nodes[nodeIndex];
            totalNodes++;
            
            while (node != null) {
                
                totalLength = lengthFromStart[nodeIndex] + node.getLength();
                
                if (totalLength < lengthFromStart[node.getNode()]) {
                    lengthFromStart[node.getNode()] = totalLength;
                    cameFrom[node.getNode()] = nodeIndex;
                    
                    queue.add(node.getNode());
                }
                
                node = node.getNextNode();
            }
        }
        
        return new int[][]{lengthFromStart, cameFrom};
    }
    
    public int[][] dijkstra(int fromNode, int toNode) {
        
        int[] lengthFromStart = new int[nodes.length];
        int[] cameFrom = new int[nodes.length];
        
        LengthFromSourceComparator comparator = new LengthFromSourceComparator(lengthFromStart);
        PriorityQueue<Integer> queue = new PriorityQueue<>(size(), comparator);
        
        for (int i = 0;i < size();i++) {
            lengthFromStart[i] = 10000000;
            cameFrom[i] = 10000000;
        }
        
        lengthFromStart[fromNode] = 0;
        cameFrom[fromNode] = -2;
        
        queue.add(fromNode);
        
        int nodeIndex, totalLength, totalNodesProcessed = 0, getNode;
        Node node;
        
        while (!queue.isEmpty()) {
            
            nodeIndex = queue.poll();
            
            if (nodeIndex == toNode) break;
            
            node = nodes[nodeIndex];
            totalNodesProcessed++;
            
            while (node != null) {
                
                totalLength = lengthFromStart[nodeIndex] + node.getLength();
                getNode = node.getNode();
                
                if (totalLength < lengthFromStart[getNode]) {
                    lengthFromStart[getNode] = totalLength;
                    cameFrom[getNode] = nodeIndex;
                    
                    if (toNode == getNode) queue.remove(getNode);
                    queue.add(getNode);
                }
                
                node = node.getNextNode();
            }
        }
        
        int traceBackNode = toNode;
        List<Integer> passedNodes = new ArrayList();
        passedNodes.add(0, toNode);
        
        while (cameFrom[traceBackNode] != -2) {
            passedNodes.add(0, traceBackNode);
            traceBackNode = cameFrom[traceBackNode];
        }
        
        System.out.println("Processed nodes: " + totalNodesProcessed);
        
        return new int[][]{passedNodes.stream().mapToInt(i->i).toArray(), new int[]{lengthFromStart[toNode]}};
    }
    
    public int[][] aStar(int fromNode, int toNode, GraphLogLat graphLogLat) {
        
        int[] lengthFromStart = new int[nodes.length];
        int[] cameFrom = new int[nodes.length];
        int[] distanceTo = new int[nodes.length];
        
        LengthBetweenNodesComparator comparator = new LengthBetweenNodesComparator(distanceTo, lengthFromStart);
        PriorityQueue<Integer> queue = new PriorityQueue<>(size(), comparator);
        
        for (int i = 0;i < size();i++) {
            lengthFromStart[i] = 10000000;
            cameFrom[i] = 10000000;
        }
        
        lengthFromStart[fromNode] = 0;
        cameFrom[fromNode] = -2;
        
        queue.add(fromNode);
        
        int nodeIndex, totalLength, totalNodesProcessed = 0, calc = 0, getNode;
        Node data;
        
        while (!queue.isEmpty()) {
            
            nodeIndex = queue.poll();
            
            if (nodeIndex == toNode) break;
            
            data = nodes[nodeIndex];
            totalNodesProcessed++;
            
            while (data != null) {
                
                totalLength = lengthFromStart[nodeIndex] + data.getLength();
                getNode = data.getNode();
                
                if (totalLength < lengthFromStart[getNode]) {
                    lengthFromStart[getNode] = totalLength;
                    cameFrom[getNode] = nodeIndex;
                    
                    if (distanceTo[getNode] == 0) {
                        distanceTo[getNode] = graphLogLat.calcDistance(getNode, toNode);
                        calc++;
                    }
                    
                    if (toNode == getNode) queue.remove(getNode);
                    queue.add(getNode);
                }
                
                data = data.getNextNode();
            }
        }
        
        int traceBackNode = toNode;
        List<Integer> passedNodes = new ArrayList();
        passedNodes.add(0, toNode);
        
        while (cameFrom[traceBackNode] != -2) {
            passedNodes.add(0, traceBackNode);
            traceBackNode = cameFrom[traceBackNode];
        }
        
        System.out.println("Processed nodes: " + totalNodesProcessed);
        
        return new int[][]{passedNodes.stream().mapToInt(i->i).toArray(), new int[]{lengthFromStart[toNode]}};
    }
    
    public int size() {
        return nodes.length;
    }
    
    private class LengthFromSourceComparator implements Comparator<Integer>
    {
        private int[] lengthFromSource;
        
        public LengthFromSourceComparator(int[] lengthFromSource) {
            this.lengthFromSource = lengthFromSource;
        }
        
        @Override
        public int compare(Integer node1, Integer node2) {
            return lengthFromSource[node1] - lengthFromSource[node2];
        }
    }
    
    private class LengthBetweenNodesComparator implements Comparator<Integer>
    {
        private int[] lengthFromSource;
        private int[] distanceTo;
        
        public LengthBetweenNodesComparator(int[] distanceTo, int[] lengthFromSource) {
            this.distanceTo = distanceTo;
            this.lengthFromSource = lengthFromSource;
        }
        
        @Override
        public int compare(Integer node1, Integer node2) {
            
            return  distanceTo[node1] + lengthFromSource[node1] - distanceTo[node2] - lengthFromSource[node2] ;
        }
    }
}
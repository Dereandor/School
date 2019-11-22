public class Node {
    private int data;
    private int length;
    private Node nextNode;
    
    public Node(int data, int length) {
        this.data = data;
        this.length = length;
    }
    
    public int getNode() {
        return data;
    }
    
    public Node getNextNode() {
        return nextNode;
    }
    
    public int getLength() {
        return length;
    }
    
    public void addNode(int data, int weight) {
        if (nextNode == null) nextNode = new Node(data, weight);
        else nextNode.addNode(data, weight);
    }
    
}
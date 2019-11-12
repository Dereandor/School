public class Node {
    char data;
    int frequency;
    Node left = null;
    Node right = null;

    public Node(char c, int f) {
        this.data = c;
        this.frequency = f;
    }

    public Node(char c, int f, Node l, Node r) {
        this.data = c;
        this.frequency = f;
        this.left = l;
        this.right = r;
    }
}
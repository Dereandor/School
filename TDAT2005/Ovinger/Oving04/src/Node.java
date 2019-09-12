public class Node {
    int element;
    Node next;
    Node previous;

    //constructor without parameters
    public Node(){
        element = 0;
        next = null;
        previous = null;
    }

    //constructor with only element parameter
    public Node(int e) {
        this.element = e;
    }

    //constructor for circular single linked list
    public Node(int e, Node n) {
        this.element = e;
        this.next = n;
    }

    //constructor for circular double linked list
    public Node(int e, Node n, Node p) {
        element = e;
        next = n;
        previous = p;
    }

    public int getElement() {
        return element;
    }

    public Node getNext(){
        return next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setElement(int e) {
        element = e;
    }

    public void setNext(Node n) {
        next = n;
    }

    public void setPrevious(Node p) {
        previous = p;
    }
}

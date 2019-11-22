import java.util.ArrayList;

public class Heap {
    private ArrayList<Node> list;
    private boolean djikstra;
    
    public Heap(boolean djikstra) {
        this.list = new ArrayList<>();
        this.djikstra = djikstra;
    }
    
    public void insert(Node item) {
        list.add(item);
        int i = list.size() - 1;
        int parent = parent(i);
        
        if (djikstra) {
            while ( parent != i && ((Predecessor)list.get(i).d).distance < ((Predecessor)list.get(parent).d).distance) {
                swap(i, parent);
                i = parent;
                parent = parent(i);
            }
        } else {
            while (parent != i && ((Predecessor)list.get(i).d).estimatedDistance < ((Predecessor)list.get(parent).d).estimatedDistance) {
                swap(i, parent);
                i = parent;
                parent = parent(i);
            }
        }
    }
    
    private int left(int i) {
        return 2 * i + 2;
    }
    
    private int right(int i) {
        return 2 * i + 1;
    }
    
    public void minHeapify(int i) {
        int left = left(i);
        int right = right(i);
        int smallest = -1;
        
        if (djikstra) {
            if (left <= list.size() - 1 && ((Predecessor)list.get(left).d).distance < ((Predecessor)list.get(i).d).distance) {
                smallest = left;
            } else {
                smallest = i;
            }
            if (right <= list.size() -1 && ((Predecessor)list.get(right).d).distance < ((Predecessor)list.get(i).d).distance) {
                smallest = right;
            }
        } else {
            if (left <= list.size() - 1 && ((Predecessor)list.get(left).d).estimatedDistance < ((Predecessor)list.get(i).d).estimatedDistance) {
                smallest = left;
            } else {
                smallest = i;
            }
            if (right <= list.size() -1 && ((Predecessor)list.get(right).d).estimatedDistance < ((Predecessor)list.get(i).d).estimatedDistance) {
                smallest = right;
            }
        }
        
        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }
    
    public Node extractMin() {
        if (list.size() == 0) {
            throw new IllegalStateException("Empty Heap");
        } else if (list.size() == 1) {
            Node min = list.remove(0);
            return min;
        }
        
        Node min = list.get(0);
        Node lastItem = list.remove(list.size() - 1);
        list.set(0, lastItem);
        minHeapify(0);
        return min;
    }
    
    public void buildHeap() {
        for(int i = list.size() / 2; i >= 0; i--) {
            minHeapify(i);
        }
    }
    
    private int parent(int i) {
        if ( i % 2 == 1) {
            return i / 2;
        }
        return (i - 1) / 2;
    }
    
    public boolean isEmpty() {
        return list.size() == 0;
    }
    
    private void swap(int i, int parent) {
        Node temp = list.get(parent);
        list.set(parent, list.get(i));
        list.set(i, temp);
    }
    
    public Node getMin() {
        return list.get(0);
    }
    
    public boolean contains(Node n) {
        return list.contains(n);
    }
}

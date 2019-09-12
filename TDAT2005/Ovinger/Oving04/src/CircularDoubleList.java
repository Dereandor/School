public class CircularDoubleList {

    private Node start;
    private Node end;
    int size;

    public CircularDoubleList() {
        start = null;
        end = null;
        size = 0;
    }

    public boolean isEmpty() {
        return start == null;
    }

    public int getSize() {
        return size;
    }

    public void inserAtStart(int value) {
        Node temp = new Node(value, null, null);
        if (start == null) {
            temp.setNext(temp);
            temp.setPrevious(temp);
            start = temp;
            end = temp;
        } else {
            temp.setPrevious(end);
            end.setNext(temp);
            start.setPrevious(temp);
            temp.setNext(start);
            start = temp;
        }
        size++;
    }

    public void insertAtEnd(int value) {
        Node temp = new Node(value, null, null);
        if (start == null) {
            temp.setNext(temp);
            temp.setPrevious(temp);
            start = temp;
            end = temp;
        } else {
            temp.setPrevious(end);
            end.setNext(temp);
            start.setPrevious(temp);
            temp.setNext(start);
            end = temp;
        }
        size++;
    }

    public void insertAtPosition(int value, int position) {
        if (position > size || position < 0) throw new IndexOutOfBoundsException();

        Node a = new Node(value, null, null);
        if (position == 1) inserAtStart(value);
        if (position == size) insertAtEnd(value);
        Node b = start;
        for (int i = 2; i < size; i++) {
            if (i == position) {
                Node temp = b.getNext();
                b.setNext(a);
                a.setPrevious(b);
                a.setNext(temp);
                temp.setPrevious(a);
            }
            b = b.getNext();
        }
        size++;
    }

    public void removeNodeAtPosition(int position) {
        if(position > size || position < 0) throw new IndexOutOfBoundsException();
        if (position == 1) {
            if (size == 1) {
                start = null;
                end = null;
                size = 0;
            }
            start = start.getNext();
            start.setPrevious(end);
            end.setNext(start);
            size--;
        }
        if (position == size) {
            end = end.getPrevious();
            end.setNext(start);
            start.setPrevious(end);
            size--;
        }
        Node temp = start.getNext();
        for (int i = 2; i < size; i++) {
            if (i == position) {
                Node prev = temp.getPrevious();
                Node next = temp.getNext();
                prev.setNext(next);
                next.setPrevious(prev);
                size--;
            }
            temp = temp.getNext();
        }
    }

    public void execute(int interval) {

    }

    public void displayList() {
        Node temp = start;
        if (size == 0) System.out.println("List is empty");
        if (start.getNext() == start) System.out.println(start.getElement() + " <-> " + temp.getElement());
        System.out.print(start.getElement() + " <-> ");
        temp = start.getNext();
        while (temp.getNext() != start) {
            System.out.print(temp.getElement() + " <-> ");
            temp = temp.getNext();
        }
        System.out.print(temp.getElement() + " <-> ");
        temp = temp.getNext();
        System.out.print(temp.getElement() + "\n");
    }

    public void displayJosephus() {
        Node temp = start;
        if (size == 0) System.out.println("List is empty");
        if (start.getNext() == start) System.out.println(start.getElement() + " -> " + temp.getElement());
        System.out.print(start.getElement() + " ");
        temp = start.getNext();
        while (temp.getNext() != start) {
            System.out.print(temp.getElement() + " ");
            temp = temp.getNext();
        }
        System.out.print(temp.getElement());
    }
}

public class CircularList {
     private Node head;
     private int size;

     public boolean isEmpty() {
         return head == null;
     }

     public int getSize() {
         return size;
     }

     public void insertToList(int value) {
         Node temp = new Node(value);
         if (head == null) {
             head = temp;
         } else {
             Node tp = head;
             while (tp.next != head) tp = tp.next;
             tp.next = temp;
         }
         temp.next = head;
         size++;
     }

     public void deleteNode(Node n) {
         Node current = head;
         Node previous = head;
         int data = n.element;
         while (current.element != data) {
             if(current.next == head) {
                 break;
             }
             previous = current;
             current = current.next;
         }
         previous.next = current.next;
         head = previous.next;
         size--;
     }

     private void deleteFirst(Node n) {
         Node current = head;
         Node previous = head;
         int data = n.element -1;
         while (current.element != data) {
             if(current.next == head) {
                 break;
             }
             previous = current;
             current = current.next;
         }
         previous.next = current.next;
         size--;
     }

     public void execute(int interval) {
         Node current = head;
         Node temp = null;
         boolean delFirst = true;
         System.out.println("Original list: ");
         displayList();
         while(getSize() >= 2) {
             for (int i = 0; i < interval; i++) {
                 temp = current;
                 current = current.next;
             }
             if (delFirst) deleteFirst(current);
             else deleteNode(current);
             current = temp;
             System.out.println("\n");
             displayList();
             delFirst = false;
         }
     }

     public void displayList() {
         Node temp = head;
         if (size == 0) isEmpty();
         for (int i = 0; i < size - 1; i++) {
             System.out.println(temp.getElement()+" -> ");
             temp = temp.next;
         }
         System.out.println(temp.element);
     }
}

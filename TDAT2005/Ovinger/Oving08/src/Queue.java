public class Queue {
    private Object[] tab;
    private int start = 0;
    private int slutt = 0;
    private int antall = 0;

    public Queue(int str) {
        tab = new Object[str];
    }

    public boolean empty() {
        return antall == 0;
    }

    public boolean full() {
        return antall ==tab.length;
    }

    public void addQueue(Object e) {
        if (full()) return;
        tab[slutt] = e;
        slutt = (slutt+1)%tab.length;
        ++antall;
    }

    public Object nextQueue() {
        if (!empty()) {
            Object e = tab[start];
            start = (start+1)%tab.length;
            --antall;
            return e;
        }
        else return null;
    }

    public Object checkQueue(){
        if(!empty()) {
            return tab[start];
        }
        else return null;
    }
}

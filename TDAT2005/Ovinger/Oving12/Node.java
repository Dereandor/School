class Node {
    int freq;
    Byte ch;
    Node left;
    Node right;

    Node(int freq, Byte ch) {
        this.freq = freq;
        this.ch = ch;
        right = null;
        left = null;
    }

    Node(int freq) {
        this.freq = freq;
        this.ch = null;
        right = null;
        left = null;
    }

    protected int compareTo(Node other) {
        if (other.freq < this.freq) {
            return 1;
        } else if (other.freq > this.freq) {
            return -1;
        } else {
            return 0;
        }
    }

    public boolean isLeaf() {
        if (left == null && right == null) {
            return true;
        } else {
            return false;
        }
    }
}
import java.util.Scanner;

class Tree implements Comparable<Tree> {
    Node root;

    private Node addRecursive(Node current, int freq) {
        if (current == null) {
            return new Node(freq);
        }

        if (freq < current.freq) {
            current.left = addRecursive(current.left, freq);
        } else if (freq > current.freq) {
            current.right = addRecursive(current.right, freq);
        } else {
            return current;
        }

        return current;
    }

    private Node addRecursive(Node current, Node newNode) {
        if (current == null) {
            return newNode;
        }

        if (newNode.compareTo(current) < 0) {
            current.left = addRecursive(current.left, newNode);
        } else if (newNode.compareTo(current) > 0) {
            current.right = addRecursive(current.right, newNode);
        } else {
            return current;
        }

        return current;
    }

    public void add(int freq) {
        root = addRecursive(root, freq);
    }

    public void add(Node node) {
        root = addRecursive(root, node);
    }

    public int compareTo(Tree other) {
        return this.root.freq - other.root.freq;
    }

    public void printCode(Node n, String s, byte ch) {
        if (n.left == null && n.right == null && n.ch == ch) {

            System.out.print(s);

            return;
        }
  
        printCode(n.left, s + "0", ch);
        printCode(n.right, s + "1", ch);
    }

    public static void getBitCode(String[] st, Node x, String s) {
        if (!x.isLeaf()) {
            getBitCode(st, x.left,  s + '0');
            getBitCode(st, x.right, s + '1');
        }
        else {
            st[x.ch+128] = s;
        }
    }

    public byte[] getByte(String bitString, int length) {
        Node x = root;
        byte[] b = new byte[length];
        int sc = 0;
        for (int i = 0; i < b.length; i++) {
            while (!x.isLeaf() && sc < bitString.length() - 1) {
                if (bitString.charAt(sc) == '1') {
                    x = x.right;
                } else if (bitString.charAt(sc) == '0') {
                    x = x.left;
                }
                sc++;
            }
            if (x.isLeaf()) {
                b[i] = x.ch;
                x = root;
            }
        }

        return b;
    }
}
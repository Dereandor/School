import java.util.Stack;

class Node {
    char value;
    Node left, right;

    Node(char item) {
        value = item;
        left = right = null;
    }
}

class Tree {

    boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
            return true;
        }
        return false;
    }

    void inOrder(Node t) {
        if (t != null) {
            inOrder(t.left);
            System.out.print(t.value + " ");
            inOrder(t.right);
        }
    }

    Node constructTree(char postfix[]) {
        Stack<Node> st = new Stack();
        Node t, t1, t2;

        for (int i = 0; i < postfix.length; i++) {
            if (!isOperator(postfix[i])) {
                t = new Node(postfix[i]);
                st.push(t);
            } else {
                t = new Node(postfix[i]);

                t1 = st.pop();
                t2 = st.pop();

                t.right = t1;
                t.left = t2;

                st.push(t);
            }
        }
        t = st.peek();
        st.pop();

        return t;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        String postfix = "ab+ef*g*-";
        char[] charArray = postfix.toCharArray();
        Node root = tree.constructTree(charArray);
        System.out.println("infix expression is");
        tree.inOrder(root);
    }
}

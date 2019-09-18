public class HashArray {
    Name key;
    int value;
    HashArray next;

    public HashArray() {

    }

    public HashArray(Name n, int v) {
        key = n;
        value = v;
    }

    public int getValue() {
        return value;
    }

    public Name getKey() {
        return key;
    }
}

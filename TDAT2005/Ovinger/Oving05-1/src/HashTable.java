public class HashTable {

    private int size = 128; //Closest factor of 2, 2^7

    static private class ListNode {

        HashObject key;
        HashObject value;
        ListNode next;
    }

    private ListNode[] table;

    private int count;

    public HashTable() {
        table = new ListNode[size];
    }

    public HashTable(int initialSize) {
        table = new ListNode[initialSize];
    }

    public void put(HashObject key, HashObject value) {
        int bucket = hash(key);
        ListNode list = table[bucket];
        while (list != null) {
            if (list.key.equals(key))
                break;
            list = list.next;
        }
        if (list != null) {
            list.value = value;
        }
        else {

            if (count > 0.75*table.length) {
                resize();
            }
            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;
            newNode.next = table[bucket];
            table[bucket] = newNode;
            count++;
        }
    }

    public HashObject get(HashObject key) {
        int bucket = hash(key);
        ListNode list = table[bucket];
        while (list != null) {
            if (list.key.equals(key))
                return list.value;
            list = list.next;
        }
        return null;
    }

    public void remove(HashObject key) {
        int bucket = hash(key);
        if (table[bucket] == null) {
            return;
        }
        if (table[bucket].key.equals(key)) {
            table[bucket] = table[bucket].next;
            count--;
            return;
        }
        ListNode prev = table[bucket];
        ListNode curr = prev.next;
        while (curr != null && ! curr.key.equals(key)) {
            curr = curr.next;
            prev = curr;
        }

        if (curr != null) {
            prev.next = curr.next;
            count--;
        }
    }

    public boolean containsKey(HashObject key) {
        int bucket = hash(key);
        ListNode list = table[bucket];
        while (list != null) {
            if (list.key.equals(key))
                return true;
            list = list.next;
        }
        return false;
    }

    public int size() {
        return count;
    }

    private int hash(HashObject key) {
        return (Math.abs(key.hashCode())) % table.length;
    }

    private void resize() {
        ListNode[] newtable = new ListNode[table.length*2];
        for (int i = 0; i < table.length; i++) {
            ListNode list = table[i];
            while (list != null) {
                ListNode next = list.next;
                int hash = (Math.abs(list.key.hashCode())) % newtable.length;
                list.next = newtable[hash];
                newtable[hash] = list;
                list = next;
            }
        }
        table = newtable;
    }

}
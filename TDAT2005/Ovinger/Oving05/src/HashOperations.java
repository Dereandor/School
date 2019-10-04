import java.sql.SQLOutput;
import java.util.HashMap;

public class HashOperations {

    private final int size = 5000011; //closest prime number
    private HashInt[] table = new HashInt[size];

    public void fillHashTable(int[] input) {
        int collisions = 0;

        for (int i = 0; i < input.length; i++) {
            int hash = h1(input[i]);

            HashInt newEntry = new HashInt(hash, input[i]);

            while (table[hash] != null) {
                hash = (hash + h2(input[i])) % size;
                collisions++;
            }
            table[hash] = newEntry;
        }
        System.out.println("Collisions: " + collisions);
    }

    public void benchmarkHashInt(int[] input) {
        HashInt[] benchmark = new HashInt[size];
        for (int i = 0; i < input.length; i++) {
            int hash = h1(input[i]);

            HashInt newEntry = new HashInt(hash, input[i]);

            while (benchmark[hash] != null) {
                hash = (hash + h2(input[i])) % size;
            }
            benchmark[hash] = newEntry;
        }
    }
    
    public void benchmarkHashMap(int[] input) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            map.put(input[i], input[i]);
        }
    }

    private int h1(int key){
        return key % size;
    }

    private int h2(int key){
        int h2 = key%(size-1) +1;
        if (h2 == 0) return h2+1;
        if (h2 == size) return h2-1;
        return h2;
    }
}

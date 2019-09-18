import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromFile {
    private final int size = 128; //2^7 spaces for closest estimate
    private int collisions = 0;
    private HashArray[] array = new HashArray[size];

    public boolean getFile() {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("C:\\School\\TDAT2005\\Ovinger\\Oving05\\src\\navn.txt"));
            System.out.println("File found");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return false;
        }
        while (sc.hasNext()) {
            String line = sc.nextLine();
            //String[] fullname = line.split("\\s+");
            Name newName = new Name(line);
            int key = newName.getHashCode();
            put(newName, key);

            /*if(fullname.length == 2) {
                Name newName = new Name(fullname[1], fullname[0]);
                int key = newName.getHashCode();
                put(newName, key);
            }
            if (fullname.length == 3) {
                Name newName = new Name(fullname[1], fullname[2], fullname[0]);
                int key = newName.getHashCode();
                put(newName, key);
            }
            if (fullname.length == 4) {
                Name newName = new Name(fullname[1], fullname[2], fullname[3], fullname[0]);
                int key = newName.getHashCode();
                put(newName, key);
            }*/
        }
        sc.close();
        int elements = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] != null) {
                elements++;
            }
        }
        System.out.println("Number of collisions per person: " + ((double)(collisions)/(double)(size)));
        System.out.println("Load factor: " + ((double)(elements)/(double)(size)));
        return true;
    }

    public int put(Name key, int value) {
        int h1 = key.getHashCode();
        HashArray newEntry = new HashArray(key, value);

        int m = array.length;

        for (int i = 0; i < m; i++) {
            int j = probe(h1, i, m);
            if(array[j] == null) {
                array[j]= newEntry;
                return j;
            } else {
                collisions++;
                System.out.println("Collision between: " + key + " and " + array[j].getKey());
                int hash2 = h2(h1);
                if (array[hash2] == null) {
                    array[hash2] = newEntry;
                    return hash2;
                }
            }
        }
        return -1;
        /*if(array[h1] == null) {
            System.out.println("Putting key: "+key+", value: "+value+" to list");
            array[h1] = newEntry;
        } else {
            System.out.println("Collision detected for key: "+key+ " and " +array[h1].getKey());
            int hash2 = h2(h1);
            if (array[hash2] == null) {
                array[hash2] = newEntry;
            } else {
                collisions++;
            }
        }*/
    }

    private int probe(int h, int i, int m) {
        return (h+i) % m;
    }

    public boolean get(Name key) {
        HashArray x = array[0];
        while (x != null) {
            if (x.getKey().equals(key)) {
                return true;
            }
            x = x.next;
        }
        return false;
    }
    public void display() {
        for (int i = 0; i < size; i++) {
            if (array[i] != null) {
                System.out.println(array[i].getKey());
            }
        }
    }

    private int h2(int h) {
        return (h+1)%size;
    }
}

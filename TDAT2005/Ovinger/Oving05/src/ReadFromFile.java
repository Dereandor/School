import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromFile {
    private static final int size = 128; //2^7 spaces for closest estimate
    private int collisions = 0;
    private Node[] array = new Node[size];

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
            put(line);
            //System.out.println(newName.toString()+". Hash: "+key);
        }
        sc.close();
        int elements = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] != null) {
                elements++;
            }
        }
        System.out.println("Number of collisions: " + collisions);
        System.out.println("Load factor: " + ((double)(elements)/(double)(size)));
        return true;
    }

    public int put(String key) {
        int h1 = getHashCode(key);
        int h = h1 % array.length;

        if (array[h] == null) {
            array[h] = new Node(key);
            return h;
        } else {
            Node node = array[h];
            while(node.previous != null) {
                node = node.previous;
            }
            node.previous = new Node(key);
            System.out.println("Collision between: " + key + " and " + array[h].getName());
            collisions++;

        }

        /*for (int i = 0; i < array.length; i++) {
            if (array[h] == null) {
                array[h] = new Node(key);
                return h;
            } else {
                Node node = array[h];
                while(node.previous != null) {
                    node = node.previous;
                }
                node.previous = new Node(key);
                System.out.println("Collision between: " + key + " and " + array[h].getName());
                collisions++;

            }
        }*/
        return -1;
    }

    public String get(String key) {
        int h1 = getHashCode(key);
        int h = h1 % array.length;

        if (array[h] != null) {
            if (array[h].getName().equals(key)) {
                return array[h].getName();
            }
        } else {
            Node node = array[h];
            while (node.previous != null) {
                if (node.getName().equals(key)) {

                    return array[h].getName();
                }
                node = node.previous;
            }

        }
        return null;
    }

    public static int getHashCode(String name) {
        int temp = 0;
        for (int i = 0; i < name.length(); i++) {
            temp+= name.charAt(i) * (127 *(i+1));
        }
        return temp;
    }
}

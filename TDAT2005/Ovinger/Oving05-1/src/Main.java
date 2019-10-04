import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String nameList = readFromFile("C:\\School\\TDAT2005\\Ovinger\\Oving05\\src\\navn.txt");
        String[] name = nameList.split("\n");

        HashTable ht = new HashTable();



        for (int i = 0; i < name.length; i++) {
            HashObject newEntry = new HashObject(name[i], getAscii(name[i]));
            ht.put(newEntry, newEntry);
        }
    }
    public static int getAscii(String tekst) {
        int sum = 0;
        for (int i = 0; i < tekst.length(); i++) {
            int no = tekst.charAt(i) * (127 * (i+1));
            sum += no;
        }
        return sum;
    }

    private static String readFromFile(String position) {
        String message = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(position));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }

            return sb.toString();
        } catch(FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return message;
    }
}

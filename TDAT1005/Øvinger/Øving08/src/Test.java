import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Test {

    public Tribune[] lesfil(String filnavn) {
        try {
            FileInputStream fis = new FileInputStream(filnavn);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Tribune[] t = (Tribune []) ois.readObject();
            ois.close();
            return t;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean skrivfil(Tribune[] t, String filnavn) {
        try {
            FileOutputStream fis = new FileOutputStream(filnavn);
            ObjectOutputStream oos = new ObjectOutputStream(fis);
            oos.writeObject(t);
            oos.close();
            return true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        Tribune[] test = new Tribune[4];
        String[] navn = {"A", "B", "C", "D"};
        test[0] = new Staa("stå1", 50, 100);
        test[1] = new Staa("stå2", 50, 200);
        test[2] = new Sitte("sitte", 100, 10, 10);
        test[3] = new VIP("vip", 200, 10, 10);

        for (int i = 0; i < test.length; i++) {
            System.out.println(Arrays.toString(test[i].kjopBilletter(5)));
            System.out.println(Arrays.toString(test[i].kjopBilletter(navn)));
        }
        System.out.println(Arrays.toString(test));
        Arrays.sort(test, (a,b) -> b.finnInntekt() - a.finnInntekt());
        System.out.println(Arrays.toString(test));

    }
}

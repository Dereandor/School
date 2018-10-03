import java.util.Arrays;
import java.util.stream.*;

class StringExamples {

    public static void main(String[]args) {

        String test = ("This is a test string");

        System.out.println(test);

        String test2 = test.replaceAll("test", "Test"); //replaces all "test" with "Test".

        System.out.println(test2);

        int test3 = test.hashCode(); //gets the hashvaues for the string

        System.out.println(test3);

        int test4 = test.codePointAt(4); //gets the unicode value of the character at the given point

        System.out.println(test4);

        String test5 = test.toUpperCase(); //converts the string to all upper case characters.

        System.out.println(test5);

        char[] test6 = test.toCharArray(); //creates an array with the legth of the string which contains the string.

        System.out.println(test6);
    }
}

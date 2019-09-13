import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFilePushStack {

    private Scanner sc;
    private Stack stack;

    private static String getFilePath() {
        JFileChooser jc = new JFileChooser();
        jc.setAcceptAllFileFilterUsed(false);
        jc.addChoosableFileFilter(new FileNameExtensionFilter("java", "java"));
        String file_path = null;
        if(jc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = jc.getSelectedFile();
            file_path = file.getAbsolutePath();
        } else {
            file_path = "";
        }
        return file_path;
    }

    private void getScannerObject() throws FileNotFoundException {
        sc = null;
        try {
            sc = new Scanner(new BufferedReader(new FileReader(getFilePath())));
        } catch (FileNotFoundException e) {
            System.out.println("Could not get file path");
        }
    }

    private boolean pushToStack() {
        String output = "";
        boolean Ok = true;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            char[] t = line.toCharArray();
            for(char a : t){
                if (a == '{'){
                    stack.push('{');
                    output += "{";
                }
                else if (a == '['){
                    stack.push('[');
                    output += "[";
                }
                else if (a == '('){
                    stack.push('(');
                    output += "(";
                }
                else{
                    if (a == ')'){
                        int k = stack.pop();
                        Ok = k == "(".charAt(0);
                        output += ")";
                    }
                    else if (a == ']'){
                        int k = stack.pop();
                        Ok = k == "[".charAt(0);
                        output += "]";
                    }
                    else if (a == '}'){
                        int k = stack.pop();
                        Ok = k == "{".charAt(0);
                        output += "}";
                    }
                }
            }

        }
        sc.close();
        System.out.println(output);
        if(!stack.isEmpty()) return false;
        return true;
    }

    public void scanFile(int stacksize) throws FileNotFoundException {
        getScannerObject();
        stack = new Stack(stacksize);
        //String ss = pushToStack();
        //System.out.println("String: " + ss);
        System.out.println("\n");
        if (pushToStack()) {
            System.out.println("Clean code");
        } else {
            System.out.println("Bad Code");
        }
    }
}

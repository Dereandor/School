import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Calculator extends Thread {
    Socket connection;
    
    public Calculator(Socket connection) {
        this.connection = connection;
    }
    
    public void run() {
        InputStreamReader readerConnection = null;
        PrintWriter printer = null;
        try {
            readerConnection = new InputStreamReader(connection.getInputStream());
            printer = new PrintWriter(connection.getOutputStream());
        } catch (IOException e) {
            System.out.println("IOException: ");
            e.printStackTrace();
        }
    
        BufferedReader reader = new BufferedReader(readerConnection);
        
        String data = null;
        try {
            data = reader.readLine();
        } catch (IOException e) {
            System.out.println("IOException: ");
            e.printStackTrace();
        }
        while ( true) {
            int sumNumbers = -1;
            if (data.contains("+")) {
                sumNumbers = Integer.parseInt(data.split("\\+")[0]) + Integer.parseInt(data.split("\\+")[1]);
            } else if (data.contains("-")) {
                sumNumbers = Integer.parseInt(data.split("-")[0]) - Integer.parseInt(data.split("-")[1]);
            }
    
            try {
                data = reader.readLine();
            } catch (IOException e) {
                System.out.println("IOException: ");
                e.printStackTrace();
            }
        }
        
    }
}

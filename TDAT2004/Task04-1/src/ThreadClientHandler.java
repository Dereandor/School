import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadClientHandler extends Thread {
    private Socket connection;
    
    public ThreadClientHandler(Socket connection) {
        this.connection = connection;
    }
    
    public void run() {
        try {
            System.out.println(connection.toString());
    
            InputStreamReader readerConnection = new InputStreamReader(connection.getInputStream());
            BufferedReader reader = new BufferedReader(readerConnection);
            PrintWriter printer = new PrintWriter(connection.getOutputStream(), true);
            
            printer.println("koblet til server");
            
            String data = reader.readLine();
            
            while(data!= null) {
                String[] calc = data.split(" ");
                int sum = 0;
                int one = Integer.parseInt(calc[0]);
                int two = Integer.parseInt(calc[2]);
                if (data.contains("+")) {
                    sum = one + two;
                    printer.println("result = " + sum);
                } else if (data.contains("-")) {
                    sum = one + two;
                    printer.println("result = " + sum);
                }
                data = reader.readLine();
            }
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

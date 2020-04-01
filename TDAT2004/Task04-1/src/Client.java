import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        final int PORT = 1991;
        
        try {
            Scanner in = new Scanner(System.in);
            Socket connection = new Socket("localhost", PORT);
    
            InputStreamReader readerConnection = new InputStreamReader(connection.getInputStream());
            BufferedReader reader = new BufferedReader(readerConnection);
            PrintWriter writer = new PrintWriter(connection.getOutputStream(), true);
            
            String data = reader.readLine();
            
            while (data != null ) {
                System.out.println(data);
                System.out.println("Skriv inn regnestykke separarert med mellomrom, eks: (1 + 1)");
                String calc = in.nextLine();
                writer.println(calc);
                data = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

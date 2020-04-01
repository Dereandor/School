import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        final int PORT = 1991;
    
        Scanner readFromCMD = new Scanner(System.in);
        System.out.println("enter name of computer where server is running");
        String server = readFromCMD.nextLine();
    
        Socket connection = new Socket(server, PORT);
        System.out.println("Connection established");
    
        InputStreamReader readerConnection = new InputStreamReader(connection.getInputStream());
        BufferedReader reader = new BufferedReader(readerConnection);
        PrintWriter printer = new PrintWriter(connection.getOutputStream(), true);
    
        System.out.println("Skriv et regnestykke, eller close for å lukke");
        while (true) {
            String data = reader.readLine();
            if (data.equals("close")) {
                break;
            } else {
                printer.println(data);
                String result = reader.readLine();
                System.out.println("result: " + result);
                System.out.println("Skriv et regnestykke, eller close for å lukke");
            }
            
            
            
        }
        reader.close();
        printer.close();
        connection.close();
        readFromCMD.close();
    }
}

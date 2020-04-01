import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        final int PORT = 1991;
    
        try {
            ServerSocket server = new ServerSocket(PORT);
    
            System.out.println("Serverside log: ");
            while(true) {
                Socket connection = server.accept();
                //Thread clientWeb = new WebClient(connection);
                Thread clientCalc = new Calculator(connection);
                //clientWeb.start();
                clientCalc.start();
            }
        } catch (IOException e) {
            System.out.println("IOException: ");
            e.printStackTrace();
        }
    }
}
